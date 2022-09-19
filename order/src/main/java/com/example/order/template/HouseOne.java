package com.example.order.template;

/**
 * @author tangyin@belink.com
 * @version V1.0
 * @title
 * @description
 * @date 2022-09-04 22:29
 */
public class HouseOne extends HouseTemplate {
    HouseOne(String name){
        super(name);
    }

    public boolean isBuildToilet;
    HouseOne(String name, boolean isBuildToilet){
        this(name);
        this.isBuildToilet = isBuildToilet;
    }

    @Override
    protected void buildDoor() {
        System.out.println(name +"的门要采用防盗门");
    }
    @Override
    protected void buildWindow() {
        System.out.println(name + "的窗户要面向北方");
    }
    @Override
    protected void buildWall() {
        System.out.println(name + "的墙使用大理石建造");
    }
    @Override
    protected void buildBase() {
        System.out.println(name + "的地基使用钢铁地基");
    }
    @Override
    protected void buildToilet() {
        System.out.println(name + "的厕所建在东南角");
    }
    @Override
    protected boolean isBuildToilet(){
        return isBuildToilet;
    }
}
