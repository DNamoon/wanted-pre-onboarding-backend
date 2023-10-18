package com.example.wantedpreonboardingbackend.service;

import com.example.wantedpreonboardingbackend.controller.dto.ModifyDto;
import com.example.wantedpreonboardingbackend.controller.dto.PostingRequestDto;
import com.example.wantedpreonboardingbackend.controller.dto.ResponseDto;
import org.springframework.data.domain.Pageable;

public interface PostingService {
    ResponseDto create(PostingRequestDto request);

    ResponseDto modify(ModifyDto request);

    ResponseDto delete(ModifyDto deleteRequest);

    ResponseDto view(Pageable pageable);
}
