import java.util.*;

/**
 * Created by larryliu on 9/18/16.
 * FB phone interview
 * 给你一个user_id 和API 接口 get_friend(int id),
 让你找出所有user id 是你的朋友的朋友但不是你的朋友，然后根据mutual friends的数量排序
 */
public class TwoDegreeFriend {
    public List<Integer> getFriend(int id) {
        return new ArrayList<>();
    }

    public List<Integer> get2ndDegFriends(int id) {
        User user = new User(id);
        user.friends.addAll(getFriend(id));
        List<User> twoDegFriends = new ArrayList<>();
        for (int fid : user.friends) {
            for (int ff : getFriend(fid)) {
                if(user.friends.contains(ff)) continue;
                User u = new User(ff);
                u.specialUser = user;
                u.friends.addAll(getFriend(ff));
                twoDegFriends.add(u);
            }
        }
        Collections.sort(twoDegFriends);
        List<Integer> result = new ArrayList<>();
        for (User f : twoDegFriends) result.add(f.id);
        return result;
    }

    private class User implements Comparable<User> {
        int id;
        Set<Integer> friends;
        User specialUser;

        public User(int id) {
            this.id = id;
        }
        @Override
        public int compareTo(User f) {
            return numMutualFriends() - f.numMutualFriends();
        }

        private int numMutualFriends() {
            int count = 0;
            for (int u: friends) {
                if (specialUser.friends.contains(u)) count++;
            }
            return count;
        }
    }
}
