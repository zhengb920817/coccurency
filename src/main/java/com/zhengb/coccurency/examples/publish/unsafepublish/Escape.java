package com.zhengb.coccurency.examples.publish.unsafepublish;

import com.zhengb.coccurency.annotations.NotRecommend;
import com.zhengb.coccurency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by zhengb on 2018-03-20.
 */
@NotThreadSafe
@NotRecommend
@Slf4j
public class Escape {

    private int thisCanEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            log.info("{}", Escape.this.thisCanEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
