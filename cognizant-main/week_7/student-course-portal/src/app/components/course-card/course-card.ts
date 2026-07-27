import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { CreditLabelPipe } from '../../pipes/credit-label.pipe';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, CreditLabelPipe],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard {
  @Input() course!: {
    id: number;
    name: string;
    code: string;
    credits: number;
    gradeStatus?: 'passed' | 'failed' | 'pending';
  };
  @Input() isEnrolled = false;
  @Output() enrollRequested = new EventEmitter<number>();

  constructor(private router: Router) {}

  get cardClasses() {
    return {
      'card--enrolled': this.isEnrolled,
      'card--full': this.course.credits >= 4
    };
  }

  get borderStyle() {
    const status = this.course.gradeStatus || 'pending';
    switch (status) {
      case 'passed': return '4px solid #28a745';
      case 'failed': return '4px solid #dc3545';
      default: return '4px solid #6c757d';
    }
  }

  viewDetails(): void {
    this.router.navigate(['/courses', this.course.id]);
  }

  onEnroll(): void {
    this.enrollRequested.emit(this.course.id);
  }
}
