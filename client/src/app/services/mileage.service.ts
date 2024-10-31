import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Mileage } from "../models/Mileage";
import { environment } from "../../environment/environment";

@Injectable({
    providedIn: 'root'
})
export class MileageService {
    private endpoint: string = environment.API_BASE_URL + "/vehicle/store/mileage";

    constructor(private httpClient: HttpClient) {}

    addNewMileage(mileageData: Mileage) {

        const header = {
            'content-type': 'application/json'
        };

        const body: string = JSON.stringify({
            licence_plate: mileageData.licencePlate,
            date: mileageData.date,
            mileage: mileageData.actualMileage
        });

        return this.httpClient.post<any>(this.endpoint, body, {headers: header});
    }
}