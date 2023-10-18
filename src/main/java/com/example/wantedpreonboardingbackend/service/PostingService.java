package com.example.wantedpreonboardingbackend.service;

import com.example.wantedpreonboardingbackend.controller.dto.PostingRequestDto;
import com.example.wantedpreonboardingbackend.controller.dto.ResponseDto;

public interface PostingService {
    ResponseDto create(PostingRequestDto request);
}
