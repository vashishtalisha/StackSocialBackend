package PostManagement;

import java.util.*;

public class PostDatabase {
    public static List<Post> allPosts = new ArrayList<>();
    public static Map<String, List<Post>> userPosts = new HashMap<>();
    static {
        PostDataStorage.loadPosts();
    }

}
