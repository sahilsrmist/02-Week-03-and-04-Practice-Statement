public class ForensicApp {
    public static void main(String[] args) {
        LogIOService io = new LogIOService();
        SearchService searcher = new SearchService();

        // 1. Collect Logs
        TransactionLog[] logs = io.inputLogs();
        String target = io.getTargetId();

        // 2. Perform Linear Search
        searcher.linearSearch(logs, target);

        // 3. Perform Binary Search [cite: 121]
        // Note: Binary search sorts the array internally
        searcher.binarySearchAndCount(logs, target);
    }
}