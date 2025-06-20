import java.util.Arrays;

public class SearchService {

    // Linear Search
    public static Product linearSearch(Product[] products, String searchName) {
        for (Product product : products) {
            if (product.getProductName().equals(searchName)) {
                return product;
            }
        }
        return null; // Product not found
    }
    
    // Binary Search
    public static Product binarySearch(Product[] products, String searchName) {

        Arrays.sort(products, (p1, p2) -> p1.getProductName().compareTo(p2.getProductName()));

        // Ensure the products array is sorted by productName before performing binary search
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].getProductName().compareTo(searchName);
            if (cmp == 0) {
                return products[mid];
            }
            if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Product not found
    }
}
