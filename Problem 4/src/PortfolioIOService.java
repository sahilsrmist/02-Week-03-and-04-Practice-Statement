import java.util.Scanner;

public class PortfolioIOService {
    private Scanner scanner = new Scanner(System.in);

    public Asset[] inputAssets() {
        System.out.print("Enter number of assets (e.g., 10000): ");
        int n = Integer.parseInt(scanner.nextLine());
        Asset[] assets = new Asset[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nAsset #" + (i + 1));
            System.out.print("Symbol (e.g., AAPL): ");
            String symbol = scanner.nextLine();
            System.out.print("Return Rate % (e.g., 12.5): ");
            double rate = Double.parseDouble(scanner.nextLine());
            System.out.print("Volatility % (e.g., 5.2): ");
            double vol = Double.parseDouble(scanner.nextLine());

            assets[i] = new Asset(symbol, rate, vol);
        }
        return assets;
    }

    public void displayPortfolio(String title, Asset[] assets) {
        System.out.println("\n--- " + title + " ---");
        for (int i = 0; i < Math.min(assets.length, 10); i++) {
            System.out.println(assets[i]);
        }
        if (assets.length > 10) System.out.println("... (and " + (assets.length - 10) + " more)");
    }
}