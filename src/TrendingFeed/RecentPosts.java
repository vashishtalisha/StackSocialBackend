package TrendingFeed;

import PostManagement.Post;

import java.util.*;

public class RecentPosts {
    public static List<Post> getRecentPosts(List<Post> userPosts) {
        return mergeSort(userPosts);
    }

    private static List<Post> mergeSort(List<Post> posts) {
        if (posts.size() <= 1) return posts;

        int mid = posts.size() / 2;
        List<Post> left = mergeSort(posts.subList(0, mid));
        List<Post> right = mergeSort(posts.subList(mid, posts.size()));

        return merge(left, right);
    }

    private static List<Post> merge(List<Post> left, List<Post> right) {
        List<Post> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getTimestamp().after(right.get(j).getTimestamp())) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }

        while (i < left.size()) merged.add(left.get(i++));
        while (j < right.size()) merged.add(right.get(j++));
        return merged;
    }
}
