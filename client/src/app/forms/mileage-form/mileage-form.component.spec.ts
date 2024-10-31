import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MileageFormComponent } from './mileage-form.component';

describe('MileageFormComponent', () => {
  let component: MileageFormComponent;
  let fixture: ComponentFixture<MileageFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MileageFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MileageFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
