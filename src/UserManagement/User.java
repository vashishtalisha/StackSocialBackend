package UserManagement;

import java.util.*;

public class User {
    private String username;
    private String password;
    private List<String> posts;
    private Set<String> followers;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.posts = new ArrayList<>();
        this.followers = new HashSet<>();
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public List<String> getPosts() { return posts; }
    public Set<String> getFollowers() { return followers; }

    public void addPost(String post) {
        posts.add(post);
    }

    public void addFollower(String followerUsername) {
        followers.add(followerUsername);
    }
}
