import java.util.ArrayList;
import java.util.List;

public class Transaction_Fee_Sorting {
    public static void main(String[] args) {
        IOService io = new IOService();
        SorterService sorter = new SorterService();

        // Step 1: User Input
        io.displayMessage("--- Banking Audit Compliance System ---");
        List<Transaction> transactions = io.collectTransactions();

        // Step 2: Sorting logic based on batch size [cite: 9, 10]
        if (transactions.isEmpty()) {
            io.displayMessage("No transactions to process.");
        } else if (transactions.size() <= 100) {
            sorter.bubbleSort(new ArrayList<>(transactions));
        } else {
            sorter.insertionSort(new ArrayList<>(transactions));
        }

        // Step 3: Outlier Flagging [cite: 11]
        checkOutliers(transactions, io);

        io.closeScanner();
    }

    private static void checkOutliers(List<Transaction> list, IOService io) {
        List<String> outliers = new ArrayList<>();
        for (Transaction t : list) {
            if (t.fee > 50.0) {
                outliers.add(t.id);
            }
        }
        io.displayMessage("High-fee outliers (> $50): " + (outliers.isEmpty() ? "none" : outliers));
    }
}
