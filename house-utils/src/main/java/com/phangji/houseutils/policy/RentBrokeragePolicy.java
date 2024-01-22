package com.phangji.houseutils.policy;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * @author Happy
 * <p>
 * 임대차일 때 중개수수료를 계산해주는 클래스
 */
@Getter //인터페이스에서 접근할 수 있도록 규칙들을 가져옴
public class RentBrokeragePolicy implements BrokeragePolicy { //인터페이스 호출이 들어가기 때문에 implements
    private final List<BrokerageRule> rules; //정책이 규칙을 가진다: 객체와 객체간 관계(규칙을 통한 계산)

    public RentBrokeragePolicy() { //생성자
        rules = Arrays.asList( //if, else if, else의 반복되는 부분을 함수 객체화하여 코드 개선: lessThan
                new BrokerageRule(50_000_000L, 0.5, 200_000L),
                new BrokerageRule(100_000_000L, 0.4, 300_000L),
                new BrokerageRule(300_000_000L, 0.3),
                new BrokerageRule(600_000_000L, 0.4),
                new BrokerageRule(Long.MAX_VALUE, 0.8)
        );
    }
}
