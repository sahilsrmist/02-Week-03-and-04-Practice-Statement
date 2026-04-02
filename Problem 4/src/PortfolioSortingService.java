public class PortfolioSortingService {

    // --- Merge Sort: Stable (Preserves order for ties) ---
    public void mergeSort(Asset[] assets) {
        if (assets.length < 2) return;
        int mid = assets.length / 2;
        Asset[] left = new Asset[mid];
        Asset[] right = new Asset[assets.length - mid];

        System.arraycopy(assets, 0, left, 0, mid);
        System.arraycopy(assets, mid, right, 0, assets.length - mid);

        mergeSort(left);
        mergeSort(right);
        merge(assets, left, right);
    }

    private void merge(Asset[] result, Asset[] left, Asset[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            // Stability: Use <= to preserve original order for ties
            if (left[i].returnRate <= right[j].returnRate) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];
    }

    // --- Quick Sort: Return DESC + Volatility ASC ---
    public void quickSort(Asset[] assets, int low, int high) {
        if (low < high) {
            int pi = partition(assets, low, high);
            quickSort(assets, low, pi - 1);
            quickSort(assets, pi + 1, high);
        }
    }

    private int partition(Asset[] assets, int low, int high) {
        // Pivot Selection: Median-of-Three
        int mid = low + (high - low) / 2;
        int pivotIdx = selectMedian(assets, low, mid, high);
        swap(assets, pivotIdx, high);

        Asset pivot = assets[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compareAssets(assets[j], pivot)) {
                i++;
                swap(assets, i, j);
            }
        }
        swap(assets, i + 1, high);
        return i + 1;
    }

    // Return DESC + Volatility ASC comparison logic
    private boolean compareAssets(Asset a, Asset pivot) {
        if (a.returnRate > pivot.returnRate) return true;
        if (a.returnRate == pivot.returnRate) {
            return a.volatility < pivot.volatility; // Lower volatility preferred
        }
        return false;
    }

    private int selectMedian(Asset[] arr, int a, int b, int c) {
        if ((arr[a].returnRate <= arr[b].returnRate && arr[b].returnRate <= arr[c].returnRate) ||
                (arr[c].returnRate <= arr[b].returnRate && arr[b].returnRate <= arr[a].returnRate)) return b;
        if ((arr[b].returnRate <= arr[a].returnRate && arr[a].returnRate <= arr[c].returnRate) ||
                (arr[c].returnRate <= arr[a].returnRate && arr[a].returnRate <= arr[b].returnRate)) return a;
        return c;
    }

    private void swap(Asset[] arr, int i, int j) {
        Asset temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}