import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { map, catchError, tap, retry } from 'rxjs/operators';
import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private apiUrl = 'http://localhost:3000/courses';

  // Local fallback mock data in case json-server is not running
  private mockCourses: Course[] = [
    { id: 101, name: 'Angular Framework', code: 'CS-ANG20', credits: 4, gradeStatus: 'passed' },
    { id: 102, name: 'Java Full Stack', code: 'CS-JAVA8', credits: 4, gradeStatus: 'passed' },
    { id: 103, name: 'Database Management', code: 'CS-DBMS', credits: 3, gradeStatus: 'failed' },
    { id: 104, name: 'Cloud Architecture', code: 'CS-AWS', credits: 1, gradeStatus: 'pending' },
    { id: 105, name: 'UI/UX Design', code: 'CS-UIUX', credits: 2, gradeStatus: 'pending' }
  ];

  constructor(private http: HttpClient) {}

  getCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(this.apiUrl).pipe(
      retry(2), // Task 2: Retry failed HTTP requests twice
      tap(courses => console.log('HTTP Courses loaded:', courses.length)), // Task 2: Side effect logging
      map(courses => courses.filter(c => c.credits > 0)), // Task 2: RxJS Transformation
      catchError(err => {
        console.warn('Backend API offline, serving local stream data:', err.message);
        return of(this.mockCourses);
      })
    );
  }

  getCourseById(id: number): Observable<Course | undefined> {
    return this.http.get<Course>(`${this.apiUrl}/${id}`).pipe(
      catchError(() => of(this.mockCourses.find(c => c.id === id)))
    );
  }

  createCourse(course: Omit<Course, 'id'>): Observable<Course> {
    return this.http.post<Course>(this.apiUrl, course).pipe(
      catchError(err => throwError(() => new Error('Failed to create course on server')))
    );
  }

  deleteCourse(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
