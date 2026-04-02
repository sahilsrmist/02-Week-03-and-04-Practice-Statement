public class PortfolioApp {
    public static void main(String[] args) {
        PortfolioIOService io = new PortfolioIOService();
        PortfolioSortingService sorter = new PortfolioSortingService();

        // 1. Data Collection
        Asset[] portfolio = io.inputAssets();

        // 2. Stable Merge Sort (Return ASC)
        Asset[] stableSorted = portfolio.clone();
        sorter.mergeSort(stableSorted);
        io.displayPortfolio("Merge Sort (Stable Return ASC)", stableSorted);

        // 3. Optimized Quick Sort (Return DESC + Volatility ASC)
        Asset[] optimizedSorted = portfolio.clone();
        sorter.quickSort(optimizedSorted, 0, optimizedSorted.length - 1);
        io.displayPortfolio("Quick Sort (Return DESC + Volatility ASC)", optimizedSorted);
    }
}