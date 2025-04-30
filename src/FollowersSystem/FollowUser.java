package FollowersSystem;

import java.util.*;

public class FollowUser {
    public static void follow(String currentUser, String targetUser) {
        FollowGraph.graph.putIfAbsent(currentUser, new HashSet<>());
        FollowGraph.graph.get(currentUser).add(targetUser);
        System.out.println(currentUser + " followed " + targetUser);
    }
}
