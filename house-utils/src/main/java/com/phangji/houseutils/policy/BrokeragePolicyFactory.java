package com.phangji.houseutils.policy;

import com.phangji.houseutils.constants.ActionType;
import com.phangji.houseutils.exception.ErrorCode;
import com.phangji.houseutils.exception.HouseUtilsException;

/**
 * @author Happy
 */
public class BrokeragePolicyFactory { //액션타입(매매, 임대차)에 따라 정책을 선택(생성)해주는 클래스
    //두 정책(클래스)을 객체 생성할 필요 없이 static 메서드로 호출
    private static final RentBrokeragePolicy rentBrokeragePolicy = new RentBrokeragePolicy(); //new: 클래스 타입의 인스턴스 (객체)를 생성해주는 역할
    private static final PurchaseBrokeragePolicy purchaseBrokeragePolicy = new PurchaseBrokeragePolicy();

    public static BrokeragePolicy of(ActionType actionType) {
        switch (actionType) {
            case RENT:
                return rentBrokeragePolicy;
            case PURCHASE:
                return purchaseBrokeragePolicy;
            default: //어느 정책에도 해당하지 않을 시 에러 던지기
                throw new HouseUtilsException(ErrorCode.INVALID_REQUEST, "해당 actionType에 대한 정책이 존재하지 않습니다.");
                //IllegalArgumentException 보다 훨씬 직관적(커스텀 에러코드)
        }
    }
}
