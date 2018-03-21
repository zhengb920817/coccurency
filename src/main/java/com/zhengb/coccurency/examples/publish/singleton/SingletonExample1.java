package com.zhengb.coccurency.examples.publish.singleton;

/**
 * Created by zhengb on 2018-03-20.
 */

import com.zhengb.coccurency.annotations.NotThreadSafe;

/**
 * @author zhengb
 * 懒汉模式
 */
@NotThreadSafe
public class SingletonExample1 {

    //私有构造函数
    private SingletonExample1() {

    }

    //单利对象
    private static SingletonExample1 instance = null;

    //静态工厂方法
    //非线程安全
    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }

        return instance;
    }
}
