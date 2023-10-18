package com.example.wantedpreonboardingbackend.repository;

import com.example.wantedpreonboardingbackend.domain.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Integer> {

}
