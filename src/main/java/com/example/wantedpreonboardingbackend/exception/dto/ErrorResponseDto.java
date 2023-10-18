package com.example.wantedpreonboardingbackend.exception.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponseDto {

    private int statusCode;
    private String data;

    @Builder
    public ErrorResponseDto(int statusCode, String data) {
        this.statusCode = statusCode;
        this.data = data;
    }
}
