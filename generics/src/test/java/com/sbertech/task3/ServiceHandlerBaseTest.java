package com.sbertech.task3;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

class ServiceHandlerBaseTest {

    private static final URI GOOGLE_URI;
    private static final URI YANDEX_URI;

    static {
        try {
            GOOGLE_URI = new URI("https://www.google.com/");
            YANDEX_URI = new URI("https://yandex.ru/search/?text=java&lr=0&search_source=yaru_desktop_common");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private static final ServiceHandlerBase GOOGLE_SERVICE_HANDLER = new GoogleServiceHandler(GOOGLE_URI);
    private static final ServiceHandlerBase YANDEX_SERVICE_HANDLER = new YandexHandlerBase(YANDEX_URI);

    @Test
    void makeRequest() throws ExecutionException, InterruptedException {
        String googleResponse = GOOGLE_SERVICE_HANDLER.makeRequest();
        String yandexResponse = YANDEX_SERVICE_HANDLER.makeRequest();
    }
}