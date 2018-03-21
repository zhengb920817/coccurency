package com.zhengb.coccurency.examples.publish.unsafepublish;

import com.zhengb.coccurency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Created by zhengb on 2018-03-20.
 */
@Slf4j
@NotThreadSafe
public class UnSafePublish {

    private String[] unsafeStringArray = {"a", "b", "c", "d"};

    public UnSafePublish() {

    }

    public String[] getArray() {
        return unsafeStringArray;
    }

    public static void main(String[] args) {
        UnSafePublish unSafePublish = new UnSafePublish();
        String[] strings = unSafePublish.getArray();
        log.info("{}", Arrays.toString(strings));

        //私有数组能够被外部修改
        strings[0] = "z";
        log.info("{}", Arrays.toString(strings));

    }
}
