import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;

    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }


    public void put(int key, int value) {
        super.put(key, value);
    }


    // 移除最近最少被访问条件之一，通过覆盖此方法可实现不同策略的缓存
    // LinkedHashMap是默认返回false的，我们可以继承LinkedHashMap然后复写该方法即可
    // 例如 LeetCode 第 146 题就是采用该种方法，直接 return size() > capacity;
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
