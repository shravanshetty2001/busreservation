import { TestBed } from '@angular/core/testing';

import { AdminupdatepasswordService } from './adminupdatepassword.service';

describe('AdminupdatepasswordService', () => {
  let service: AdminupdatepasswordService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminupdatepasswordService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
