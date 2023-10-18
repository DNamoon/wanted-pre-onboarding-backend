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
import com.example.wantedpreonboardingbackend.service.dto.PostViewDto;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Transactional
    @Override
    public ResponseDto delete(ModifyDto deleteRequest) {
        Posting posting = postingRepository.findById(deleteRequest.getPostingId())
            .orElseThrow(NotExistSuitableDataException::new);

        String deleteTitle = posting.getTitle();
        postingRepository.delete(posting);

        return ResponseDto.builder()
            .statusCode(HttpStatus.OK.value())
            .body(new PostCreateDto(deleteTitle))
            .build();
    }

    @Override
    public ResponseDto view(Pageable pageable) {
        List<PostViewDto> dtoList = new ArrayList<>();

        Page<Posting> list = postingRepository.findAll(pageable);

        for (Posting savedPosting : list) {
            PostViewDto dto = new PostViewDto(
                savedPosting.getPostingId(),
                savedPosting.getCompany().getName(),
                savedPosting.getTitle(),
                savedPosting.getPosition(),
                savedPosting.getReward(),
                savedPosting.getSkill(),
                savedPosting.getDetail(),
                savedPosting.getNation(),
                savedPosting.getRegion()
                );

            dtoList.add(dto);
        }

        return ResponseDto.builder()
            .statusCode(HttpStatus.OK.value())
            .body(dtoList)
            .build();
    }

    @Override
    public ResponseDto viewOne(int postingId) {
        Posting posting = postingRepository.findById(postingId)
            .orElseThrow(NotExistSuitableDataException::new);

        return ResponseDto.builder()
            .statusCode(HttpStatus.OK.value())
            .body(new PostViewDto(
                posting.getPostingId(),
                posting.getCompany().getName(),
                posting.getTitle(),
                posting.getPosition(),
                posting.getReward(),
                posting.getSkill(),
                posting.getDetail(),
                posting.getNation(),
                posting.getRegion()
            ))
            .build();
    }


}
