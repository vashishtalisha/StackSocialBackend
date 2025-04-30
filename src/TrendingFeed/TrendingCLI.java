package TrendingFeed;
import PostManagement.Post;
import java.util.*;

public class TrendingCLI {
    private List<Post> allPosts;

    public TrendingCLI(List<Post> posts) {
        this.allPosts = posts;
    }

    // Trending posts using Max Heap
    public void showTrendingPosts() {
        PriorityQueue<Post> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getLikeCount() - a.getLikeCount()
        );

        maxHeap.addAll(allPosts);

        System.out.println("\n--- Trending Posts (by likes) ---");
        while (!maxHeap.isEmpty()) {
            Post post = maxHeap.poll();
            post.viewPost();
        }
    }

    // Recent posts using Merge Sort (or built-in)
    public void showRecentPosts() {
        List<Post> sorted = new ArrayList<>(allPosts);
        sorted.sort(Comparator.comparing(Post::getTimestamp).reversed());

        System.out.println("\n--- Recent Posts (by time) ---");
        for (Post post : sorted) {
            post.viewPost();
        }
    }

    // Search by keyword in content
    public void searchPostsByKeyword(String keyword) {
        System.out.println("\n--- Search Results for: \"" + keyword + "\" ---");
        boolean found = false;

        for (Post post : allPosts) {
            if (post.getContent().toLowerCase().contains(keyword.toLowerCase())) {
                post.viewPost();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No posts found containing that keyword.");
        }
    }

    // CLI Menu
    public void runCLI() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Trending Feed Menu ---");
            System.out.println("1. Show Trending Posts");
            System.out.println("2. Show Recent Posts");
            System.out.println("3. Search Posts by Keyword");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    showTrendingPosts();
                    break;
                case 2:
                    showRecentPosts();
                    break;
                case 3:
                    System.out.print("Enter keyword: ");
                    String keyword = sc.nextLine();
                    searchPostsByKeyword(keyword);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // ✅ MAIN METHOD to run this CLI independently
    public static void main(String[] args) {
        List<Post> dummyPosts = new ArrayList<>();

        Post p1 = new Post("alice", "Just joined Stack Social!");
        Post p2 = new Post("bob", "Exploring DSA with Java!");
        Post p3 = new Post("carol", "Heaps are underrated!");

        // Simulate likes
        p1.addLike("bob");
        p1.addLike("carol");

        p2.addLike("alice");

        // Simulate timestamps (if needed)
        dummyPosts.add(p1);
        dummyPosts.add(p2);
        dummyPosts.add(p3);

        TrendingCLI cli = new TrendingCLI(dummyPosts);
        cli.runCLI();
    }
}
