package PostManagement;

import java.util.*;

public class CreatePost {
    public static void create(String username, String content) {
        Post post = new Post(username, content);
        PostDatabase.allPosts.add(post);
        PostDatabase.userPosts.computeIfAbsent(username, k -> new ArrayList<>()).add(post);

        // Track the new post to be saved later
        PostDataStorage.addNewPost(post);

        // Save posts to the file immediately after creating the post
        PostDataStorage.savePosts();

        System.out.println("Post created with ID: " + post.getId());
    }
}
