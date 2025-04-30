package TrendingFeed;

import PostManagement.Post;

import java.util.*;

public class TrendingPosts {
    public static List<Post> getTrendingPosts(List<Post> allPosts) {
        PriorityQueue<Post> maxHeap = new PriorityQueue<>((a, b) ->  b.getLikeCount() - a.getLikeCount());
        maxHeap.addAll(allPosts);

        List<Post> trending = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            trending.add(maxHeap.poll());
        }
        return trending;
    }
}
