import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Course } from '../models/course.model';
import { CourseService } from '../services/course.service';

export interface CourseState {
  courses: Course[];
  enrolledCourseIds: number[];
  selectedCourseId: number | null;
  searchTerm: string;
  loading: boolean;
  error: string | null;
}

const initialState: CourseState = {
  courses: [],
  enrolledCourseIds: [],
  selectedCourseId: null,
  searchTerm: '',
  loading: false,
  error: null
};

@Injectable({
  providedIn: 'root'
})
export class CourseStore {
  private state$ = new BehaviorSubject<CourseState>(initialState);

  // Selectors
  readonly courses$: Observable<Course[]> = this.state$.pipe(
    map(state => {
      if (!state.searchTerm.trim()) return state.courses;
      return state.courses.filter(c =>
        c.name.toLowerCase().includes(state.searchTerm.toLowerCase()) ||
        c.code.toLowerCase().includes(state.searchTerm.toLowerCase())
      );
    })
  );

  readonly enrolledCourses$: Observable<Course[]> = this.state$.pipe(
    map(state => state.courses.filter(c => state.enrolledCourseIds.includes(c.id)))
  );

  readonly enrolledCount$: Observable<number> = this.state$.pipe(
    map(state => state.enrolledCourseIds.length)
  );

  readonly totalCoursesCount$: Observable<number> = this.state$.pipe(
    map(state => state.courses.length)
  );

  readonly loading$: Observable<boolean> = this.state$.pipe(
    map(state => state.loading)
  );

  readonly error$: Observable<string | null> = this.state$.pipe(
    map(state => state.error)
  );

  constructor(private courseService: CourseService) {}

  // Current State Snapshot Getter
  private get state(): CourseState {
    return this.state$.getValue();
  }

  // State Mutator Helper
  private setState(newState: Partial<CourseState>): void {
    this.state$.next({ ...this.state, ...newState });
  }

  // Actions
  loadCourses(): void {
    this.setState({ loading: true, error: null });
    this.courseService.getCourses().subscribe({
      next: (courses) => {
        this.setState({ courses, loading: false });
      },
      error: (err) => {
        this.setState({ error: err.message || 'Failed to fetch courses', loading: false });
      }
    });
  }

  toggleEnrollment(courseId: number): void {
    const currentEnrolled = [...this.state.enrolledCourseIds];
    const index = currentEnrolled.indexOf(courseId);
    
    if (index > -1) {
      currentEnrolled.splice(index, 1);
    } else {
      currentEnrolled.push(courseId);
    }

    this.setState({ 
      enrolledCourseIds: currentEnrolled,
      selectedCourseId: courseId
    });
  }

  setSearchTerm(term: string): void {
    this.setState({ searchTerm: term });
  }

  isEnrolled(courseId: number): boolean {
    return this.state.enrolledCourseIds.includes(courseId);
  }
}
