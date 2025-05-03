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
        userPosts.computeIfAbsent(userId, k -> new ArrayList<>())
                 .add(new Post(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Post> minHeap = new PriorityQueue<>((a, b) -> a.timestamp - b.timestamp);
        Set<Integer> follows = followMap.getOrDefault(userId, new HashSet<>());

        for (int uid : follows) {
            List<Post> posts = userPosts.getOrDefault(uid, new ArrayList<>());
            for (int i = posts.size() - 1; i >= 0 && posts.size() - i <= 10; i--) {
                minHeap.offer(posts.get(i));
                if (minHeap.size() > 10) minHeap.poll();
            }
        }

        LinkedList<Integer> result = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            result.addFirst(minHeap.poll().tweetId);
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
