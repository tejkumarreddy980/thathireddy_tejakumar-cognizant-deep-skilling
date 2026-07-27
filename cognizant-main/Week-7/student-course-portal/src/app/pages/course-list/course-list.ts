import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../../components/course-card/course-card';
import { HighlightDirective } from '../../directives/highlight.directive';
import { CourseStore } from '../../store/course.store';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCard, HighlightDirective],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {
  public store = inject(CourseStore);

  courses$ = this.store.courses$;
  loading$ = this.store.loading$;
  error$ = this.store.error$;

  ngOnInit(): void {
    this.store.loadCourses();
  }

  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }

  onEnroll(courseId: number): void {
    this.store.toggleEnrollment(courseId);
  }

  isEnrolled(courseId: number): boolean {
    return this.store.isEnrolled(courseId);
  }
}
