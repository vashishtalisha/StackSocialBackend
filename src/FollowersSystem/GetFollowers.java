package FollowersSystem;

import java.util.*;

public class GetFollowers {
    public static Set<String> getFollowers(String username) {
        Set<String> followers = new HashSet<>();
        for (Map.Entry<String, Set<String>> entry : FollowGraph.graph.entrySet()) {
            if (entry.getValue().contains(username)) {
                followers.add(entry.getKey());
            }
        }
        return followers;
    }

    public static void printFollowers(String username) {
        Set<String> followers = getFollowers(username);
        System.out.println("\nFollowers of " + username + ":");
        if (followers.isEmpty()) {
            System.out.println("No followers.");
        } else {
            for (String f : followers) {
                System.out.println("- " + f);
            }
        }
    }
}
