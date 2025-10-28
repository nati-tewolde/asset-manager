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
        int currentYear = LocalDate.now().getYear();
        int vehicleAge = currentYear - year;

        double finalValue = 0;
        if (vehicleAge <= 3) {
            for (int i = 0; i < vehicleAge; i++) {
                finalValue = 0.97 * getOriginalCost();
            }
        } else if (vehicleAge <= 6) {
            for (int i = 0; i < vehicleAge; i++) {
                finalValue = 0.94 * getOriginalCost();
            }
        } else if (vehicleAge <= 10) {
            for (int i = 0; i < vehicleAge; i++) {
                finalValue = 0.92 * getOriginalCost();
            }
        } else {
            finalValue = getOriginalCost() - 1000.0;
        }

        if (!(makeModel.contains("Honda") || makeModel.contains("Toyota"))
                && odometer > 100000) {
            finalValue *= 0.75;
        }

        return finalValue;
    }
}
