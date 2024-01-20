package com.phangji.houseutils.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Happy
 */
@AllArgsConstructor //생성자
@Getter //private 로 정의된 메시지를 get 할 수 있도록 함(lombok 플러그인)
public enum ErrorCode { // 에러코드 나열
    INVALID_REQUEST("잘못된 요청입니다."),
    INTERNAL_ERROR("알 수 없는 에러가 발생했습니다."),
    ENTITY_NOT_FOUND("데이터를 찾을 수 없습니다.");

    private String message;
}
