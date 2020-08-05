package com.ssafy.apolio.web;

import com.ssafy.apolio.domain.account.Account;
import com.ssafy.apolio.service.AccountService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;


    @ApiOperation(value = "유저 이름, 비밀번호, 이메일, 닉네임, 프로필 사진을 입력받아서 회원가입을 완료시킨다.", response = String.class)
    @PostMapping(value = "/account")
    public ResponseEntity<String> createAccount(@RequestBody AccountForm accountForm){
        Account account = new Account();
        account.setUsername(accountForm.getUsername());
        account.setPassword(accountForm.getPassword());
        account.setEmail(accountForm.getEmail());
        account.setPicture(accountForm.getPicture());
        account.setNickname(accountForm.getNickname());
        Long check = accountService.join(account);
        if(check != 0){
            return new ResponseEntity<String>("account success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("account fail", HttpStatus.NO_CONTENT);

    }
    @ApiOperation(value = "유저 리스트 전체를 조회한다.", response = List.class)
    @GetMapping(value = "/accounts")
    public ResponseEntity<List<Account>> accountList(){
        List<Account> accounts = accountService.findAccount();
        return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
    }
    @ApiOperation(value = "유저 번호를 입력받아서 해당하는 유저 정보를 조회한다", response = Account.class)
    @GetMapping(value = "/accounts/{id}")
    public ResponseEntity<Account> accountDetail(@PathVariable Long id){
        Account account = accountService.findOne(id);
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }
}
