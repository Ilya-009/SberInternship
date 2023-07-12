package com.sbertech.task3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.http.HttpRequest;

public class YandexHandlerBase<Q extends HttpRequest, S> extends ServiceHandlerBase <Q, S> {

    @Override
    protected boolean validateRequest(Q request) {
        return request.uri() != null && !request.uri().toString().equals("") && request.uri().toString().contains("yandex");
    }

    @Override
    protected boolean validateResponse(S httpResponse) {
        if (httpResponse == null) {
            return false;
        }

        try (
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)
        ) {
            objectOutputStream.writeObject(httpResponse);
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
