package cn.henry.demo.testthis;

import org.junit.Test;

public class TestThis {


    @Test
    public void testThis(){

        System.out.println(this);
        System.out.println(TestThis.this);

        saysay(new ISayService() {
            @Override
            public void say() {
                System.out.println(this);
                System.out.println(TestThis.this);
            }
        });
    }


    public void saysay(ISayService sayService){
        sayService.say();

    }
}
