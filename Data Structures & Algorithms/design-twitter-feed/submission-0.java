class Twitter {
    private static int timestamp = 0;
    private Map<Integer, Set<Integer>> followees; 
    private Map<Integer, List<Tweet>> tweets;

    private static class Tweet {
        int id, time;
        Tweet(int id, int time) { this.id = id; this.time = time; }
    }

    public Twitter() {
        followees = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        followees.putIfAbsent(followerId, new HashSet<>());
        followees.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(followees.containsKey(followerId))
            followees.get(followerId).remove(followeeId);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> b.time - a.time);

        if(tweets.containsKey(userId)) pq.addAll(tweets.get(userId));

        if(followees.containsKey(userId)) {
            for(int fId : followees.get(userId))
                if(tweets.containsKey(fId)) pq.addAll(tweets.get(fId));
        }

        List<Integer> res = new ArrayList<>();
        int count = 0;
        while(!pq.isEmpty() && count < 10) {
            res.add(pq.poll().id);
            count++;
        }
        return res;
    }
}