package com.example.carrental;

public class Main {
    public static void main(String[] args) {
        CarRentalSystem carRentalSystem = new CarRentalSystem();

        carRentalSystem.addCar("JH1010", new Car("Toyota", "Fortuner"));
        carRentalSystem.addCar("JH1011", new Car("Honda", "Honda City"));
        carRentalSystem.addCar("JH1012", new Car("Nissan", "Micra"));
        carRentalSystem.updateCar("JH1012", new Car("Suzuki", "Swift Dezire"));
        System.out.println();

        carRentalSystem.deleteCar("JH1011");
        System.out.println();


        carRentalSystem.addCustomer("CUST001", new Customer("Nicky", "+91XXXXXXXXXX"));
        carRentalSystem.addCustomer("CUST002", new Customer("Riya", "+91XXXXXXZXXX"));
        carRentalSystem.addCustomer("CUST003", new Customer("Jasmine", "+91XXYXXXXXXX"));
        System.out.println();


        carRentalSystem.updateCustomer("CUST002", new Customer("Priya", "+91XXXBXAZXXX"));
        System.out.println();

        carRentalSystem.displayAvailableCars();
        System.out.println();

        carRentalSystem.rentCar("JH1010", "CUST001", "30-12-23", 5);
        System.out.println();

        carRentalSystem.returnCar("JH1010","31-12-23");
        System.out.println();

        carRentalSystem.displayRentedHistory();


    }
}
