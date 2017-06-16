package hashTable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

class Wrapper{
    ArrayList<Integer> list;
    int index;
 
    public Wrapper(ArrayList<Integer> list, int index){
        this.list=list;
        this.index=index;
    }
}
 
public class Al355_DesignTwitter {
    HashMap<Integer, HashSet<Integer>> userMap;//user and followees
    HashMap<Integer, ArrayList<Integer>> tweetMap;//user and tweets
    HashMap<Integer, Integer> orderMap; //tweet and order
    int order; //global order counter
 
    /** Initialize your data structure here. */
    public Al355_DesignTwitter() {
        userMap = new HashMap<Integer, HashSet<Integer>>();
        tweetMap = new HashMap<Integer, ArrayList<Integer>>();
        orderMap = new HashMap<Integer, Integer>();
        
    }
 
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        ArrayList<Integer> list = tweetMap.get(userId);
        if(list==null){
            list = new ArrayList<Integer>();
            tweetMap.put(userId, list);
        }
        list.add(tweetId);
        orderMap.put(tweetId, order++);
        follow(userId, userId);//follow himself
    }
 
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        HashSet<Integer> set = userMap.get(userId);
        if(set==null)
            return new ArrayList<Integer>();
 
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
 
        //get all users' tweets
        for(int uid: set){
            if(tweetMap.get(uid)!=null && tweetMap.get(uid).size()>0)
                lists.add(tweetMap.get(uid));
        }
 
        ArrayList<Integer> result = new ArrayList<Integer>();
 
        PriorityQueue<Wrapper> queue = new PriorityQueue<Wrapper>(new Comparator<Wrapper>(){
            public int compare(Wrapper a, Wrapper b){
                return orderMap.get(b.list.get(b.index))-orderMap.get(a.list.get(a.index));
            }
        });
 
        for(ArrayList<Integer> list: lists){
            queue.offer(new Wrapper(list, list.size()-1));
        }
 
        while(!queue.isEmpty() && result.size()<10){
            Wrapper top = queue.poll();
            result.add(top.list.get(top.index));
 
            top.index--;
 
            if(top.index>=0)
                queue.offer(top);
        }
 
        return result;
    }
 
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> set = userMap.get(followerId);
        if(set==null){
            set = new HashSet<Integer>();
            userMap.put(followerId, set);
        }
        set.add(followeeId);
    }
 
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId)
            return ;
 
        HashSet<Integer> set = userMap.get(followerId);
        if(set==null){
            return;
        }
 
        set.remove(followeeId);
    }
    
	/**
	 * Your Twitter object will be instantiated and called as such:
	 * Twitter obj = new Twitter();
	 * obj.postTweet(userId,tweetId);
	 * List<Integer> param_2 = obj.getNewsFeed(userId);
	 * obj.follow(followerId,followeeId);
	 * obj.unfollow(followerId,followeeId);
	 */
	public static void main(String[] arguments){
		Al355_DesignTwitter obj = new Al355_DesignTwitter();
		obj.postTweet(1,11);
		obj.postTweet(1,12);
		obj.postTweet(1,13);
		obj.postTweet(2,18);
		obj.postTweet(2,19);
		List<Integer> param_2 = obj.getNewsFeed(1);
		System.out.println("tweet: " + obj.tweetMap.toString());
		System.out.println("param_2: " + param_2.toString());
		obj.follow(1,2);
		System.out.println("followers_2: " + obj.userMap.toString());
		obj.postTweet(2,20);
		obj.postTweet(1,22);
		obj.postTweet(2,21);
		List<Integer> param_3 = obj.getNewsFeed(1);
		System.out.println("param_3: " + param_3.toString());
		obj.unfollow(1,2);	
		List<Integer> param_4 = obj.getNewsFeed(1);
		System.out.println("param_4: " + param_4.toString());
		System.out.println("followers_4: " + obj.orderMap.toString());
	}    
}