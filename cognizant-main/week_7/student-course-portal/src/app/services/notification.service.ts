import { Injectable } from '@angular/core';

// Note: Intentionally NOT providedIn: 'root' to support component-level providers
@Injectable()
export class NotificationService {
  private instanceId = Math.floor(Math.random() * 10000);

  log(message: string): void {
    console.log(`[NotificationService #${this.instanceId}]: ${message}`);
  }
}
