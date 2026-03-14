package com.montjoy.places;

public final class MontjoyPlacesException extends RuntimeException {
    private final int statusCode;
    private final Object responseBody;

    public MontjoyPlacesException(String message, int statusCode, Object responseBody) {
        super(message);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Object getResponseBody() {
        return responseBody;
    }
}
