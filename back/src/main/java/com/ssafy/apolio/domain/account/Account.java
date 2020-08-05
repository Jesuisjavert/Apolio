package com.ssafy.apolio.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssafy.apolio.domain.BaseTimeEntity;
import com.ssafy.apolio.domain.Comment;
import com.ssafy.apolio.domain.Heart;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Account extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private Long id;

    private String username;

    private String email;

    @Column(length = 600)
    private String picture;

    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @JsonIgnore
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    private String providerId;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Heart> hearts = new ArrayList<>();

}
