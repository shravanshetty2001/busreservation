import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddbustimetableComponent } from './addbustimetable.component';

describe('AddbustimetableComponent', () => {
  let component: AddbustimetableComponent;
  let fixture: ComponentFixture<AddbustimetableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddbustimetableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddbustimetableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
