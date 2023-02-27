package com.study.spring;

import com.study.spring.discount.FixDiscountPolicy;
import com.study.spring.member.MemberService;
import com.study.spring.member.MemberServiceImpl;
import com.study.spring.member.MemoryMemberRepository;
import com.study.spring.order.OrderService;
import com.study.spring.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public FixDiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
