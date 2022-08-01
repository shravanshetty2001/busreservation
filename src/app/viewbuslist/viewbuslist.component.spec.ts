import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewbuslistComponent } from './viewbuslist.component';

describe('ViewbuslistComponent', () => {
  let component: ViewbuslistComponent;
  let fixture: ComponentFixture<ViewbuslistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewbuslistComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewbuslistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
