package UserManagement;

import java.io.*;
import java.util.*;

public class UserDataStorage {
    private static final String FILE_NAME = "users.txt";

    public static void saveUsers(HashMap<String, User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User user : users.values()) {
                String posts = String.join(",", user.getPosts());
                String followers = String.join(",", user.getFollowers());
                writer.write(user.getUsername() + "|" + user.getPassword() + "|" + posts + "|" + followers);
                writer.newLine();
            }
            System.out.println("Saved users to users.txt");
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    public static HashMap<String, User> loadUsers() {
        HashMap<String, User> users = new HashMap<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("users.txt not found, starting with empty data.");
            return users;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // username|password|post1,post2|follower1,follower2
                String[] parts = line.split("\\|", -1); // allow empty fields
                if (parts.length < 4) continue;

                String username = parts[0];
                String password = parts[1];
                List<String> posts = parts[2].isEmpty() ? new ArrayList<>() : Arrays.asList(parts[2].split(","));
                Set<String> followers = parts[3].isEmpty() ? new HashSet<>() : new HashSet<>(Arrays.asList(parts[3].split(",")));

                User user = new User(username, password);
                user.getPosts().addAll(posts);
                user.getFollowers().addAll(followers);
                users.put(username, user);
            }
            System.out.println("Loaded users from users.txt");
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }

        return users;
    }
}
