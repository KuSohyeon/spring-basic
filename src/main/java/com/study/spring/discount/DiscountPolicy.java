package com.study.spring.discount;

import com.study.spring.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
