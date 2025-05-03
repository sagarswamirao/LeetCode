class Twitter {
    private static int timestamp = 0;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<Post>> userPosts;

    public Twitter() {
        followMap = new HashMap<>();
        userPosts = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        userPosts.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Post(tweetId, timestamp++));
    }

    //Similar to Merge K Sorted Lists
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> follows = followMap.getOrDefault(userId, new HashSet<>());
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int uid : follows) {
            List<Post> posts = userPosts.getOrDefault(uid, new ArrayList<>());
            int lastIdx = posts.size() - 1;
            if (lastIdx >= 0) {
                Post p = posts.get(lastIdx);
                maxHeap.offer(new int[]{p.timestamp, p.tweetId, uid, lastIdx - 1});
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty() && result.size() < 10) {
            int[] top = maxHeap.poll();
            result.add(top[1]); // tweetId
            int idx = top[3];
            if (idx >= 0) {
                Post nextPost = userPosts.get(top[2]).get(idx);
                maxHeap.offer(new int[]{nextPost.timestamp, nextPost.tweetId, top[2], idx - 1});
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            followMap.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
        }
    }

    private static class Post {
        int tweetId;
        int timestamp;

        public Post(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }
}
