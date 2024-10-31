import { VehicleMileagesInterface } from "./vehicle.mileages.interface";

export interface VehicleInterface {
    id: string,
    year: string,
    manufacturer: string,
    model: string,
    type: string,
    fuelType: string,
    wltpEnergyConsumption: number | null,
    nedcEnergyConsumption: number | null,
    vehicleMileages: VehicleMileagesInterface[] | null
}