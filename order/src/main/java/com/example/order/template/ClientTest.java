package com.example.order.template;

/**
 * @author tangyin@belink.com
 * @version V1.0
 * @title
 * @description
 * @date 2022-09-04 22:30
 */
public class ClientTest {

    public static void main(String[] args){
        HouseTemplate houseOne = new HouseOne("房子1",false);
        HouseTemplate houseTwo = new HouseTwo("房子2");
        houseOne.buildHouse();
        houseTwo.buildHouse();
    }
}
