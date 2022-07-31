import { TestBed } from '@angular/core/testing';

import { AdminregisterService } from './adminregister.service';

describe('AdminregisterService', () => {
  let service: AdminregisterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminregisterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
