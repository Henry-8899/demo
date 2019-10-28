package cn.henry.demo.testthis;

import org.junit.Test;

public class TestThis {


    /**
     * cn.henry.demo.testthis.TestThis@5faeada1
     * cn.henry.demo.testthis.TestThis@5faeada1
     * cn.henry.demo.testthis.TestThis$1@1563da5
     * cn.henry.demo.testthis.TestThis@5faeada1
     * SayServiceImpl-this : cn.henry.demo.testthis.TestThis$2@33c7e1bb
     */
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


        saysay(new SayServiceImpl() {});
    }


    public void saysay(ISayService sayService){
        sayService.say();

    }
}
