package TrendingFeed;

import PostManagement.Post;

import java.util.ArrayList;
import java.util.List;

public class SearchPosts {
    public static List<Post> searchPostsByKeyword(List<Post> allPosts, String keyword) {
        List<Post> result = new ArrayList<>();
        for (Post post : allPosts) {
            if (post.getContent().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(post);
            }
        }
        return result;
    }
}
