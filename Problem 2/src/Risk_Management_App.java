public class Risk_Management_App {
    public static void main(String[] args) {
        RiskIOService io = new RiskIOService();
        RiskSortingService sorter = new RiskSortingService();

        // 1. Input Data
        Client[] clients = io.getClientData();

        // 2. Bubble Sort (Ascending Demo)
        System.out.println("\n--- Bubble Sort Demo (Ascending) ---");
        Client[] demoArr = clients.clone();
        sorter.bubbleSortVisualized(demoArr);

        // 3. Insertion Sort (Descending Priority)
        System.out.println("\n--- Performing Priority Ranking ---");
        sorter.insertionSortPriority(clients);

        // 4. Output top 10 highest risk clients [cite: 44]
        io.displayTopRisks(clients, 10);
    }
}