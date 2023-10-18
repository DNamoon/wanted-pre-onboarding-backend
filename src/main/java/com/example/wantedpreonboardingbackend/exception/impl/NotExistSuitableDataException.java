package com.example.wantedpreonboardingbackend.exception.impl;

import com.example.wantedpreonboardingbackend.exception.AbstractException;
import com.example.wantedpreonboardingbackend.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public class NotExistSuitableDataException extends AbstractException {

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getData() {
        return ErrorCode.NOT_EXIST_SUITABLE_DATA_EXCEPTION.name();
    }
}
