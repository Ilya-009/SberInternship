package com.sbertech.task3;

import java.net.http.HttpRequest;

public class GoogleServiceHandler<Q extends HttpRequest, S> extends ServiceHandlerBase<Q, S> {

    @Override
    protected boolean validateRequest(Q request) {
        return request.uri() != null && !request.uri().toString().equals("") && request.uri().toString().contains("google");
    }

    @Override
    protected boolean validateResponse(S httpResponse) {
        if (httpResponse == null) {
            return false;
        }

        System.out.printf("Http response is: %s", httpResponse.toString());
        return true;
    }
}
