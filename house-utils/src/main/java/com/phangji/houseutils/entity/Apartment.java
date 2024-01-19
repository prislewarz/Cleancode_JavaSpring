package com.phangji.houseutils.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Happy
 */
@Entity
@Getter
@Setter //Getter, Setter 를 통한 자료구조에 대한 데이터 접근
public class Apartment { //Entity 는 자료구조로, 객체가 아님
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //@GenerateValue: Entity 는 Primary key 를 지녀야 함
    private Long id;

    @Column(nullable = false) //아파트는 이름이 꼭 있어야 함
    public String name;

    @Column(nullable = false) //아파트는 주소가 꼭 있어야 함
    public String address;

    @Column(nullable = false) //아파트는 가격이 꼭 있어야 함
    public Long price;
}
