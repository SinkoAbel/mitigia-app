import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { ProjectService } from '../services/project.service';
import { ProjectInterface } from '../interfaces/project.interface';

@Component({
  selector: 'app-table',
  standalone: true,
  imports: [
    CommonModule,
    HttpClientModule
  ],
  templateUrl: './table.component.html',
  styleUrl: './table.component.css'
})
export class TableComponent {
  projects: ProjectInterface[] = [];

  constructor(private projectService: ProjectService) {}

  fetchData(): void {
    this.projectService.getProjects().subscribe(data => {
      
      this.projects = data.map(project => {
        if(project.vehicle.vehicleMileages && project.vehicle.vehicleMileages.length > 0) {
          const lastMileage = project.vehicle.vehicleMileages.reduce((prev, current) => {
            return new Date(prev.date) > new Date(current.date) ? prev : current;
          });

          project.lastMileage = lastMileage;
        }

        return project;
      });
    }, error => {
      console.error(error);
    });
  }

  ngOnInit(): void {
    this.fetchData();
  }
}
