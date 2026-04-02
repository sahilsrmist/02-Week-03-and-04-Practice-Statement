import java.util.Scanner;

public class RiskIOService {
    private Scanner scanner = new Scanner(System.in);

    public RiskBand[] inputBands() {
        System.out.print("Enter number of risk bands: ");
        int n = Integer.parseInt(scanner.nextLine());
        RiskBand[] bands = new RiskBand[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter threshold for band " + (i + 1) + ": ");
            bands[i] = new RiskBand(Integer.parseInt(scanner.nextLine()));
        }
        return bands;
    }

    public int getTargetThreshold() {
        System.out.print("\nEnter target risk threshold to search: ");
        return Integer.parseInt(scanner.nextLine());
    }
}