package ru.yandex.praktikum.scooter.api.model;
import com.github.javafaker.Faker;

public class Courier {
    private String login;

    public Courier() {
        Faker faker = new Faker();
        this.login = faker.name().lastName() + faker.lorem().characters(1);
        this.password = faker.lorem().characters(8);
        this.firstName = faker.name().firstName();
    }

    public Courier(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    public Courier(String login, String firstName) {
        this.login = login;
        this.firstName = firstName;
    }

    /*public Courier(String firstName, String password) {
        this.firstName = firstName;
        this.password = password;
    }*/

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String firstName;
}
