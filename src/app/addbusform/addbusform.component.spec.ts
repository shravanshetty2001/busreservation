import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddbusformComponent } from './addbusform.component';

describe('AddbusformComponent', () => {
  let component: AddbusformComponent;
  let fixture: ComponentFixture<AddbusformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddbusformComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddbusformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
