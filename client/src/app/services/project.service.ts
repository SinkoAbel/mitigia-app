import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "../../environment/environment";
import { ProjectInterface } from "../interfaces/project.interface";


@Injectable({
    providedIn: 'root'
})
export class ProjectService {
    private endpoint = environment.API_BASE_URL;
    
    constructor(private http: HttpClient) {}

    getProjects(): Observable<ProjectInterface[]> {
        return this.http.get<ProjectInterface[]>(`${this.endpoint}/project`);
    }
}