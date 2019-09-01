package cn.henry.demo.enumset;

import org.junit.Test;

public class TestIntEnum {

    @Test
    public void Test(){
        IntEnum.applyStyles(IntEnum.STYLE_BOLD | IntEnum.STYLE_ITALIC);
    }
}
