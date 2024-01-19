package com.phangji.houseutils.service;

import com.phangji.houseutils.exception.ErrorCode;
import com.phangji.houseutils.exception.HouseUtilsException;
import com.phangji.houseutils.repository.ApartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Happy
 */
@Service //ApartmentRepository 를 가지고 데이터 관리
@AllArgsConstructor //생성자 주입. 서비스가 생성될 때 레포지토리 필요
public class ApartmentService {
    private final ApartmentRepository apartmentRepository; //스프링 프레임워크에서 서비스 생성할 때 와이어링 형식으로 매핑

    @Transactional
    public Long getPriceOrThrow(Long apartmentId) { //가격 가져오기 or 예외 던지기
        return apartmentRepository.findById(apartmentId)
                //만약 아파트의 데이터가 존재하지 않을 수도 있기 때문에 Optional
                .orElseThrow(() -> new HouseUtilsException(ErrorCode.ENTITY_NOT_FOUND))
                //데이터 존재 안하면 예외 던지기
                .getPrice();
    }
}
