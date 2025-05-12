package PostManagement;

import java.io.*;
import java.util.*;

public class PostDataStorage {
    private static final String FILE_NAME = "posts.txt";

    // Track new posts created during this session
    private static List<Post> newPosts = new ArrayList<>();

    // Load posts from file at the start
    public static void loadPosts() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        // 🧹 Clear existing in-memory posts to avoid duplicates
        PostDatabase.allPosts.clear();
        PostDatabase.userPosts.clear();

        int maxId = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|", 4);
                if (parts.length != 4) continue;

                int id = Integer.parseInt(parts[0]);
                String username = parts[1];
                String content = parts[2];
                long timestamp = Long.parseLong(parts[3]);

                Post post = new Post(username, content);

                // Manually set ID and timestamp
                try {
                    java.lang.reflect.Field idField = Post.class.getDeclaredField("id");
                    idField.setAccessible(true);
                    idField.set(post, id);

                    java.lang.reflect.Field timeField = Post.class.getDeclaredField("timestamp");
                    timeField.setAccessible(true);
                    timeField.set(post, new java.util.Date(timestamp));
                } catch (Exception ignored) {}

                PostDatabase.allPosts.add(post);
                PostDatabase.userPosts.computeIfAbsent(username, k -> new ArrayList<>()).add(post);

                maxId = Math.max(maxId, id);
            }

            // 🔧 Reset Post.counter so new posts don't reuse IDs
            java.lang.reflect.Field counterField = Post.class.getDeclaredField("counter");
            counterField.setAccessible(true);
            counterField.setInt(null, maxId + 1);

        } catch (IOException | NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Error loading posts: " + e.getMessage());
        }
    }


    // Save only newly created posts to the file (append mode)
    public static void savePosts() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME, true))) {  // Change here: 'true' to append
            // Save only newly created posts
            for (Post post : newPosts) {
                pw.println(post.getId() + "|" + post.getUsername() + "|" + post.getContent().replace("|", " ") + "|" + post.getTimestamp().getTime());
            }
            // Clear newPosts after saving
            newPosts.clear();
        } catch (IOException e) {
            System.out.println("Error saving posts: " + e.getMessage());
        }
    }

    // Add new post to the list for later saving
    public static void addNewPost(Post post) {
        newPosts.add(post);
    }
}
