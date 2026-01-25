package com.abbtech.exception;

import com.abbtech.exception.base.BaseErrorService;

public enum CarErrorEnum implements BaseErrorService {

    CAR_NOT_FOUND("CAR-0001", "Car not found", 404),
    CAR_INVALID_REQUEST("CAR-0002", "Invalid car request", 400);

    private final String errorCode;
    private final String message;
    private final int httpStatus;

    CarErrorEnum(String errorCode, String message, int httpStatus) {
        this.errorCode = errorCode;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }
}
