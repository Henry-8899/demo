package cn.henry.demo.localcache;

import org.junit.Test;

public class TestLocalCache {

    @Test
    public void test() throws InterruptedException {
        LocalCacheUtil.putValue("test1","a",2);
        System.out.println(LocalCacheUtil.cache);
        Thread.sleep(5000L);


        System.out.println(LocalCacheUtil.cache);
        LocalCacheUtil.putValue("test2","a",2);
        System.out.println(LocalCacheUtil.cache);
    }
}
