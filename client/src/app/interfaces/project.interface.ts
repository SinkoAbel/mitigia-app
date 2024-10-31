import { VehicleInterface } from "./vehicle.interface";

export interface ProjectInterface {
    id: number,
    licencePlate: string,
    vehicle: VehicleInterface,
    startDate: Date,
    endDate: Date,
    startOdo: number,
    lastOdo: number,
    lastMileage: any
}