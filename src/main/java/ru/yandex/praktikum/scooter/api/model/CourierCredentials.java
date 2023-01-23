package ru.yandex.praktikum.scooter.api.model;

import com.github.javafaker.Faker;

public class CourierCredentials {
    private String login;
    private String password;


    public CourierCredentials(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void corruptLogin() {
        Faker faker = new Faker();
        login += faker.lorem().characters(1);
    }

    public void corruptPassword() {
        Faker faker = new Faker();
        password += faker.lorem().characters(1);
    }

    public void removeLogin() {
        login = "";
    }

    public void removePassword() {
        password = "";
    }
}
