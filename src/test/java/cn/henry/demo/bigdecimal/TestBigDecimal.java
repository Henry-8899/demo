package cn.henry.demo.bigdecimal;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestBigDecimal {


    /**
     * setScale()的用法
     */
    @Test
    public void test() {

        BigDecimal bigDecimal = new BigDecimal("2000.5215").setScale(0, RoundingMode.DOWN);
        System.out.println(bigDecimal);
    }


}
