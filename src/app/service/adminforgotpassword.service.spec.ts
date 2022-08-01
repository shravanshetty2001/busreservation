import { TestBed } from '@angular/core/testing';

import { AdminforgotpasswordService } from './adminforgotpassword.service';

describe('AdminforgotpasswordService', () => {
  let service: AdminforgotpasswordService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminforgotpasswordService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
