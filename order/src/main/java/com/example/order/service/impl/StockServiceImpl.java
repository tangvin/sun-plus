package com.example.order.service.impl;

/**
 * @author tangyin@belink.com
 * @version V1.0
 * @title
 * @description： 模拟库存数据
 * @date 2022-09-03 20:40
 */
public class StockServiceImpl {

    //库存数量
    private static int number = 1;

    //减库存
    public boolean reduceStock() {
        if (number > 0) {
            //逻辑处理
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            number--;
            return true;
        }
        return false;
    }


    static class TestBugThread implements Runnable {
        @Override
        public void run() {
            //减库存方法
            boolean b = new StockServiceImpl().reduceStock();
            if (b) {
                System.out.println(Thread.currentThread().getName() + " 库存减少成功");
            } else {
                System.out.println(Thread.currentThread().getName() + " 库存减少失败");
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 5; i++) {
//            new Thread(new TestBugThread(), "thread-" + i).start();
//        }
        new Thread(new TestBugThread(), "thread-1").start();
        new Thread(new TestBugThread(), "thread-2").start();
        Thread.sleep(3000);
        System.out.println("number======="+number);
    }
}
