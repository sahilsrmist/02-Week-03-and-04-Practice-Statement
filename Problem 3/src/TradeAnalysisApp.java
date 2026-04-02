public class TradeAnalysisApp {
    public static void main(String[] args) {
        TradeIOService io = new TradeIOService();
        TradeSortingService sorter = new TradeSortingService();

        // 1. Collect Input
        io.displayTrades("System Status", new Trade[0]); // Initial prompt
        Trade[] trades = io.inputTrades();

        if (trades.length > 0) {
            // 2. Merge Sort (Ascending - Stable) [cite: 67, 86]
            Trade[] mergeCopy = trades.clone();
            sorter.mergeSort(mergeCopy);
            io.displayTrades("MergeSort (Ascending)", mergeCopy);

            // 3. Quick Sort (Descending - In-place) [cite: 68, 87]
            Trade[] quickCopy = trades.clone();
            sorter.quickSort(quickCopy, 0, quickCopy.length - 1);
            io.displayTrades("QuickSort (Descending)", quickCopy);

            // 4. Compute Total Volume [cite: 70]
            long total = io.calculateTotalVolume(trades);
            System.out.println("Merged morning+afternoon total: " + total);
        }

        io.closeScanner();
    }
}