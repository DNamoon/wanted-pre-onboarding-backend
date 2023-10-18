package com.example.wantedpreonboardingbackend.service.impl;

import com.example.wantedpreonboardingbackend.controller.dto.ModifyDto;
import com.example.wantedpreonboardingbackend.controller.dto.PostingRequestDto;
import com.example.wantedpreonboardingbackend.controller.dto.ResponseDto;
import com.example.wantedpreonboardingbackend.domain.Company;
import com.example.wantedpreonboardingbackend.domain.Posting;
import com.example.wantedpreonboardingbackend.exception.impl.NotExistSuitableDataException;
import com.example.wantedpreonboardingbackend.repository.CompanyRepository;
import com.example.wantedpreonboardingbackend.repository.PostingRepository;
import com.example.wantedpreonboardingbackend.service.PostingService;
import com.example.wantedpreonboardingbackend.service.dto.PostCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostingServiceImpl implements PostingService {

    private final PostingRepository postingRepository;
    private final CompanyRepository companyRepository;

    @Override
    public ResponseDto create(PostingRequestDto request) {

        Company company = companyRepository.findById(request.getCompanyId())
            .orElseThrow(NotExistSuitableDataException::new);

        Posting posting = Posting.builder()
            .company(company)
            .title(request.getTitle())
            .position(request.getPosition())
            .reward(request.getReward())
            .detail(request.getDetail())
            .skill(request.getSkill())
            .nation(request.getNation())
            .region(request.getRegion())
            .build();

        Posting savedPosting = postingRepository.save(posting);

        return ResponseDto.builder()
            .statusCode(HttpStatus.OK.value())
            .body(new PostCreateDto(savedPosting.getTitle()))
            .build();
    }

    @Transactional
    @Override
    public ResponseDto modify(ModifyDto request) {

        Posting posting = postingRepository.findById(request.getPostingId())
            .orElseThrow(NotExistSuitableDataException::new);

        if (request.getTitle() != null || !request.getTitle().trim().isEmpty()) {
            posting.setTitle(request.getTitle());
        }
        if (request.getPosition() != null || !request.getPosition().trim().isEmpty()) {
            posting.setPosition(request.getPosition());
        }
        if (request.getReward() != null || !request.getReward().toString().trim().isEmpty()) {
            posting.setReward(request.getReward());
        }
        if (request.getSkill() != null || !request.getSkill().trim().isEmpty()) {
            posting.setSkill(request.getSkill());
        }
        if (request.getDetail() != null || !request.getDetail().trim().isEmpty()) {
            posting.setDetail(request.getDetail());
        }
        if (request.getNation() != null || !request.getNation().trim().isEmpty()) {
            posting.setNation(request.getNation());
        }
        if (request.getRegion() != null || !request.getRegion().trim().isEmpty()) {
            posting.setRegion(request.getRegion());
        }

        Posting savedPosting = postingRepository.save(posting);

        return ResponseDto.builder()
            .statusCode(HttpStatus.OK.value())
            .body(new PostCreateDto(savedPosting.getTitle()))
            .build();
    }


}
