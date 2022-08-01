import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminforgotpasswordComponent } from './adminforgotpassword.component';

describe('AdminforgotpasswordComponent', () => {
  let component: AdminforgotpasswordComponent;
  let fixture: ComponentFixture<AdminforgotpasswordComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminforgotpasswordComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminforgotpasswordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
