import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create sample products
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shampoo", "Personal Care"),
            new Product(103, "Book", "Stationery"),
            new Product(104, "Tablet", "Electronics"),
            new Product(105, "Pen", "Stationery")
        };

        // Step 2: Search for a product name
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product name to search: ");
        String searchName = sc.nextLine();
        sc.close();

        // Step 3: Linear Search
        Product foundLinear = SearchService.linearSearch(products, searchName);
        System.out.println("Linear Search Result: " + (foundLinear != null ? foundLinear : "Not Found"));

        // Step 4: Binary Search
        Product foundBinary = SearchService.binarySearch(products, searchName);
        System.out.println("Binary Search Result: " + (foundBinary != null ? foundBinary : "Not Found"));
    }
}