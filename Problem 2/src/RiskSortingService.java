public class RiskSortingService {

    /**
     * Bubble Sort: Sorts by riskScore ASC[cite: 42].
     * Includes swap visualization as requested[cite: 42].
     */
    public void bubbleSortVisualized(Client[] clients) {
        int n = clients.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (clients[j].riskScore > clients[j + 1].riskScore) {
                    // Visualize Swap
                    System.out.println("SWAP: " + clients[j].name + "(" + clients[j].riskScore +
                            ") with " + clients[j+1].name + "(" + clients[j+1].riskScore + ")");

                    Client temp = clients[j];
                    clients[j] = clients[j + 1];
                    clients[j + 1] = temp;
                    swaps++;
                }
            }
        }
        System.out.println("Total Swaps: " + swaps);
    }

    /**
     * Insertion Sort: Sorts by riskScore DESC + accountBalance[cite: 43].
     * Best for nearly-sorted data (Adaptive).
     */
    public void insertionSortPriority(Client[] clients) {
        int n = clients.length;
        for (int i = 1; i < n; i++) {
            Client key = clients[i];
            int j = i - 1;

            // Compare for Descending Risk Score
            // Secondary Sort: Account Balance if Risk Scores are equal
            while (j >= 0 && (clients[j].riskScore < key.riskScore ||
                    (clients[j].riskScore == key.riskScore && clients[j].accountBalance < key.accountBalance))) {
                clients[j + 1] = clients[j];
                j = j - 1;
            }
            clients[j + 1] = key;
        }
    }

}