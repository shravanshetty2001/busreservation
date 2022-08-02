import { NO_ERRORS_SCHEMA } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusListRenderComponent } from './bus-list-render.component';

describe('BusListRenderComponent', () => {
  let component: BusListRenderComponent;
  let fixture: ComponentFixture<BusListRenderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BusListRenderComponent ],
      schemas: [NO_ERRORS_SCHEMA]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BusListRenderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
