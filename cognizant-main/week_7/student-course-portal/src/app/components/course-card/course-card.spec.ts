import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CourseCard } from './course-card';

describe('CourseCard', () => {
  let component: CourseCard;
  let fixture: ComponentFixture<CourseCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseCard]
    }).compileComponents();

    fixture = TestBed.createComponent(CourseCard);
    component = fixture.componentInstance;

    component.course = {
      id: 101,
      name: 'Angular Framework',
      code: 'CS-ANG20',
      credits: 4,
      gradeStatus: 'passed'
    };

    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should display course title in the HTML', () => {
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h3')?.textContent).toContain('Angular Framework');
  });

  it('should emit enrollRequested event when Enroll button is clicked', () => {
    let emittedId: number | undefined;
    component.enrollRequested.subscribe((id) => (emittedId = id));

    const enrollBtn = fixture.nativeElement.querySelector('button') as HTMLButtonElement;
    enrollBtn.click();

    expect(emittedId).toBe(101);
  });
});
