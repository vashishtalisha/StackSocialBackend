package PostManagement;
import java.util.*;
public class DeletePost {
    public static void delete(int postId, String username) {
        Post target = null;
        for (Post post : PostDatabase.allPosts) {
            if (post.getId() == postId && post.getUsername().equals(username)) {
                target = post;
                break;
            }
        }

        if (target != null) {
            PostDatabase.allPosts.remove(target);
            List<Post> userPosts = PostDatabase.userPosts.get(username);
            if (userPosts != null) {
                userPosts.remove(target);
            }

            PostDataStorage.savePosts();

            System.out.println("Post deleted.");
        } else {
            System.out.println("Post not found or unauthorized access.");
        }
    }
}
