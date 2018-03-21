package com.zhengb.coccurency.examples.publish.singleton;

import com.zhengb.coccurency.annotations.Recommend;
import com.zhengb.coccurency.annotations.ThreadSafe;

/**
 * Created by zhengb on 2018-03-20.
 */
@ThreadSafe
@Recommend
/**
 * 通过枚举获取
 * 这种方法是最安全的
 */
public class SingletonExample7 {

    private SingletonExample7() {

    }

    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample7 instance = null;

        //jvm只会创建一次
        Singleton() {
            instance = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return instance;
        }
    }

}
