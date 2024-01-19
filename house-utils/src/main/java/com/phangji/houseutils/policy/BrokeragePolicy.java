package com.phangji.houseutils.policy;

import com.phangji.houseutils.exception.ErrorCode;
import com.phangji.houseutils.exception.HouseUtilsException;

import java.util.List;

/**
 * @author Happy
 */
public interface BrokeragePolicy {

    List<BrokerageRule> getRules();

    //인터페이스에 default 메서드로 중복 로직 제거
    default Long calculate(Long price) { //calculate 가 policy 클래스에서 중복이 되기 때문에 인터페이스로 묶어 공통으로 호출해서 사용
        BrokerageRule brokerageRule = getRules().stream()
                .filter(rule -> price < rule.getLessThan())
                .findFirst().orElseThrow(() -> new HouseUtilsException(ErrorCode.INTERNAL_ERROR));
        return brokerageRule.calcMaxBrokerage(price);
    }
}
