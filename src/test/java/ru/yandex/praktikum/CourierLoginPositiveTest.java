package ru.yandex.praktikum;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.scooter.api.model.Courier;
import ru.yandex.praktikum.scooter.api.model.CourierCredentials;

import static org.apache.http.HttpStatus.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.scooter.api.CourierClient.*;

public class CourierLoginPositiveTest {
    private int courierId = 0;
    private Response responseCreate;
    Courier courier;

    @Before
    public void init() {
        courier = new Courier();
        responseCreate = createCourier(courier);
        assertEquals(responseCreate.statusCode(), SC_CREATED);
        assertTrue(responseCreate.body().jsonPath().getBoolean("ok"));
    }

    @After
    public void cleanup() {
        deleteCourier(courierId);
    }

    @Test
    @DisplayName("Login for the courier with the correct credentials")
    @Severity(SeverityLevel.BLOCKER)
    public void courierLoginCorrectCredentialsTest() {
        CourierCredentials courierCredentials = new CourierCredentials(courier.getLogin(), courier.getPassword());
        Response responseLogin = login(courierCredentials);
        assertEquals(SC_OK, responseLogin.statusCode());
        courierId = responseLogin.body().jsonPath().getInt("id");
        assertTrue(courierId != 0);
    }

}
