package com.example.carrental;

import java.util.HashMap;
import java.util.Map;

public class CarRentalSystem {
    private Map<String, Boolean> carAvailability;
    private Map<String, Car> carDetails;
    private Map<String, Customer> customerDetails;
    private Map<String, RentalHistory> rentalHistory;

    public CarRentalSystem() {
        this.carAvailability = new HashMap<>();
        this.carDetails = new HashMap<>();
        this.customerDetails = new HashMap<>();
        this.rentalHistory = new HashMap<>();
    }

    //Method to add a new Car
    public void addCar(String registrationNumber, Car car) {
        if (!carAvailability.containsKey(registrationNumber)) {
            carDetails.put(registrationNumber, car);
            carAvailability.put(registrationNumber, true);
            System.out.println("car with registration number" + registrationNumber + "added");
        } else {
            System.out.println("car with registration number" + registrationNumber + "already exits");
        }
    }

    //    Method to display the list of available cars
    public void displayAvailableCars() {
        System.out.println("List of Available Cars");
        for (Map.Entry<String, Boolean> entry : carAvailability.entrySet()) {
            if (entry.getValue()) {
                System.out.println("Registration No.: " + entry.getKey());
            }
        }
    }

    //  update
    public void updateCar(String registrationNumber, Car updatedCar) {
        if (carDetails.containsKey(registrationNumber)) {
            carDetails.put(registrationNumber, updatedCar);
            System.out.println("Car details updated for registration number" + registrationNumber);
        } else {
            System.out.println("Car with registration number" + registrationNumber + "does not exit in the system");
        }

    }

    public void deleteCar(String registrationNumber) {
        if (carDetails.containsKey(registrationNumber)) {
            carDetails.remove(registrationNumber);
            carAvailability.remove(registrationNumber);
            System.out.println("Car with registration number " + registrationNumber + " deleted from the system.");
        } else {
        }
        System.out.println("Car with registration number " + registrationNumber + " does not exist in the system.");
    }

    public void addCustomer(String cusId, Customer customer) {
        if (!customerDetails.containsKey(cusId)) {
            customerDetails.put(cusId, customer);
            System.out.println("Customer with id " + cusId + " added in the system");
        } else {
            System.out.println("Customer already exist in the system");
        }
    }

    public void updateCustomer(String cusId, Customer updatedCustomer) {
        if (customerDetails.containsKey(cusId)) {
            customerDetails.put(cusId, updatedCustomer);
            System.out.println("Customer details updated for ID " + cusId);
        } else {
            System.out.println("Customer with ID " + cusId + " does not exist in the system.");
        }
    }

    public void deleteCustomer(String cusId) {
        if (customerDetails.containsKey(cusId)) {
            customerDetails.remove(cusId);
            System.out.println("Customer with ID " + cusId + " deleted from the system.");
        } else {
            System.out.println("Customer with ID " + cusId + " does not exist in the system.");
        }
    }

    public void rentCar(String registrationNumber, String customerId, String rentalDate, int rentalDuration) {
        if (carAvailability.containsKey(registrationNumber) && customerDetails.containsKey(customerId)) {
            if (carAvailability.get(registrationNumber)) {
                Car car = carDetails.get(registrationNumber);
                Customer customer = customerDetails.get(customerId);

                carAvailability.put(registrationNumber, false);

                RentalHistory rentalRecord = new RentalHistory(rentalDate, null, rentalDuration, customer, car);
                rentalHistory.put(registrationNumber, rentalRecord);

                System.out.println("Car with registration number " + registrationNumber + " rented by customer ID " + customerId);
            } else {
                System.out.println("Car with registration number " + registrationNumber + " is already rented.");
            }
        } else {
            System.out.println("Car or customer not found in the system.");
        }
    }

    public void returnCar(String registrationNumber, String returnDate) {
        if (carAvailability.containsKey(registrationNumber) && rentalHistory.containsKey(registrationNumber)) {
            if (!carAvailability.get(registrationNumber)) {
                RentalHistory rentalRecord = rentalHistory.get(registrationNumber);

                carAvailability.put(registrationNumber, true);

                rentalRecord.setReturnDate(returnDate);

                System.out.println("Car with registration number " + registrationNumber + " returned.");
            } else {
                System.out.println("Car with registration number " + registrationNumber + " is not currently rented.");
            }
        } else {
            System.out.println("Car or rental record not found in the system.");
        }
    }

    public void displayRentedHistory() {
        System.out.println("List of Rented Cars");
        for (Map.Entry<String, RentalHistory> entry : rentalHistory.entrySet()) {
            System.out.println("Registration no: " + entry.getKey() + "\nRented Date: " + entry.getValue().getRentalDate() + "\nCustomer Name: " + entry.getValue().getCustomer().getName() + "\nCar Model Name: " + entry.getValue().getCar().getModel());
        }
    }
}







