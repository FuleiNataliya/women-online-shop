package com.women.online.shop.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Phones {
    private String mobilePhone;
    private String workingPhone;
    private String homePhone;

    Phones(String mobilePhone, String workingPhone, String homePhone) {
        this.mobilePhone = mobilePhone;
        this.workingPhone = workingPhone;
        this.homePhone = homePhone;
    }

    public String toString() {
        return "mobile phone: " + mobilePhone + ", working number: " + workingPhone + ", home number: " + homePhone;
    }

}