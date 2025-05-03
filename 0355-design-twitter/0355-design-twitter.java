
import java.util.Collection;

class Post{
    int userId;
    int postId;
    int postTimestamp;
    static int timestamp=0;
    public Post(int userId, int postId){
        this.postId=postId;
        this.userId=userId;
        postTimestamp=timestamp;
        timestamp+=1;
    }
}
class Twitter {

    HashMap<Integer, HashSet<Integer>> followersMap;
    PriorityQueue<Post> posts;
    public Twitter() {
        followersMap=new HashMap<>();
        posts=new PriorityQueue<>((a,b)->b.postTimestamp - a.postTimestamp);
    }
    
    public void postTweet(int userId, int tweetId) {
        followersMap.computeIfAbsent(userId, k -> new HashSet<>(){{add(userId);}});
        posts.add(new Post(userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Post> postsCopy=new PriorityQueue<>(posts);
        HashSet<Integer> followersList=followersMap.get(userId);
        List<Integer> recentPosts=new ArrayList<>();
        int postLimit=10;
        if(followersList!=null && !followersList.isEmpty()){
            while(!postsCopy.isEmpty()){
                Post post= postsCopy.poll();
                if(postLimit>0 && followersList.contains(post.userId)){
                    recentPosts.add(post.postId);
                    postLimit-=1;
                }
            }
        }
        return recentPosts;
    }
    
    public void follow(int followerId, int followeeId) {
        followersMap.computeIfAbsent(followerId, k -> new HashSet<>(){{add(followerId);}}).add(followeeId);   
    }
    
    public void unfollow(int followerId, int followeeId) {
        followersMap.get(followerId).remove(followeeId);
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