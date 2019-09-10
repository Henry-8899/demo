package cn.henry.demo.synchronize;

public class SynchronizedDemo {


    /**
     * 编译后的的字节码信息
     *   public void method();
     *     descriptor: ()V
     *     flags: (0x0001) ACC_PUBLIC
     *     Code:
     *       stack=2, locals=3, args_size=1
     *          0: aload_0
     *          1: dup
     *          2: astore_1
     *          3: monitorenter
     *          4: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *          7: ldc           #3                  // String synchronized 代码块
     *          9: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *         12: aload_1
     *         13: monitorexit
     *         14: goto          22
     *         17: astore_2
     *         18: aload_1
     *         19: monitorexit
     *         20: aload_2
     *         21: athrow
     *         22: return
     *       Exception table:
     *          from    to  target type
     *              4    14    17   any
     *             17    20    17   any
     *       LineNumberTable:
     *         line 6: 0
     *         line 7: 4
     *         line 8: 12
     *         line 9: 22
     *       LocalVariableTable:
     *         Start  Length  Slot  Name   Signature
     *             0      23     0  this   Lcn/henry/demo/synchronize/SynchronizedDemo;
     *       StackMapTable: number_of_entries = 2
     *         frame_type = 255
     *           offset_delta = 17
     *           locals = [ class cn/henry/demo/synchronize/SynchronizedDemo, class java/lang/Object ]
     *           stack = [ class java/lang/Throwable ]
     *         frame_type = 250
     *           offset_delta = 4
     * }
     * SourceFile: "SynchronizedDemo.java"
     */
    public void method() {
        /**
         * synchronized 同步语句块的实现使用的是 monitorenter 和 monitorexit 指令，
         * 其中 monitorenter 指令指向同步代码块的开始位置，monitorexit 指令则指明同步代码块的结束位置。
         * 当执行 monitorenter 指令时，线程试图获取锁也就是获取 monitor(monitor对象存在于每个Java对象的对象头中，
         * synchronized 锁便是通过这种方式获取锁的，也是为什么Java中任意对象可以作为锁的原因) 的持有权。
         * 当计数器为0则可以成功获取，获取后将锁计数器设为1也就是加1。相应的在执行 monitorexit 指令后，将锁计数器设为0，表明锁被释放。如果获取对象锁失败，那当前线程就要阻塞等待，直到锁被另外一个线程释放为止。
         */
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }


    /**
     * 编译后的的字节码信息
     *  public synchronized void method2();
     *     descriptor: ()V
     *     flags: (0x0021) ACC_PUBLIC, ACC_SYNCHRONIZED
     *     Code:
     *       stack=2, locals=1, args_size=1
     *          0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *          3: ldc           #5                  // String synchronized 方法
     *          5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *          8: return
     *       LineNumberTable:
     *         line 59: 0
     *         line 60: 8
     *       LocalVariableTable:
     *         Start  Length  Slot  Name   Signature
     *             0       9     0  this   Lcn/henry/demo/synchronize/SynchronizedDemo;
     */
    public synchronized void method2() {
        /**
         * synchronized 修饰的方法并没有 monitorenter 指令和 monitorexit 指令，取得代之的确实是 ACC_SYNCHRONIZED 标识，
         * 该标识指明了该方法是一个同步方法，JVM 通过该 ACC_SYNCHRONIZED 访问标志来辨别一个方法是否声明为同步方法，从而执行相应的同步调用。
         */
        System.out.println("synchronized 方法");
    }

    /**
     *  public synchronized void method3();
     *     descriptor: ()V
     *     flags: (0x0021) ACC_PUBLIC, ACC_SYNCHRONIZED
     *     Code:
     *       stack=2, locals=1, args_size=1
     *          0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *          3: ldc           #6                  // String synchronized 静态 方法
     *          5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *          8: return
     *       LineNumberTable:
     *         line 92: 0
     *         line 93: 8
     *       LocalVariableTable:
     *         Start  Length  Slot  Name   Signature
     *             0       9     0  this   Lcn/henry/demo/synchronize/SynchronizedDemo;
     */
    public synchronized void method3() {
        //与上无太大差异
        System.out.println("synchronized 静态 方法");
    }

}
