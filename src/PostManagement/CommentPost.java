package PostManagement;

public class CommentPost {
    public static void comment(int postId, String comment) {
        for (Post post : PostDatabase.allPosts) {
            if (post.getId() == postId) {
                post.addComment(comment);
                System.out.println("Comment added.");
                return;
            }
        }
        System.out.println("Post not found.");
    }
}
