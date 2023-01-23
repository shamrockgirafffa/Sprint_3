package ru.yandex.praktikum.scooter.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseApiClient {
    public final static String BASE_URL = "http://qa-scooter.praktikum-services.ru";

    public static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder().log(LogDetail.ALL)
                .setContentType(ContentType.JSON).build();
    }

    public static ResponseSpecification getResponseSpecification() {
        return new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }
}
