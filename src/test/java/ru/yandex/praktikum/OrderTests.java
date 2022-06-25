package ru.yandex.praktikum;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.scooter.api.model.Order;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.junit.Assert.*;
import static ru.yandex.praktikum.scooter.api.OrderClient.createOrder;
import static ru.yandex.praktikum.scooter.api.OrderClient.getAllOrdersList;

@RunWith(Parameterized.class)
public class OrderTests {

    private Order order;

    @Parameterized.Parameter(0)
    public String[] colors;

    @Parameterized.Parameters(name = "Test Data: {0}")
    public static Object[] getColorData() {
        return new Object[][]{
                {new String[]{"BLACK, GREY"}}, {new String[]{"BLACK"}}, {new String[]{"GREY"}}, {new String[]{""}}
        };
    }

    @Before
    public void init() {
        order = new Order(colors);
    }

    @Test
    @DisplayName("Order creation")
    @Severity(SeverityLevel.BLOCKER)
    public void orderCreationTest() {
        Response responseCreateOrder = createOrder(order);
        assertEquals(SC_CREATED, responseCreateOrder.statusCode());
        assertTrue(responseCreateOrder.body().jsonPath().getInt("track") != 0);
    }

    @Test
    @DisplayName("Getting the list of all available orders")
    @Severity(SeverityLevel.BLOCKER)
    public void getAllOrdersListTest() {
        Response responseGetAllOrdersList = getAllOrdersList();
        assertFalse(responseGetAllOrdersList.body().jsonPath().getList("orders").isEmpty());
    }
}
