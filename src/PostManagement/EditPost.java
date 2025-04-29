package PostManagement;

public class EditPost {
    public static void edit(int postId, String newContent, String username) {
        for (Post post : PostDatabase.allPosts) {
            if (post.getId() == postId && post.getUsername().equals(username)) {
                post.edit(newContent);
                System.out.println("Post edited. Previous version pushed to history.");
                return;
            }
        }
        System.out.println("Post not found or unauthorized access.");
    }
}
