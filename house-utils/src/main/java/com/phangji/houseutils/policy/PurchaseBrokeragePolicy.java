package com.phangji.houseutils.policy;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Happy
 * <p>
 * 매매일 때 중개수수료를 계산해주는 클래스
 */
@Getter
public class PurchaseBrokeragePolicy implements BrokeragePolicy { //인터페이스 호출이 들어가기 때문에 implements
    private final List<BrokerageRule> rules;
    //Todo: 가격을 받아서 중계수수료를 계산한다.

    public PurchaseBrokeragePolicy() {
        rules = Arrays.asList(
                new BrokerageRule(50_000_000L, 0.6, 250_000L),
                new BrokerageRule(200_000_000L, 0.5, 800_000L),
                new BrokerageRule(600_000_000L, 0.4),
                new BrokerageRule(900_000_000L, 0.5),
                new BrokerageRule(Long.MAX_VALUE, 0.9)
        );
    }
}
