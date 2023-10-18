package com.example.wantedpreonboardingbackend.controller;

import com.example.wantedpreonboardingbackend.controller.dto.ModifyDto;
import com.example.wantedpreonboardingbackend.controller.dto.PostingRequestDto;
import com.example.wantedpreonboardingbackend.controller.dto.ResponseDto;
import com.example.wantedpreonboardingbackend.service.PostingService;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("/posting")
    public ResponseEntity<ResponseDto> modify(@RequestBody @Valid ModifyDto request) {
        ResponseDto responseDto = postingService.modify(request);

        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/posting")
    public ResponseEntity<ResponseDto> delete(@RequestBody ModifyDto deleteRequest) {
        ResponseDto responseDto = postingService.delete(deleteRequest);

        return ResponseEntity.ok(responseDto);
    }
}
