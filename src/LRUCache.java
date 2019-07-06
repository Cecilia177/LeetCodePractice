import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap {
    private final int SIZE;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        SIZE = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > SIZE;
    }

    public int get(int key) {
        if(this.containsKey(key)) {
            return (int)super.get(key);
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {
        super.put(key, value);
    }
}

class LRUCacheTest {
    LRUCache lruCache = new LRUCache(10);
    public void test() {
        for(int i = 0; i < 10; i++) {
            lruCache.put(i, i);
        }
        System.out.println("init: " + lruCache.toString());

        lruCache.get(7);
        System.out.println(lruCache.toString());

        lruCache.put(8, 9);
        System.out.println(lruCache.toString());

        lruCache.put(10, 10);
        System.out.println(lruCache.toString());
    }



}