import java.util.List;

public class SorterService {

    /**
     * Bubble Sort: O(n^2) with early termination[cite: 13, 15].
     */
    public void bubbleSort(List<Transaction> list) {
        int n = list.size();
        int swaps = 0;
        int passes = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            passes++;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Transaction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                    swaps++;
                }
            }
            if (!swapped) break;
        }
        System.out.println("BubbleSort (fees): " + list + " // " + passes + " passes, " + swaps + " swaps [cite: 32]");
    }

    /**
     * Insertion Sort: Stable sort for medium batches[cite: 10, 14].
     */
    public void insertionSort(List<Transaction> list) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            Transaction key = list.get(i);
            int j = i - 1;
            while (j >= 0 && (list.get(j).fee > key.fee ||
                    (list.get(j).fee == key.fee && list.get(j).timestamp.compareTo(key.timestamp) > 0))) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
        System.out.println("InsertionSort (fee+ts): " + list + " [cite: 33]");
    }
}