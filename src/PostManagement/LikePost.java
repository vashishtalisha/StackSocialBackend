package PostManagement;

public class LikePost {
    public static void like(int postId, String username) {
        for (Post post : PostDatabase.allPosts) {
            if (post.getId() == postId) {
                System.out.println("DEBUG before like - Likes: " + post.getLikes());

                if (post.getLikes().contains(username)) {
                    System.out.println("Already liked.");
                    return;
                }

                post.addLike(username);
                System.out.println("DEBUG after like - Likes: " + post.getLikes());

                System.out.println("Post liked!");
                return;
            }
        }
        System.out.println("Post not found.");
    }
}
