import { HttpInterceptorFn } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';

export const errorHandlerInterceptor: HttpInterceptorFn = (req, next) => {
  return next(req).pipe(
    catchError((error) => {
      console.error('[Global HTTP Interceptor Error]:', error);
      if (error.status === 401) {
        alert('Session expired or unauthorized. Redirecting...');
      }
      return throwError(() => new Error(error.message || 'Server error occurred'));
    })
  );
};
