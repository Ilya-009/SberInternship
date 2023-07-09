package com.sbertech.task3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.net.http.HttpResponse;

public class YandexHandlerBase extends ServiceHandlerBase {

    public YandexHandlerBase(URI uri) {
        super(uri);
    }

    @Override
    protected boolean validateRequest() {
        return uri != null && !uri.toString().equals("") && uri.toString().contains("yandex");
    }

    @Override
    protected <T> boolean validateResponse(HttpResponse<T> httpResponse) {
        if (httpResponse.statusCode() != 200) {
            return false;
        }

        T body = httpResponse.body();

        try (
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)
        ) {
            objectOutputStream.writeObject(body);
            objectOutputStream.flush();

            byte[] bodyBytes = outputStream.toByteArray();

            if (bodyBytes.length == 0) {
                return false;
            }

            System.out.printf("Body bytes length: %d\n", bodyBytes.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
