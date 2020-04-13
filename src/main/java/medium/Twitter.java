package medium;

import java.util.*;

/**
 * @author Yasin Zhang
 */
public class Twitter {

    private HashMap<Integer, LinkedList<Message>> twitterIndex;
    private HashMap<Integer, HashSet<Integer>> followIndex;

    /** Initialize your data structure here. */
    public Twitter() {
        twitterIndex = new HashMap<>();
        followIndex = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (twitterIndex.containsKey(userId)) {
            twitterIndex.get(userId).addFirst(new Message(tweetId));
        } else {
            LinkedList<Message> tweets = new LinkedList<>();
            tweets.addFirst(new Message(tweetId));
            twitterIndex.put(userId, tweets);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<LinkedList<Message>> tweets = new ArrayList<>();
        int total = 0;

        if (!twitterIndex.containsKey(userId) && !followIndex.containsKey(userId)) {
            return result;
        }

        if (twitterIndex.containsKey(userId)) {
            tweets.add(twitterIndex.get(userId));
            total += twitterIndex.get(userId).size();
        }

        Set<Integer> followees = followIndex.get(userId);
        if (followees != null) {
            for (int followee : followees) {
                LinkedList<Message> messages = twitterIndex.get(followee);
                if (messages != null) {
                    tweets.add(messages);
                    total += messages.size();
                }
            }
        }


        int[] count = new int[tweets.size()];
        while (result.size() < total && result.size() < 10) {
            int maxIndex = 0;
            long max = 0;
            for (int i = 0; i < tweets.size(); i++) {
                if (count[i] < tweets.get(i).size()) {
                    long curTime = tweets.get(i).get(count[i]).time;
                    if (curTime > max) {
                        max = curTime;
                        maxIndex = i;
                    }
                }

            }
            result.add(tweets.get(maxIndex).get(count[maxIndex]).tweetId);
            count[maxIndex]++;
        }


        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        if (followIndex.containsKey(followerId)) {
            followIndex.get(followerId).add(followeeId);
        } else {
            HashSet<Integer> followees = new HashSet<>();
            followees.add(followeeId);
            followIndex.put(followerId, followees);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> followees = followIndex.get(followerId);

        if (followees != null) {
            followees.remove(followeeId);
        }
    }

    static class Message {
        static long count = 0;

        int tweetId;
        long time;

        Message(int tweetId) {
            this.tweetId = tweetId;
            time = ++count;
        }

        @Override
        public String toString() {
            return "{" + tweetId +
                ", " + time +
                '}';
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
}
