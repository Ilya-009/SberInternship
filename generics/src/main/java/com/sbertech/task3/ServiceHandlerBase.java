package com.sbertech.task3;

import java.net.http.HttpRequest;

public abstract class ServiceHandlerBase<Q extends HttpRequest, S> {
    public S makeRequest(Q request) {
        if (!validateRequest(request)) {
            throw new IllegalArgumentException("Ошибка запроса");
        }

        // Сделал это для удобства, чтобы не придумывать лишнего
        S response = (S) "This is response";

        if (!validateResponse(response)) {
            throw new IllegalArgumentException("Ошибка ответа");
        }

        return response;
    }

    protected abstract boolean validateRequest(Q request);

    protected abstract boolean validateResponse(S httpResponse);
}
