package cn.henry.demo.hashmap;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {

    @Test
    public void test() {


        /**
         * @see https://www.jianshu.com/p/5dbaa6707017
         * jdk<=1.7 segment数组 + hashEntry数组
         * jdk>=1.8 CAS + Synchronized
         */
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>(5);

        /**
         * 这个put的过程很清晰，对当前的table进行无条件自循环直到put成功，可以分成以下六步流程来概述：
         *
         * 1、判断Node[]数组是否初始化，没有则进行初始化操作
         * 2、通过hash定位数组的索引坐标，是否有Node节点，如果没有则使用CAS进行添加（链表的头节点），添加失败则进入下次循环。
         * 3、检查到内部正在扩容，就帮助它一块扩容。
         * 4、如果f！=null，则使用synchronized锁住f元素（链表/红黑树的头元素）。如果是Node（链表结构）则执行链表的添加操作；如果是TreeNode（树型结构）则执行树添加操作。
         * 5、判断链表长度已经达到临界值8（默认值），当节点超过这个值就需要把链表转换为树结构。
         * 6、如果添加成功就调用addCount（）方法统计size，并且检查是否需要扩容
         */
        concurrentHashMap.put("1","a");
    }
}
