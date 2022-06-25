package ru.yandex.praktikum.scooter.api;

import io.restassured.response.Response;
import ru.yandex.praktikum.scooter.api.model.Order;

import static io.restassured.RestAssured.given;

public class OrderClient extends BaseApiClient {
    public static Response createOrder(Order order) {
        return given()
                .spec(getRequestSpecification())
                .body(order)
                .when()
                .post(BASE_URL + "/api/v1/orders");
    }

    public static Response getAllOrdersList() {
        return given()
                .spec(getRequestSpecification())
                .when()
                .get(BASE_URL + "/api/v1/orders");
    }
}
