package com.zhengb.coccurency.examples.publish.singleton;

/**
 * Created by zhengb on 2018-03-20.
 */

import com.zhengb.coccurency.annotations.ThreadSafe;

/**
 * @author zhengb
 * 懒汉模式
 * 双重同步锁单例模式 线程安全
 */
@ThreadSafe
public class SingletonExample5 {

    //私有构造函数
    private SingletonExample5() {

    }

    //单利对象 volatile+双重检测机制->禁止指令重排序 可以做到线程安全
    private static volatile SingletonExample5 instance = null;

    /**
     * 该操作并非线程安全 原因：
     * 创建对象分为三个步骤
     * 1、分配内存对象快捷 memory = allocate()
     * 2、初始化对象ctorInstance
     * 3、设置instance指向刚分配的内存 instance = memory
     * 在单线程下不会有问题，因为即使发生了指令重排，也能够正确获取到对象
     * 在多线程环境下，jvm和CPU优化，发生了指令重排，
     * 如果发生指令重排序
     * 指令重排序为
     * 1、分配内存对象快捷 memory = allocate()
     * 3、设置instance指向刚分配的内存 instance = memory
     * 2、初始化对象ctorInstance
     *
     * @return
     */
    public static SingletonExample5 getInstance() {
        if (instance == null) { //双重加锁
            synchronized (SingletonExample5.class) { //同步锁
                if (instance == null) {
                    //线程不安全场景分析
                    //有两个线程A和B
                    //线程A执行到这一步时，如果发生了指令重排序，即先分配了内存，然后再创建对象的情况下
                    //此时instance不为null，这个时候当线程B调用getInstance方法时，发现instance不为null，就立刻返回了
                    //但其实此时instance并未指向具体分配的对象内存
                    //解决方法，把instance修饰为volatile，可以防止指令重排序
                    instance = new SingletonExample5();
                }
            }

        }
        return instance;
    }
}
