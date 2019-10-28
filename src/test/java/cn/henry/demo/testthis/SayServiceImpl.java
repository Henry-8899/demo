package cn.henry.demo.testthis;

public class SayServiceImpl implements ISayService{

    @Override
    public void say() {
        System.out.println("SayServiceImpl-this : " + this);
    }
}
