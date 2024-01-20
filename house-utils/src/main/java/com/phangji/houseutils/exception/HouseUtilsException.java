package com.phangji.houseutils.exception;

/**
 * @author Happy
 */
public class HouseUtilsException extends RuntimeException { //RuntimeException: UncheckedException 을 사용하는게 좋음.
    private ErrorCode errorCode; //어떤 에러로 이 예외가 생겼나?
    private String message; //커스텀 메시지 정의(좀 더 구체적으로)

    public HouseUtilsException(ErrorCode errorCode) {
        this(errorCode, errorCode.getMessage());
    } //커스텀 메시지 없는 경우

    public HouseUtilsException(ErrorCode errorCode, String customMessage) {
        super(customMessage); //super: 부모 클래스의 멤버를 참조하는 참조 변수
        this.errorCode = errorCode;
        this.message = customMessage;
    }

}
