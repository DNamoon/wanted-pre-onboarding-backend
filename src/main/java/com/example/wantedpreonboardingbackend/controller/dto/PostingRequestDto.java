package com.example.wantedpreonboardingbackend.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostingRequestDto {
    @Positive
    private int companyId;
    @NotBlank
    private String title;
    @NotBlank
    private String position;
    @PositiveOrZero
    private Long reward;
    @NotBlank
    private String skill;
    @NotBlank
    @Size(max = 1000)
    private String detail;
    @NotBlank
    private String nation;
    @NotBlank
    private String region;
}
