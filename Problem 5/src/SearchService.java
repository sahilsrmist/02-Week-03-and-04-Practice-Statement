import java.util.Arrays;
import java.util.Comparator;

public class SearchService {

    /**
     * Linear Search: Finds first and last occurrences.
     * Time Complexity: O(n)[cite: 124].
     */
    public void linearSearch(TransactionLog[] logs, String targetId) {
        int firstIndex = -1;
        int lastIndex = -1;
        int comparisons = 0;

        for (int i = 0; i < logs.length; i++) {
            comparisons++;
            if (logs[i].accountId.equals(targetId)) {
                if (firstIndex == -1) firstIndex = i;
                lastIndex = i;
            }
        }

        System.out.println("\n--- Linear Search Results ---");
        System.out.println("First Occurrence Index: " + firstIndex);
        System.out.println("Last Occurrence Index: " + lastIndex);
        System.out.println("Total Comparisons: " + comparisons);
    }

    /**
     * Binary Search: Exact match and count occurrences[cite: 121].
     * Requires sorted input[cite: 125].
     * Time Complexity: O(log n)[cite: 125].
     */
    public void binarySearchAndCount(TransactionLog[] logs, String targetId) {
        // Step 1: Ensure logs are sorted by ID for Binary Search [cite: 121]
        Arrays.sort(logs, Comparator.comparing(l -> l.accountId));

        int low = 0;
        int high = logs.length - 1;
        int comparisons = 0;
        int foundIndex = -1;

        while (low <= high) {
            comparisons++;
            int mid = low + (high - low) / 2; // Mid logic [cite: 128]
            int res = targetId.compareTo(logs[mid].accountId);

            if (res == 0) {
                foundIndex = mid;
                break;
            } else if (res > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (foundIndex != -1) {
            int count = countOccurrences(logs, targetId, foundIndex);
            System.out.println("\n--- Binary Search Results ---");
            System.out.println("Found at index (sorted): " + foundIndex);
            System.out.println("Total occurrences: " + count);
        } else {
            System.out.println("Account ID not found.");
        }
        System.out.println("Total Comparisons: " + comparisons);
    }

    private int countOccurrences(TransactionLog[] logs, String targetId, int foundIndex) {
        int count = 1;
        // Check left
        for (int i = foundIndex - 1; i >= 0 && logs[i].accountId.equals(targetId); i--) count++;
        // Check right
        for (int i = foundIndex + 1; i < logs.length && logs[i].accountId.equals(targetId); i++) count++;
        return count;
    }
}