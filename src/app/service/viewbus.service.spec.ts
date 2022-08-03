import { TestBed } from '@angular/core/testing';

import { ViewbusService } from './viewbus.service';

describe('ViewbusService', () => {
  let service: ViewbusService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViewbusService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
