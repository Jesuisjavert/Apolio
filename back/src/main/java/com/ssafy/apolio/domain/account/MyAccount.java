package com.ssafy.apolio.domain.account;

import lombok.Data;
import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue("MyAccount")
public class MyAccount extends Account{
    private String Password;
}
