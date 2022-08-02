import { TestBed } from '@angular/core/testing';

import { AddBusDtoService } from './add-bus-dto.service';

describe('AddBusDtoService', () => {
  let service: AddBusDtoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddBusDtoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
