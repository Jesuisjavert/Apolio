package com.ssafy.apolio.repository;

import com.ssafy.apolio.domain.account.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor // final인 필드만으로 생성자 만듦, 생성자는 최신 스프링에서 자동 Autowired가 된다.
public class AccountRepository{

    private final EntityManager em;

    public void save(Account account) {
        em.persist(account);
    }

    public Account findOne(Long id) {
        return em.find(Account.class, id);
    }


    public List<Account> findAll() {
        return em.createQuery("select a from Account a", Account.class)
                .getResultList();
    }

    public List<Account> findByEmail(String email) {
        return em.createQuery("select a from Account a where a.email = :email", Account.class)
                .setParameter("email", email)
                .getResultList();
    }
}
