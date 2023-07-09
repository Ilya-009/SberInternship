package com.sbertech.task3;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public abstract class ServiceHandlerBase {
    protected URI uri;

    public ServiceHandlerBase(URI uri) {
        this.uri = uri;

        boolean validationResult = validateRequest();

        if (!validationResult) {
            throw new IllegalArgumentException();
        }
    }

    public String makeRequest() throws ExecutionException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        CompletableFuture<HttpResponse<String>> requestTask = client
                .sendAsync(request, HttpResponse.BodyHandlers.ofString());

        HttpResponse<String> httpResponse = requestTask.get();

        boolean responseValidationResult = validateResponse(httpResponse);

        return responseValidationResult ? httpResponse.body() : null;
    }

    protected abstract boolean validateRequest();

    protected abstract <T> boolean validateResponse(HttpResponse<T> httpResponse);
}
