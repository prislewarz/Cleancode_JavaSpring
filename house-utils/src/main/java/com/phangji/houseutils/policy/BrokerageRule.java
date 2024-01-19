package com.phangji.houseutils.policy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

/**
 * @author Happy
 * <p>
 * 가격이 특정 범위일 때 상한효율과 상한금액 가지는 클래스(규칙)
 */
@AllArgsConstructor //lombok 플러그인 어노테이션. Constrcutor를 하나하나 짤 필요 없도록 함.
@Getter
public class BrokerageRule {
    private Long lessThan;
    private Double brokeragePercent;

    @Nullable //null이 될 수 있는 상황에서 null-safe 하게 처리.
    private Long limitAmount;

    public BrokerageRule(Long lessThan, Double brokeragePercent) {
        this(lessThan, brokeragePercent, Long.MAX_VALUE);
    }

    public Long calcMaxBrokerage(Long price) {
        return Math.min(multiplyPercent(price), limitAmount);
    }

    private Long multiplyPercent(Long price) {
        return Double.valueOf(Math.floor(brokeragePercent / 100 * price)).longValue(); //Double(8바이트), float(4바이트)
        // valueOf() 메서드는 모든 내장된 자바 타입에 대해 문자열(String)로 적절하게 변환
        // longValue() 메서드는 Long 객체를 long 으로 변환한 후 이 객체의 값을 반환
    }
}
