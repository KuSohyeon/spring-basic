package com.study.spring.order;

import com.study.spring.discount.DiscountPolicy;
import com.study.spring.discount.FixDiscountPolicy;
import com.study.spring.member.Member;
import com.study.spring.member.MemberRepository;
import com.study.spring.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
