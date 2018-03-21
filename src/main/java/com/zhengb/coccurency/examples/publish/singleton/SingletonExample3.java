package com.zhengb.coccurency.examples.publish.singleton;

/**
 * Created by zhengb on 2018-03-20.
 */

import com.zhengb.coccurency.annotations.NotRecommend;
import com.zhengb.coccurency.annotations.ThreadSafe;

/**
 * @author zhengb
 * 懒汉模式
 * 线程安全 但是不推荐这种写法
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    //私有构造函数
    private SingletonExample3() {

    }

    //单利对象
    private static SingletonExample3 instance = null;

    /**
     * 使用synchronize修饰后可以做到线程安全
     * 但是会带来性能上的开销
     * @return
     */
    public static synchronized SingletonExample3 getInstance() {
        if(instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
