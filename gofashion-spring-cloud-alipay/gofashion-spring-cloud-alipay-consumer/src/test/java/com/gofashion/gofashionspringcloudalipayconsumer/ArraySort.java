package com.gofashion.gofashionspringcloudalipayconsumer;

public class ArraySort implements Runnable{
    private String num;
    public ArraySort(int num){
        this.num = num+"";
    }

    public static void main(String[] args) {
        int [] nums = {80,60,20,100,50,10,7};
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            System.out.println("循环中的----------------" + num);
            new Thread(new ArraySort(nums[i])).start();
        }
    }
    @Override
    public void run() {
        try {
            Thread.sleep(Integer.parseInt(num));
            System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
