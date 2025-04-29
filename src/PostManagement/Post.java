package PostManagement;

import java.util.*;

public class Post {
    private static int counter = 1;
    private int id;
    private String username;
    private String content;
    private Stack<String> history;  // for edit history
    private Set<String> likes;
    private List<String> comments;

    public Post(String username, String content) {
        this.id = counter++;
        this.username = username;
        this.content = content;
        this.history = new Stack<>();
        this.likes = new HashSet<>();
        this.comments = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getContent() { return content; }
    public Stack<String> getHistory() { return history; }
    public Set<String> getLikes() { return likes; }
    public List<String> getComments() { return comments; }

    public void edit(String newContent) {
        history.push(this.content);
        this.content = newContent;
    }

    public void addLike(String username) {
        likes.add(username);
    }

    public void addComment(String comment) {
        comments.add(comment);
    }
}
