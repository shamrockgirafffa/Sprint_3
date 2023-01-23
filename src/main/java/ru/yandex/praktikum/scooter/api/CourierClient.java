package ru.yandex.praktikum.scooter.api;

import io.restassured.response.Response;
import ru.yandex.praktikum.scooter.api.model.Courier;
import ru.yandex.praktikum.scooter.api.model.CourierCredentials;

import static io.restassured.RestAssured.given;


public class CourierClient extends BaseApiClient {

    public static Response createCourier(Courier courier) {
        return given()
                .spec(getRequestSpecification())
                .body(courier)
                .when()
                .post(BASE_URL + "/api/v1/courier/");
    }

    public static Response login(CourierCredentials courierCredentials) {
        return given()
                .spec(getRequestSpecification())
                .body(courierCredentials)
                .when()
                .post(BASE_URL + "/api/v1/courier/login");
    }

    public static Boolean deleteCourier(int idCourier) {
        return given()
                .spec(getRequestSpecification())
                .when()
                .delete(BASE_URL + "/api/v1/courier/" + idCourier)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("ok");
    }

}
