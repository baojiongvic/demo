package com.vic.practice.jvm.run;

/**
 * 方法中定义的局部变量是否线程安全？
 * <p>
 * 何为线程安全？
 * 如果只有一个线程才可以操作此数据，则必是线程安全。
 * 如果多个线程可操作此数据，则此数据是共享数据。如果不考虑同步机制的话，会存在线程安全问题。
 *
 * @author baojiong20176
 * @create 2021/3/9 10:15 下午
 */
public class StringBuilderTest {

    public static void method1() {
        // s1的声明方式是线程安全的
        StringBuilder s1 = new StringBuilder();
        s1.append("a");
        s1.append("b");
        //TODO
    }

    /**
     * 此builder是线程不安全的
     *
     * @param builder
     */
    public static void method2(StringBuilder builder) {
        builder.append("a");
        builder.append("b");
    }

    /**
     * builder是线程不安全的
     *
     * @return
     */
    public static StringBuilder method3() {
        StringBuilder builder = new StringBuilder();
        builder.append("a");
        builder.append("b");
        return builder;
    }

    /**
     * builder是线程安全的
     *
     * @return
     */
    public static String method4() {
        StringBuilder builder = new StringBuilder();
        builder.append("a");
        builder.append("b");
        return builder.toString();
    }

    public static void main(String[] args) {
        // 线程不安全例子
        StringBuilder builder = new StringBuilder();

        new Thread(() -> {
            builder.append("a");
            builder.append("b");
        }).start();

        method2(builder);
    }
}
