package PostManagement;

public class LikePost {
    public static void like(int postId, String username) {
        for (Post post : PostDatabase.allPosts) {
            if (post.getId() == postId) {
                if (post.getLikes().contains(username)) {
                    System.out.println("Already liked.");
                    return;
                }
                post.addLike(username);
                System.out.println("Post liked!");
                return;
            }
        }
        System.out.println("Post not found.");
    }
}
