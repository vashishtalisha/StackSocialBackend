package FollowersSystem;

public class UnfollowUser {
    public static void unfollow(String currentUser, String targetUser) {
        if (FollowGraph.graph.containsKey(currentUser)) {
            FollowGraph.graph.get(currentUser).remove(targetUser);
            System.out.println(currentUser + " unfollowed " + targetUser);
        } else {
            System.out.println(currentUser + " doesn't follow anyone.");
        }
    }
}
