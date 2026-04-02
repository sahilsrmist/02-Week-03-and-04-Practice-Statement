import java.util.Scanner;

public class LogIOService {
    private Scanner scanner = new Scanner(System.in);

    public TransactionLog[] inputLogs() {
        System.out.print("Enter number of logs to simulate: ");
        int n = Integer.parseInt(scanner.nextLine());
        TransactionLog[] logs = new TransactionLog[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Account ID for log " + (i + 1) + ": ");
            String id = scanner.nextLine();
            logs[i] = new TransactionLog(id, "Txn Details " + i);
        }
        return logs;
    }

    public String getTargetId() {
        System.out.print("\nEnter Account ID to search: ");
        return scanner.nextLine();
    }
}