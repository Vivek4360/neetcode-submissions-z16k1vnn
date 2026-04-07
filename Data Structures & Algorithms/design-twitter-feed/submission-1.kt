class Twitter {
    companion object { var timestamp = 0 }

    private val followees = mutableMapOf<Int, MutableSet<Int>>()
    private val tweets = mutableMapOf<Int, MutableList<Tweet>>()

    data class Tweet(val id: Int, val time: Int)

    fun postTweet(userId: Int, tweetId: Int) {
        tweets.putIfAbsent(userId, mutableListOf())
        tweets[userId]!!.add(Tweet(tweetId, timestamp++))
    }

    fun follow(followerId: Int, followeeId: Int) {
        if(followerId == followeeId) return
        followees.putIfAbsent(followerId, mutableSetOf())
        followees[followerId]!!.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        followees[followerId]?.remove(followeeId)
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val pq = PriorityQueue<Tweet>(compareByDescending { it.time })

        tweets[userId]?.let { pq.addAll(it) }
        followees[userId]?.forEach { fId -> tweets[fId]?.let { pq.addAll(it) } }

        val res = mutableListOf<Int>()
        repeat(10) { if(pq.isNotEmpty()) res.add(pq.poll().id) }
        return res
    }
}
