package com.phangji.houseutils.policy;

import com.phangji.houseutils.exception.ErrorCode;
import com.phangji.houseutils.exception.HouseUtilsException;

import java.util.List;

/**
 * @author Happy
 *
 * 중계수수료 정책 인터페이스
 */
public interface BrokeragePolicy { //생성자에서 데이터를 갖도록 객체 간 관계를 풀어냈으므로 생성 로직은 필요없어짐.

    List<BrokerageRule> getRules(); //규칙들을 가져와 인터페이스에 적용

    //인터페이스에 default 메서드로 중복 로직 제거
    default Long calculate(Long price) { //calculate 가 policy 클래스에서 중복이 되기 때문에 인터페이스로 묶어 공통으로 호출해서 사용
        BrokerageRule brokerageRule = getRules().stream() //stream(): 저장 요소를 하나씩 참조해서 람다식으로 처리할 수 있도록 해주는 반복자
                .filter(rule -> price < rule.getLessThan()) //getter로 lessThan 가져와 적용
                .findFirst().orElseThrow(() -> new HouseUtilsException(ErrorCode.INTERNAL_ERROR)); //데이터 존재 안하면 커스텀 예외 던지기
        return brokerageRule.calcMaxBrokerage(price);
    }
}
