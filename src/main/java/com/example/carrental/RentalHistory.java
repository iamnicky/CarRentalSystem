package com.example.carrental;

class RentalHistory {
    private String rentalDate;
    private String returnDate;
    private int rentalDuration;
    private Customer customer;
    private Car car;

    public RentalHistory(String rentalDate, String returnDate, int rentalDuration, Customer customer, Car car) {
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.rentalDuration = rentalDuration;
        this.customer = customer;
        this.car = car;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
