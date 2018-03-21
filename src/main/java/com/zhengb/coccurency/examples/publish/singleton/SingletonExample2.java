package com.zhengb.coccurency.examples.publish.singleton;

/**
 * Created by zhengb on 2018-03-20.
 */

import com.zhengb.coccurency.annotations.ThreadSafe;

/**
 * @author zhengb
 * 饿汉模式  线程安全
 * 缺点：构造方法中如果存在过多的处理过程
 * 有可能导致加载类的时候特别慢 会引起性能问题
 * 如果只加载类而不作调用 会导致资源的浪费
 */
@ThreadSafe
public class SingletonExample2 {

    //私有构造函数
    private SingletonExample2() {

    }

    //单利对象
    private static SingletonExample2 instance = new SingletonExample2();

    //静态工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
