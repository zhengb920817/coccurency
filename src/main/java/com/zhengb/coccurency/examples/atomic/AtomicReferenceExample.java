package com.zhengb.coccurency.examples.atomic;

import com.zhengb.coccurency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by zhengb on 2018-03-19.
 */
@ThreadSafe
@Slf4j
public class AtomicReferenceExample {
    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(0);

    public static void main(String[] args) {
        atomicReference.compareAndSet(0,2); //2
        atomicReference.compareAndSet(0,8); //不执行
        atomicReference.compareAndSet(2,6); //当前值为2  设置为6
        atomicReference.compareAndSet(4,9); //不执行
        log.info("count:{}",atomicReference.get());


    }
}
