public class ComplianceApp {
    public static void main(String[] args) {
        RiskIOService io = new RiskIOService();
        RiskLookupService service = new RiskLookupService();

        // 1. Setup Risk Bands
        RiskBand[] bands = io.inputBands();
        int target = io.getTargetThreshold();

        // 2. Perform Unsorted Linear Search [cite: 146]
        service.linearSearch(bands, target);

        // 3. Perform Sorted Binary Search for Bounds [cite: 147, 148]
        service.findFloorCeiling(bands, target);
    }
}