import { TestBed } from '@angular/core/testing';

import { BustimetableService } from './bustimetable.service';

describe('BustimetableService', () => {
  let service: BustimetableService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BustimetableService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
