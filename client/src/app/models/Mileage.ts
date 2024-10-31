
export class Mileage {
    public licencePlate: string;
    public date: Date;
    public actualMileage: number;

    constructor(licencePlate: string, date: Date, mileage: number) {
        this.licencePlate = licencePlate;
        this.date = date;
        this.actualMileage = mileage;
    }
}