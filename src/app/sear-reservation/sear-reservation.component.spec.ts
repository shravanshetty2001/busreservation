import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearReservationComponent } from './sear-reservation.component';

describe('SearReservationComponent', () => {
  let component: SearReservationComponent;
  let fixture: ComponentFixture<SearReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearReservationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
