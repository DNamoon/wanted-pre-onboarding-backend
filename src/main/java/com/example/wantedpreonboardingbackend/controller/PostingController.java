package com.example.wantedpreonboardingbackend.controller;

import com.example.wantedpreonboardingbackend.controller.dto.PostingRequestDto;
import com.example.wantedpreonboardingbackend.controller.dto.ResponseDto;
import com.example.wantedpreonboardingbackend.service.PostingService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostingController {

    private final PostingService postingService;

    @PostMapping("/posting")
    public ResponseEntity<ResponseDto> create(@RequestBody @Valid PostingRequestDto request) {
        ResponseDto responseDto = postingService.create(request);

        return ResponseEntity.ok(responseDto);
    }
}
