package com.phangji.houseutils.constants;

import lombok.AllArgsConstructor;

/**
 * @author Happy
 */
@AllArgsConstructor
public enum ActionType { //enum: 열거형으로 타입 나열
    PURCHASE("매매"),
    RENT("임대차");

    private String description;
}
