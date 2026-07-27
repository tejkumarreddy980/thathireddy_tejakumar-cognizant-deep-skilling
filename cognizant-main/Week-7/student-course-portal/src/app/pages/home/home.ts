import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CourseStore } from '../../store/course.store';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {
  public store = inject(CourseStore);

  portalName = 'Student Course Portal';
  isPortalActive = true;
  message = '';
  
  totalCourses$ = this.store.totalCoursesCount$;
  enrolledCount$ = this.store.enrolledCount$;

  onSearchChange(term: string): void {
    this.store.setSearchTerm(term);
  }

  onEnrollClick(): void {
    this.message = 'Enrollment opened!';
  }
}
