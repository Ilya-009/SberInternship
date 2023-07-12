package com.sbertech.task3;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

class ServiceHandlerBaseTest {

    private static final HttpRequest GOOGLE_REQUEST;
    private static final HttpRequest YANDEX_REQUEST;

    static {
        try {
            var googleUri = new URI("https://www.google.com/");
            var yandexUri = new URI("https://yandex.ru/search/?text=java&lr=0&search_source=yaru_desktop_common");

            GOOGLE_REQUEST = HttpRequest.newBuilder()
                .uri(googleUri)
                .GET()
                .build();

            YANDEX_REQUEST = HttpRequest.newBuilder()
                    .uri(yandexUri)
                    .GET()
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private static final ServiceHandlerBase<HttpRequest, String> GOOGLE_SERVICE_HANDLER = new GoogleServiceHandler<>();
    private static final ServiceHandlerBase<HttpRequest, Object> YANDEX_SERVICE_HANDLER = new YandexHandlerBase<>();

    @Test
    void makeRequest() {
        String s = GOOGLE_SERVICE_HANDLER.makeRequest(GOOGLE_REQUEST);
        Object o = YANDEX_SERVICE_HANDLER.makeRequest(YANDEX_REQUEST);
    }
}