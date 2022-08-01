import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminupdatepasswordComponent } from './adminupdatepassword.component';

describe('AdminupdatepasswordComponent', () => {
  let component: AdminupdatepasswordComponent;
  let fixture: ComponentFixture<AdminupdatepasswordComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminupdatepasswordComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminupdatepasswordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
