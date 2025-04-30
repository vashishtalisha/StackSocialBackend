package FollowersSystem;

import java.util.*;

public class FollowSuggestions {
    public static Set<String> getSuggestions(String username) {
        Set<String> suggestions = new HashSet<>();
        Set<String> following = FollowGraph.graph.getOrDefault(username, new HashSet<>());

        for (String friend : following) {
            Set<String> friendsOfFriend = FollowGraph.graph.getOrDefault(friend, new HashSet<>());
            for (String user : friendsOfFriend) {
                if (!user.equals(username) && !following.contains(user)) {
                    suggestions.add(user);
                }
            }
        }

        return suggestions;
    }

    public static void printSuggestions(String username) {
        Set<String> suggestions = getSuggestions(username);
        System.out.println("\nFollow Suggestions for " + username + ":");
        if (suggestions.isEmpty()) {
            System.out.println("No suggestions.");
        } else {
            for (String s : suggestions) {
                System.out.println("- " + s);
            }
        }
    }
}
