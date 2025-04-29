package UserManagement;

public class ViewProfile {
    public static void view(String username) {
        User user = UserDatabase.users.get(username);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        System.out.println("Username: " + user.getUsername());
        System.out.println("Posts:");
        for (String post : user.getPosts()) {
            System.out.println("- " + post);
        }
        System.out.println("Followers:");
        for (String follower : user.getFollowers()) {
            System.out.println("- " + follower);
        }
    }
}
