package com.zhoux.leetcode.punch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author:zhouxiang
 * @date:2020-04-13
 * @describe:
 * @status:
 */
public class Twitter {

    private Map<Integer, News> twitter = new HashMap<>();
    /**
     * 用户被关注的用户列表映射
     */
    private Map<Integer, Set<Integer>> follows = new HashMap<>();

    int timeStamp = 0;

    class News{
        private int tweetId;
        private int timeStamp;
        News next;

        public News(int tweetId, int timeStamp) {
            this.tweetId = tweetId;
            this.timeStamp = timeStamp;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Twitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        timeStamp++;
        News oldhead = twitter.get(userId);
        News newHead = new News(tweetId,timeStamp);
        newHead.next = oldhead;
        twitter.put(userId,newHead);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user
     * followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();

        Set<Integer> followSet = follows.get(userId);
        if(null == followSet){
            followSet = new HashSet<>();
        }
        followSet.add(userId);

        List<News> newsList = new ArrayList<>();
        for (Integer integer : followSet) {
            if(twitter.containsKey(integer)){
                newsList.add(twitter.get(integer));
            }
        }
        PriorityQueue<News> queue = new PriorityQueue<>(new Comparator<News>() {
            @Override
            public int compare(News o1, News o2) {
                return -o1.timeStamp+o2.timeStamp;
            }
        });

        for (News news : newsList) {
            queue.add(news);
            while (null!=news.next){
                queue.add(news.next);
                news = news.next;
            }
        }
        int size=10;
        while (size-->0){
            News news = queue.poll();
            if(null==news)
                break;
            if(null!=news){
                list.add(news.tweetId);
            }
        }
        return list;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = follows.get(followerId);
        if (null == set) {
            set = new HashSet<>();
        }
        set.add(followeeId);
        follows.put(followerId, set);

    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = follows.get(followerId);
        if (null == set) {
            return;
        }
        set.remove(followeeId);
        follows.put(followerId, set);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);

        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        twitter.getNewsFeed(1);

        // 用户1关注了用户2.
        twitter.follow(2, 1);

        // 用户2发送了一个新推文 (推文id = 6).
//        twitter.postTweet(2, 6);

        // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
            // 推文id6应当在推文id5之前，因为它是在5之后发送的.
        twitter.getNewsFeed(2);

        // 用户1取消关注了用户2.
        twitter.unfollow(2, 1);

        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        // 因为用户1已经不再关注用户2.
        twitter.getNewsFeed(2);
    }
}
