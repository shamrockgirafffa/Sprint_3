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

public class CourierCreationPositiveTest {
    private int courierId;
    Courier courier;

    @Before
    public void init() {
        courier = new Courier();
    }

    @After
    public void cleanup() {
        CourierCredentials courierCredentials = new CourierCredentials(courier.getLogin(), courier.getPassword());
        Response responseLogin = login(courierCredentials);
        assertEquals(SC_OK, responseLogin.statusCode());
        courierId = responseLogin.body().jsonPath().getInt("id");
        deleteCourier(courierId);
    }

    @Test
    @DisplayName("Courier creation")
    @Severity(SeverityLevel.BLOCKER)
    public void courierCreationTest() {
        Response responseCreate = createCourier(courier);
        assertEquals(responseCreate.statusCode(), SC_CREATED);
        assertTrue(responseCreate.body().jsonPath().getBoolean("ok"));
    }

    @Test
    @DisplayName("Attempt to create the second courier with the same data")
    @Severity(SeverityLevel.CRITICAL)
    public void courierDoubleCreationTest() {
        Response responseCreate = createCourier(courier);
        Response responseCreateTheSameLogin = createCourier(courier);

        assertEquals(responseCreateTheSameLogin.statusCode(), SC_CONFLICT);
        assertEquals("Этот логин уже используется. Попробуйте другой.", responseCreateTheSameLogin.body().jsonPath().getString("message"));
    }

}
