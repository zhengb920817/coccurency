package com.zhengb.coccurency.examples.atomic;

import com.zhengb.coccurency.annotations.ThreadSafe;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by zhengb on 2018-03-19.
 */
@Slf4j
@ThreadSafe
public class AtomincReferenceFiledUpdaterExample {

    @Getter
    @Setter
    private volatile int count ;

    private static AtomicIntegerFieldUpdater<AtomincReferenceFiledUpdaterExample>
            referenceFieldUpdater =
            AtomicIntegerFieldUpdater.newUpdater(AtomincReferenceFiledUpdaterExample.class,"count");
    public static void main(String[] args) {

        AtomincReferenceFiledUpdaterExample example = new AtomincReferenceFiledUpdaterExample();
        example.setCount(0);

        referenceFieldUpdater.compareAndSet(example,0,10);
        referenceFieldUpdater.compareAndSet(example,2,9);
        referenceFieldUpdater.compareAndSet(example,10,20);

        log.info("count:{}",example.getCount());

    }
}
