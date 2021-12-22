import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DynamicAPICallComponent } from './dynamic-apicall.component';

describe('DynamicAPICallComponent', () => {
  let component: DynamicAPICallComponent;
  let fixture: ComponentFixture<DynamicAPICallComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DynamicAPICallComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DynamicAPICallComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
