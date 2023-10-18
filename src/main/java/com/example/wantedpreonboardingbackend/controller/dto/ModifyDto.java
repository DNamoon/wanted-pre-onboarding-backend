package com.example.wantedpreonboardingbackend.controller.dto;

import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ModifyDto {
    private int postingId;
    private String title;
    private String position;
    private Long reward;
    private String skill;
    @Size(max = 1000)
    private String detail;
    private String nation;
    private String region;

}
