package com.pluralsight;

import java.time.LocalDate;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired,
                   double originalCost, String makeModel,
                   int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        LocalDate currentYear = LocalDate.now();
        int vehicleAge = currentYear.getYear() - year;

        double finalValue;
        if (vehicleAge <= 3) {
            finalValue = ((getOriginalCost()) - (0.03 * getOriginalCost()));
        } else if (vehicleAge <= 6) {
            finalValue = ((getOriginalCost()) - (0.06 * getOriginalCost()));
        } else if (vehicleAge <= 10) {
            finalValue = ((getOriginalCost()) - (0.08 * getOriginalCost()));
        } else {
            finalValue = 1000.0;
        }

        if (makeModel.equalsIgnoreCase("Honda") ||
                makeModel.equalsIgnoreCase("Toyota")) {

        }

    }

}
