import java.util.Arrays;

public class TradeSortingService {

    // --- Merge Sort Logic (Ascending & Stable) ---
    public void mergeSort(Trade[] trades) {
        if (trades.length < 2) return;
        int mid = trades.length / 2;
        Trade[] left = Arrays.copyOfRange(trades, 0, mid);
        Trade[] right = Arrays.copyOfRange(trades, mid, trades.length);

        mergeSort(left);
        mergeSort(right);
        merge(trades, left, right);
    }

    private void merge(Trade[] result, Trade[] left, Trade[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].volume <= right[j].volume) { // Stable comparison
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];
    }

    // --- Quick Sort Logic (Descending & In-place) ---
    public void quickSort(Trade[] trades, int low, int high) {
        if (low < high) {
            int pi = lomutoPartition(trades, low, high);
            quickSort(trades, low, pi - 1);
            quickSort(trades, pi + 1, high);
        }
    }

    private int lomutoPartition(Trade[] trades, int low, int high) {
        int pivot = trades[high].volume;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            // Sort Descending
            if (trades[j].volume >= pivot) {
                i++;
                Trade temp = trades[i];
                trades[i] = trades[j];
                trades[j] = temp;
            }
        }
        Trade temp = trades[i + 1];
        trades[i + 1] = trades[high];
        trades[high] = temp;
        return i + 1;
    }

    // Method to merge two already sorted lists (e.g., Morning + Afternoon)
    public Trade[] mergeTwoSessions(Trade[] session1, Trade[] session2) {
        Trade[] combined = new Trade[session1.length + session2.length];
        merge(combined, session1, session2);
        return combined;
    }
}