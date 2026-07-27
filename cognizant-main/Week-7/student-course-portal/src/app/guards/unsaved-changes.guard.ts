import { CanDeactivateFn } from '@angular/router';
import { ReactiveEnrollmentForm } from '../pages/reactive-enrollment-form/reactive-enrollment-form';

export const unsavedChangesGuard: CanDeactivateFn<ReactiveEnrollmentForm> = (component) => {
  if (component.enrollForm && component.enrollForm.dirty && !component.isSubmitted) {
    return window.confirm('You have unsaved form changes. Are you sure you want to leave?');
  }
  return true;
};
