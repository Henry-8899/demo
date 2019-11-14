package cn.henry.demo.lru;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 探究LRU算法机制
 * least recently used algorithm
 */
public class TestLRU {

    class LRUCache<K, V> extends LinkedHashMap<K, V> {

        private static final int MAX_ENTRIES = 3;

        LRUCache() {
            super(MAX_ENTRIES, 0.75f, true);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > MAX_ENTRIES;
        }

    }


    @Test
    public void test() {
        LRUCache<Object, Object> cache = new LRUCache<>();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put("io", "c");

        //LinkedHashMap 的get() 是根据key值查找的，不是索引
        System.out.println(cache.get(0));  //null

        //此时取得该key元素对应值，同时该键值对放在队列的首位
        System.out.println(cache.get(1));

        //超过阀值 最老元素会删除，加入新的
        cache.put(4, "d");
        System.out.println(cache.keySet()); //[io, 1, 4]

    }
}
