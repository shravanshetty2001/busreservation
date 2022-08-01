import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewbustimetableComponent } from './viewbustimetable.component';

describe('ViewbustimetableComponent', () => {
  let component: ViewbustimetableComponent;
  let fixture: ComponentFixture<ViewbustimetableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewbustimetableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewbustimetableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
