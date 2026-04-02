import java.util.Scanner;

public class RiskIOService {
    private Scanner scanner = new Scanner(System.in);

    public Client[] getClientData() {
        System.out.print("Enter number of clients: ");
        int n = scanner.nextInt();
        Client[] clients = new Client[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Client " + (i + 1) + " ---");
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Risk Score (0-100): ");
            int score = scanner.nextInt();
            System.out.print("Account Balance: ");
            double balance = scanner.nextDouble();
            clients[i] = new Client(name, score, balance);
        }
        return clients;
    }

    public void displayTopRisks(Client[] sortedClients, int topCount) {
        System.out.println("\n--- Top " + topCount + " Highest Risk Clients ---");
        int limit = Math.min(topCount, sortedClients.length);
        for (int i = 0; i < limit; i++) {
            System.out.println((i + 1) + ". " + sortedClients[i]);
        }
    }
}