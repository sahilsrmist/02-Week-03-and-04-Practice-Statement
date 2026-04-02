import java.util.Arrays;
import java.util.Scanner;

public class TradeIOService {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Collects trade data from the user.
     * Uses nextLine() and parsing to avoid Scanner buffer issues.
     */
    public Trade[] inputTrades() {
        System.out.print("Enter number of trades: ");
        int n = 0;
        try {
            n = Integer.parseInt(scanner.nextLine()); // Use nextLine to consume the whole line
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Defaulting to 0.");
            return new Trade[0];
        }

        Trade[] trades = new Trade[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nTrade #" + (i + 1));
            System.out.print("Enter Trade ID (e.g., trade1): ");
            String id = scanner.nextLine();

            System.out.print("Enter Volume (e.g., 500): ");
            int volume = 0;
            try {
                volume = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid volume. Defaulting to 0.");
            }

            trades[i] = new Trade(id, volume);
        }
        return trades;
    }

    /**
     * Computes total volume post-sort. [cite: 70]
     */
    public long calculateTotalVolume(Trade[] trades) {
        long total = 0;
        for (Trade t : trades) {
            total += t.volume;
        }
        return total;
    }

    public void displayTrades(String label, Trade[] trades) {
        System.out.println(label + ": " + Arrays.toString(trades));
    }

    public void closeScanner() {
        scanner.close();
    }
}