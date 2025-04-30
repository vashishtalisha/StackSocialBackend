package PostManagement;

import java.util.*;

public class Post {
    private static int counter = 1;
    private int id;
    private String username;
    private String content;
    private Stack<String> history;           // For edit history
    private Set<String> likes;
    private List<String> comments;
    private Date timestamp;                  // For sorting by time

    public Post(String username, String content) {
        this.id = counter++;
        this.username = username;
        this.content = content;
        this.history = new Stack<>();
        this.likes = new HashSet<>();
        this.comments = new ArrayList<>();
        this.timestamp = new Date();         // Save time of creation
    }

    // --- GETTERS ---
    public int getId() { return id; }

    public String getUsername() { return username; }

    public String getContent() { return content; }

    public Stack<String> getHistory() { return history; }

    public Set<String> getLikes() { return likes; }

    public int getLikeCount() { return likes.size(); }

    public List<String> getComments() { return comments; }

    public Date getTimestamp() { return timestamp; }

    // --- CORE METHODS ---

    public void edit(String newContent) {
        history.push(this.content);
        this.content = newContent;
        this.timestamp = new Date(); // Update timestamp on edit
    }

    public void addLike(String username) {
        likes.add(username);
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public void viewPost() {
        System.out.println("\n--- Post ID: " + id + " ---");
        System.out.println("User: " + username);
        System.out.println("Time: " + timestamp);
        System.out.println("Content: " + content);
        System.out.println("Likes: " + getLikeCount());
        System.out.println("Comments: " + comments);
    }
}
