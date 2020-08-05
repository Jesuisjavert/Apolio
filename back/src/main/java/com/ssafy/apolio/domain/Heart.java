package com.ssafy.apolio.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ssafy.apolio.domain.account.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Heart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "heart_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "account_id")
    @JsonBackReference
    private Account account;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "article_id")
    @JsonBackReference
    private Article article;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "community_id")
    @JsonBackReference
    private Community community;

    @Enumerated(EnumType.STRING)
    private HeartStatus status;// 하트상태 [HEART, CANCEL]

}
