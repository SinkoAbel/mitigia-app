import { Component, ViewChild } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TableComponent } from "./table/table.component";
import { MileageFormComponent } from "./forms/mileage-form/mileage-form.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, TableComponent, MileageFormComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'client';

  @ViewChild(TableComponent) tableComponent!: TableComponent;

  onFormSubmitted(): void {
    this.tableComponent.fetchData();
  }
}
