/**
 * Represents a risk threshold value used in pricing tables.
 */
public class RiskBand {
    int threshold;

    public RiskBand(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public String toString() {
        return "Threshold: " + threshold;
    }
}