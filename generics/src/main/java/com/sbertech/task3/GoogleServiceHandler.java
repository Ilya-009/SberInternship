package com.sbertech.task3;

import java.net.URI;
import java.net.http.HttpResponse;

public class GoogleServiceHandler extends ServiceHandlerBase {
    public GoogleServiceHandler(URI uri) {
        super(uri);
    }

    @Override
    protected boolean validateRequest() {
        return uri != null && !uri.toString().equals("") && uri.toString().contains("google");
    }

    @Override
    protected <T> boolean validateResponse(HttpResponse<T> httpResponse) {
        if (httpResponse.statusCode() != 200) {
            return false;
        }

        System.out.printf("Http response is: %s", httpResponse.body().toString());

        return true;
    }
}
