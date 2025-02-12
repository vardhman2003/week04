import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>(); // Store votes
    private Map<String, Integer> insertionOrderMap = new LinkedHashMap<>(); // Preserve vote order
    private TreeMap<String, Integer> sortedVoteMap = new TreeMap<>(); // Sorted results

    // Cast a vote for a candidate
    public void vote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        insertionOrderMap.put(candidate, insertionOrderMap.getOrDefault(candidate, 0) + 1);
        sortedVoteMap.put(candidate, sortedVoteMap.getOrDefault(candidate, 0) + 1);
    }

    // Get results sorted alphabetically
    public Map<String, Integer> getResultsSorted() {
        return sortedVoteMap;
    }

    // Get results in the order votes were received
    public Map<String, Integer> getResultsInOrder() {
        return insertionOrderMap;
    }

    // Get results based on vote count (Descending Order)
    public List<Map.Entry<String, Integer>> getResultsByVotes() {
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(voteMap.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue())); // Sort by votes (descending)
        return sortedList;
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        // Voting process
        system.vote("Alice");
        system.vote("Bob");
        system.vote("Alice");
        system.vote("Charlie");
        system.vote("Bob");
        system.vote("Bob");

        // Display results
        System.out.println("Results Sorted by Name: " + system.getResultsSorted());
        System.out.println("Results in Vote Order: " + system.getResultsInOrder());
        System.out.println("Results by Vote Count: " + system.getResultsByVotes());
    }
}
