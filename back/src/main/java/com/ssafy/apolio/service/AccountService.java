package com.ssafy.apolio.service;

import com.ssafy.apolio.domain.account.Account;
import com.ssafy.apolio.domain.account.MyAccount;
import com.ssafy.apolio.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //조회문은 true로 해야 성능이 좋다. 기본 값은 false
@RequiredArgsConstructor // final인 필드만 가지고 생성자를 만들어 줌. 결론적으로 Autowired가 된다. lombok 기능
public class AccountService {

    private final AccountRepository accountRepository;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(MyAccount account) {
        validateDuplicateAccount(account); //중복 회원 검증
        accountRepository.save(account);
        return account.getId();
    }

    private void validateDuplicateAccount(Account account) {
        List<Account> findAccount = accountRepository.findByEmail(account.getEmail());
        if (!findAccount.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Account> findAccount() {
        return accountRepository.findAll();
    }

    public Account findOne(Long accountId) {
        return accountRepository.findOne(accountId);
    }
}
