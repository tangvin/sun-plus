package com.example.order.constant;

public enum BusinessEnum {
    ;

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    BusinessEnum(String name) {
        this.name = name;
    }
}
