class Twitter {
    public class Pair{
        int userId;
        int tweetId;
        Pair(int userId, int tweetId){
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }
    
    Map<Integer,List<Integer>> followMap;
    List<Pair> list;
    /** Initialize your data structure here. */
    public Twitter() {
        followMap = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Pair obj = new Pair(userId,tweetId);
        list.add(obj);
        if(!followMap.containsKey(userId)){
            followMap.put(userId,new ArrayList<Integer>());
        }
        if(!followMap.get(userId).contains(userId))
            followMap.get(userId).add(userId);
        //System.out.println("followmap at first tweet - "+followMap.get(userId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> checkList = new ArrayList<>();
        checkList = followMap.get(userId);
        List<Integer> retList = new ArrayList<>();
        int i = list.size()-1;
        int count=0;
        while(i>=0 && count<10){
            Pair temp = list.get(i);
            if(checkList.contains(temp.userId)){
                retList.add(temp.tweetId);
                count++;
            }
            i--;
        }
        return retList;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId)){
            followMap.put(followerId,new ArrayList<Integer>());
        }
        followMap.get(followerId).add(followeeId);
        if(!followMap.get(followerId).contains(followerId))
            followMap.get(followerId).add(followerId);
        //System.out.println("followmap at follow - "+followMap.get(followerId));
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        followMap.get(followerId).remove(new Integer(followeeId));
        //System.out.println("followmap at unfollow - "+followMap.get(followerId));
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