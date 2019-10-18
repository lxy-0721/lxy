package com.lanou.springboot02.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.crypto.Data;
/*
lombok 插件
*/
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Emp {

    private  Integer empno;
    private String ename;
    private Integer mgr;
    private String job;
    private Data birthday;
    private Integer sal;
    private Double comm;
    private  Integer depton;

}
