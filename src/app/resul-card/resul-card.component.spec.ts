import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResulCardComponent } from './resul-card.component';

describe('ResulCardComponent', () => {
  let component: ResulCardComponent;
  let fixture: ComponentFixture<ResulCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResulCardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResulCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
