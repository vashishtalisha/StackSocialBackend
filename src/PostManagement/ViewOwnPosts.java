package PostManagement;

import java.util.List;

public class ViewOwnPosts {
    public static void view(String username) {
        List<Post> posts = PostDatabase.userPosts.get(username);
        if (posts == null || posts.isEmpty()) {
            System.out.println("No posts found.");
            return;
        }

        for (Post post : posts) {
            System.out.println("DEBUG viewing post " + post.getId() + " - Likes: " + post.getLikes());
            post.viewPost();
        }

    }
}
