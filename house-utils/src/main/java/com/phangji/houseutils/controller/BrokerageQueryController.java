package com.phangji.houseutils.controller;

import com.phangji.houseutils.constants.ActionType;
import com.phangji.houseutils.policy.BrokeragePolicy;
import com.phangji.houseutils.policy.BrokeragePolicyFactory;
import com.phangji.houseutils.service.ApartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Happy
 * <p>
 * 중개수수료가 얼마인지 조회하는 컨트롤러
 */
@RestController
@AllArgsConstructor
public class BrokerageQueryController {
    private final ApartmentService apartmentService;

    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType actionType, //Long: int범위를 넘어서는 정수
                              @RequestParam Long price) {
        //Todo: 중계수수료 계산 로직. BrokeragePolicyFactory 에서 분기하고 policy 는 인터페이스(BrokeragePolicy)에서 가져옴
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price); //return null; 에서 수정
    }

    @GetMapping("/api/calc/apartment/{apartmentId}")
    public Long calcBrokerageByApartmentId(
            @PathVariable Long apartmentId,
            @RequestParam ActionType actionType
    ) {
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        Long price = apartmentService.getPriceOrThrow(apartmentId);
        return policy.calculate(price);
    }
}
