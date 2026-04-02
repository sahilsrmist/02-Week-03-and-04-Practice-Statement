import java.util.Arrays;
import java.util.Comparator;

public class RiskLookupService {

    /**
     * Linear Search: Checks unsorted bands for a match.
     * Time Complexity: O(n).
     */
    public void linearSearch(RiskBand[] bands, int target) {
        int comparisons = 0;
        int foundIndex = -1;

        for (int i = 0; i < bands.length; i++) {
            comparisons++;
            if (bands[i].threshold == target) {
                foundIndex = i;
                break;
            }
        }

        System.out.println("\n--- Linear Search Result ---");
        if (foundIndex != -1) {
            System.out.println("Threshold " + target + " found at index: " + foundIndex);
        } else {
            System.out.println("Threshold " + target + " not found.");
        }
        System.out.println("Total Comparisons: " + comparisons);
    }

    /**
     * Binary Search: Finds Floor and Ceiling in a sorted array.
     * Prerequisite: Array must be sorted.
     * Time Complexity: O(log n).
     */
    public void findFloorCeiling(RiskBand[] bands, int target) {
        // Ensure array is sorted 
        Arrays.sort(bands, Comparator.comparingInt(b -> b.threshold));

        int low = 0, high = bands.length - 1;
        int floor = -1, ceiling = -1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = low + (high - low) / 2;

            if (bands[mid].threshold == target) {
                floor = ceiling = bands[mid].threshold;
                break;
            } else if (bands[mid].threshold < target) {
                floor = bands[mid].threshold; // Potential floor [cite: 148]
                low = mid + 1;
            } else {
                ceiling = bands[mid].threshold; // Potential ceiling [cite: 148]
                high = mid - 1;
            }
        }

        System.out.println("\n--- Binary Search (Floor/Ceiling) ---");
        System.out.println("Target: " + target);
        System.out.println("Floor (Largest <= Target): " + (floor != -1 ? floor : "None"));
        System.out.println("Ceiling (Smallest >= Target): " + (ceiling != -1 ? ceiling : "None"));
        System.out.println("Comparisons: " + comparisons);
    }
}