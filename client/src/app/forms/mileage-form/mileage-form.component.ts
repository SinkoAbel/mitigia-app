import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MileageService } from '../../services/mileage.service';
import { Mileage } from '../../models/Mileage';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-mileage-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './mileage-form.component.html',
  styleUrl: './mileage-form.component.css'
})
export class MileageFormComponent implements OnInit {
  mileageForm: FormGroup;
  errorMsg: string = '';
  successMsg: string = '';

  @Output() formSubmitted = new EventEmitter<void>();

  constructor(private service: MileageService) {
    this.mileageForm = new FormGroup({
      licenceField: new FormControl(
        '',
        [
          Validators.required,
          Validators.minLength(6),
          Validators.maxLength(6)
        ]
      ),
      dateField: new FormControl(
        '',
        [Validators.required]
      ),
      mileageField: new FormControl(
        '',
        [Validators.required]
      )
    });
  }

  ngOnInit(): void {
  }

  newMileageData(): void {
    let mileage = new Mileage(
      this.mileageForm.value.licenceField,
      this.mileageForm.value.dateField,
      this.mileageForm.value.mileageField
    );

    this.service.addNewMileage(mileage)
      .subscribe({
        next: (response): void => {
          console.log(response);
          this.errorMsg = '';
          this.successMsg = 'Milage saved successfully.'

          this.formSubmitted.emit();
          this.mileageForm.reset();
        },
        error: (error): void => {
          console.log(error);
          this.errorMsg = error.message;
        },
        complete: (): void => {

        }
      });
  }
}
