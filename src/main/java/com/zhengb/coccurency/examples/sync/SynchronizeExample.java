package com.zhengb.coccurency.examples.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhengb on 2018-03-19.
 */
@Slf4j
public class SynchronizeExample {

    public void method1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("method1,j:{},i：{}", j, i);
            }
        }
    }

    public synchronized void method2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("method2,j:{},i：{}", j, i);
        }
    }

    public void method3(int j) {
        synchronized (this.getClass()) {
            for (int i = 0; i < 10; i++) {
                log.info("method3,j:{},i：{}", j, i);
            }
        }
    }

    public synchronized static void method4(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("method4,j:{},i：{}", j, i);
        }
    }

    public static void main(String[] args) {
        /**
         * 这种情况下
         * method1先执行输出，输出完成后再执行method2输出
         * 因为method1和method2获取的是对象锁
         * 这里只实例化了一个example1，因此获取的是example1对象的锁
         * 执行method1时先获取了example1的对象锁，
         * 执行完成后method2获取了example1的对像锁
         * 因此做了依次输出
        SynchronizeExample example1 = new SynchronizeExample();
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(() -> {
            example1.method1(1);
        });

        service.submit(() -> {
            example1.method2(2);
        });
         */

        /**
         * 因为example1和example2是两个不同的实例对象
         * 因此这里是执行的example1和example2的交替输出

        SynchronizeExample example1 = new SynchronizeExample();
        SynchronizeExample example2 = new SynchronizeExample();
        ExecutorService service = Executors.newCachedThreadPool();

        service.submit(() -> {
            example1.method2(1);
        });

        service.submit(() -> {
            example2.method2(2);
        });
         */

        /**
         * synchronize修饰一个对象的class或者一个静态方法时，
         * 需要获取到的是这个对象的class对象的锁
         * class对象右jvm创建并且只会存在一个实例，
         * 因此这种情况下执行的是method3和method4依次输出
         */
        SynchronizeExample example = new SynchronizeExample();
        ExecutorService service = Executors.newCachedThreadPool();

        service.submit(() -> {
            example.method3(1);
        });

        service.submit(() -> {
            method4(2);
        });
    }
}
