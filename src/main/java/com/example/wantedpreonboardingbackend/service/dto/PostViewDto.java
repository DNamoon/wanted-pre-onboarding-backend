package com.example.wantedpreonboardingbackend.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostViewDto {
    private int postingId;
    private String companyName;
    private String title;
    private String position;
    private Long reward;
    private String skill;
    private String detail;
    private String nation;
    private String region;
}
