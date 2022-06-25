package ru.yandex.praktikum;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.scooter.api.model.Courier;

import static org.apache.http.HttpStatus.*;
import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.scooter.api.CourierClient.*;

public class CourierCreationNegativeTest {
    Courier courier;

    @Before
    public void init() {
        courier = new Courier();
    }

    @Test
    @DisplayName("Attempt to create a courier without password")
    @Severity(SeverityLevel.MINOR)
    public void courierNoPasswordCreationAttemptTest() {
        courier.setPassword("");
        Response responseCreationAttempt = createCourier(courier);
        assertEquals(responseCreationAttempt.statusCode(), SC_BAD_REQUEST);
        assertEquals("Недостаточно данных для создания учетной записи", responseCreationAttempt.body().jsonPath().getString("message"));
    }

    @Test
    @DisplayName("Attempt to create a courier without login")
    @Severity(SeverityLevel.MINOR)
    public void courierNoLoginCreationAttemptTest() {
        courier.setLogin("");
        Response responseCreationAttempt = createCourier(courier);
        assertEquals(responseCreationAttempt.statusCode(), SC_BAD_REQUEST);
        assertEquals("Недостаточно данных для создания учетной записи", responseCreationAttempt.body().jsonPath().getString("message"));
    }
}
