public class Asset {
    String symbol;
    double returnRate;
    double volatility;

    public Asset(String symbol, double returnRate, double volatility) {
        this.symbol = symbol;
        this.returnRate = returnRate;
        this.volatility = volatility;
    }

    @Override
    public String toString() {
        return String.format("[%s: Return=%.2f%%, Vol=%.2f%%]", symbol, returnRate, volatility);
    }
}