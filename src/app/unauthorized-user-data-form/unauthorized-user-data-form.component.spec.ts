import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnauthorizedUserDataFormComponent } from './unauthorized-user-data-form.component';

describe('UnauthorizedUserDataFormComponent', () => {
  let component: UnauthorizedUserDataFormComponent;
  let fixture: ComponentFixture<UnauthorizedUserDataFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UnauthorizedUserDataFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UnauthorizedUserDataFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
