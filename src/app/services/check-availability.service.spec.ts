import { TestBed } from '@angular/core/testing';

import { CheckAvailabilityService } from './check-availability.service';

describe('CheckAvailabilityService', () => {
  let service: CheckAvailabilityService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CheckAvailabilityService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
