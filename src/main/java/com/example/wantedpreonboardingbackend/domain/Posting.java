package com.example.wantedpreonboardingbackend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company")
    private Company company;

    private String title;
    private String position;
    private Long reward;
    @Column(length = 1000)
    private String detail;
    private String skill;
    private String nation;
    private String region;
}
