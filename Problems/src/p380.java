import java.util.*;

/**
 * Created by Valued Customer on 7/18/2017.
 * 380. Insert Delete GetRandom O(1)
 */
public class p380 {
    Map<Integer, Integer> map;
    List<Integer> nums;
    Random rand = new Random();
    /** Initialize your data structure here. */
    public p380() {
        map = new HashMap<>();
        nums = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        if (contains) return false;
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contains = map.containsKey(val);
        if (contains) {
            int location = map.get(val);
            if (location < nums.size() - 1) {
                int last = nums.get(nums.size() - 1);
                nums.set(location, last);
                map.put(last, location);
            }
            nums.remove(nums.size()-1);
            map.remove(val);
        }
        return contains;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
