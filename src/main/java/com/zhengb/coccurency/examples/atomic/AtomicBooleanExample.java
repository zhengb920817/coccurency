package com.zhengb.coccurency.examples.atomic;

import com.zhengb.coccurency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by zhengb on 2018-03-19.
 */
@Slf4j
@ThreadSafe
public class AtomicBooleanExample {

    //初始化为false
    private static AtomicBoolean isHappened = new AtomicBoolean(false);

    /**
     * 请求总数
     */
    public static int clientTotal = 5000;
    /**
     * 同事允许并发的线程数
     */
    public static int threadTotal = 200;

    private static void change() {
        //因为是原子性操作 因此这里只会执行一次，初始化值为false，只能由一个线程执行修改为true
        //
        if (isHappened.compareAndSet(false, true)) {
            log.info("change success!");
        }
    }


    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.submit(() -> {
                try {
                    semaphore.acquire();
                    change();
                    semaphore.release();
                } catch (Exception e) {
                    log.info("error:{}", e);
                }
                countDownLatch.countDown();
            });

        }

        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", isHappened.get());
    }


}
