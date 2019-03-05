package com.cole.lib;

public class ThreadTest {


    public void testIntruuct(){
        SleepThread thread = new SleepThread();
        thread.start();
        try {
            Thread.currentThread().sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }


    private class IntteructThread extends Thread{
        @Override
        public void run() {
            super.run();
            double number = 9999999;
            long current = System.currentTimeMillis();
            while (true){
                double d = number / 19846964D;
                if (System.currentTimeMillis() - current > 500){
                    System.out.println("Thread is running!");
                }
            }
        }
    }

    private class SleepThread extends Thread{
        @Override
        public void run() {
            super.run();
            boolean stop = true;
            while (stop){
                try {
                    Thread.currentThread().sleep(1000);
                    System.out.println("Thread is running!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("InterruptedException !");
                    stop = false;
                }
            }
        }
    }
}
