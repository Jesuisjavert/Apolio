package com.ssafy.apolio.repository;

import com.ssafy.apolio.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByEmail(String email);

    Boolean existsByEmail(String email);

}
