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
            System.out.println("Post ID: " + post.getId());
            System.out.println("Content: " + post.getContent());
            System.out.println("Likes: " + post.getLikes().size());
            System.out.println("Comments:");
            for (String c : post.getComments()) {
                System.out.println("- " + c);
            }
            System.out.println("-------------------");
        }
    }
}
