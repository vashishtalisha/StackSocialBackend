package PostManagement;

import java.io.*;
import java.util.*;

public class PostDataStorage {
    private static final String FILE_NAME = "posts.txt";

    public static void savePosts() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Post post : PostDatabase.allPosts) {
                // Format: id|username|content|timestamp
                pw.println(post.getId() + "|" + post.getUsername() + "|" + post.getContent().replace("|", " ") + "|" + post.getTimestamp().getTime());
            }
        } catch (IOException e) {
            System.out.println("Error saving posts: " + e.getMessage());
        }
    }

    public static void loadPosts() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

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
                // Overwrite default ID & timestamp
                PostDatabase.allPosts.add(post);
                PostDatabase.userPosts.computeIfAbsent(username, k -> new ArrayList<>()).add(post);

                // Set ID manually
                try {
                    java.lang.reflect.Field idField = Post.class.getDeclaredField("id");
                    idField.setAccessible(true);
                    idField.set(post, id);

                    java.lang.reflect.Field timeField = Post.class.getDeclaredField("timestamp");
                    timeField.setAccessible(true);
                    timeField.set(post, new Date(timestamp));
                } catch (Exception ignored) {}
            }
        } catch (IOException e) {
            System.out.println("Error loading posts: " + e.getMessage());
        }
    }
}
