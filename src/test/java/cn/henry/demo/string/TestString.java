package cn.henry.demo.string;

import org.junit.Test;

public class TestString {

    /**
     * 测试目的：和同事发生争执，我说创建了2 or 1 String对象；同事一直说2个；
     * 答案： 2 or 1
     */
    @Test
    public void test() {
        String s3 = new String("123");
        String s4 = new String("123");

        System.out.println(s3 == s4); //false

        int i = s3.hashCode();
        System.out.println(i);

        int i1 = s4.hashCode();
        System.out.println(i1);

        System.out.println(s3.intern() == s4.intern()); //true
    }
}
