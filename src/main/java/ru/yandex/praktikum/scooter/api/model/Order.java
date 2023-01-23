package ru.yandex.praktikum.scooter.api.model;

import com.github.javafaker.Faker;
import java.util.Date;

public class Order {
    public Order(String[] color){
        Faker faker = new Faker();
        Date date = new Date();
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.address = faker.address().streetAddress();
        this.metroStation = "Сокольники";
        this.phone = "+79602464452";
        this.deliveryDate = "\"2023-08-30 00:00:00-06\"";
        this.rentTime = faker.number().numberBetween(1,30);
        this.comment = faker.company().buzzword();
        this.color = color;
    }

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public void setMetroStation(String metroStation) {
        this.metroStation = metroStation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRentTime() {
        return rentTime;
    }

    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String[] getColoroptional() {
        return color;
    }

    public void setColoroptional(String[] color) {
        this.color = color;
    }

    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private int  rentTime;
    private String deliveryDate;
    private String comment;
    private String[] color;
}
