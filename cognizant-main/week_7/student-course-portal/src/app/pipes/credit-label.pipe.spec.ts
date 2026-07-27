import { describe, it, expect, beforeEach } from 'vitest';
import { CreditLabelPipe } from './credit-label.pipe';

describe('CreditLabelPipe', () => {
  let pipe: CreditLabelPipe;

  beforeEach(() => {
    pipe = new CreditLabelPipe();
  });

  it('should create an instance', () => {
    expect(pipe).toBeTruthy();
  });

  it('should format singular credit correctly', () => {
    expect(pipe.transform(1)).toBe('1 Credit');
  });

  it('should format plural credits correctly', () => {
    expect(pipe.transform(4)).toBe('4 Credits');
  });

  it('should handle zero or falsy inputs based on pipe implementation', () => {
    expect(pipe.transform(0)).toBe('No Credits');
    expect(pipe.transform(null as any)).toBe('No Credits');
  });
});
