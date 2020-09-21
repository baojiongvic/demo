package com.vic.practice.thread;

/**
 * 源程序名称：ProductTest <br>
 * 源程序包名：com.vic.practice.thread <br>
 * 系统名称：practice <br>
 * 开发时间：2020/9/21 10:23 下午 <br>
 *
 * @author baojiong20176 <br>
 * <br>
 * <p>
 * 生产者和消费者
 */
public class ProductTest {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Thread t1 = new Thread(new Producer(clerk));
        Thread t2 = new Thread(new Consumer(clerk));

        t1.setName("生产者");
        t2.setName("消费者");

        t1.start();
        t2.start();
    }
}

class Clerk {

    private int productCount;

    public synchronized void produceProduct() {
        if (productCount < 20) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            productCount++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + productCount + "个产品");

            this.notify();
        } else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumerProduct() {
        if (productCount > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "开始消费第" + productCount + "个产品");
            productCount--;

            this.notify();
        } else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable {

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "开始生产产品......");
            clerk.produceProduct();
        }
    }
}

class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "开始消费产品......");
            clerk.consumerProduct();
        }
    }
}
