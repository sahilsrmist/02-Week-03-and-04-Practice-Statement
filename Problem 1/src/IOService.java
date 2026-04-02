import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOService {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Collects transaction details from the user[cite: 28, 29, 30].
     */
    public List<Transaction> collectTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        System.out.print("Enter number of transactions to process: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < count; i++) {
            System.out.println("\nTransaction #" + (i + 1));
            System.out.print("Enter ID (e.g., id1): ");
            String id = scanner.nextLine();
            System.out.print("Enter Fee (e.g., 10.5): ");
            double fee = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Timestamp (e.g., 10:00): ");
            String ts = scanner.nextLine();

            transactions.add(new Transaction(id, fee, ts));
        }
        return transactions;
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void closeScanner() {
        scanner.close();
    }
}