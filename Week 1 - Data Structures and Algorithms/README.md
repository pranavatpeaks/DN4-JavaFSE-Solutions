<<<<<<< HEAD

# 📘 Cognizant Digital Nurture Program 4.0 – Java FSE

## Week 1 – Data Structures and Algorithms

## 🧩 Exercise 2: E-commerce Platform Search Function

### 📜 Scenario
You are working on the search functionality of an e-commerce platform. The search needs to be optimized for fast performance.

---

### 🛠 Steps
- **Understand Asymptotic Notation:**
  - Explain Big O notation and how it helps in analyzing algorithms.
  - Describe the best, average, and worst-case scenarios for search operations.
- **Setup:**
  - Create a class Product with attributes for searching, such as productId, productName, and category.
- **Implementation:**
  - Implement linear search and binary search algorithms.
  - Store products in an array for linear search and a sorted array for binary search.
- **Analysis:**
  - Compare the time complexity of linear and binary search algorithms.
  - Discuss which algorithm is more suitable for your platform and why.

---

### 📐 Understanding Asymptotic Notation

#### Q1. Explain Big O notation and how it helps in analyzing algorithms.
Big O notation is used to describe how the runtime or space requirements of an algorithm grow as the input size increases. It helps us compare algorithms based on their scalability and efficiency.

#### Q2. Describe the best, average, and worst-case scenarios for search operations.

Some common running times are:

| Time Complexity | Description        |
|------------------|--------------------|
| `O(n^2)`         | Quadratic time     |
| `O(n log n)`     | Linearithmic time  |
| `O(n)`           | Linear time        |
| `O(log n)`       | Logarithmic time   |
| `O(1)`           | Constant time      |

- Linear search is `O(n)` in the worst case.
- Binary search is `O(log n)` in the worst case.

---

### ⚙️ Setup
This exercise simulates a basic inventory system using:
- Java classes for data modeling (`Product`)
- Search operations using `SearchService`

---

## 💻 Source Code

### 📄 Product.java
```java
public class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return "Product{" +
               "productId=" + productId +
               ", productName='" + productName + ''' +
               ", category='" + category + ''' +
               '}';
    }
}
```

---

### 📄 SearchService.java
```java
import java.util.Arrays;

public class SearchService {

    public static Product linearSearch(Product[] products, String searchName) {
        for (Product product : products) {
            if (product.getProductName().equals(searchName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String searchName) {
        Arrays.sort(products, (p1, p2) -> p1.getProductName().compareTo(p2.getProductName()));
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].getProductName().compareTo(searchName);
            if (cmp == 0) return products[mid];
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }
}
```

---

### 📄 Main.java
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shampoo", "Personal Care"),
            new Product(103, "Book", "Stationery"),
            new Product(104, "Tablet", "Electronics"),
            new Product(105, "Pen", "Stationery")
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product name to search: ");
        String searchName = sc.nextLine();
        sc.close();

        Product foundLinear = SearchService.linearSearch(products, searchName);
        System.out.println("Linear Search Result: " + (foundLinear != null ? foundLinear : "Not Found"));

        Product foundBinary = SearchService.binarySearch(products, searchName);
        System.out.println("Binary Search Result: " + (foundBinary != null ? foundBinary : "Not Found"));
    }
}
```

---

### 🖥 Sample Output
```
Enter product name to search: Laptop
Linear Search Result: Product{productId=101, productName='Laptop', category='Electronics'}
Binary Search Result: Product{productId=101, productName='Laptop', category='Electronics'}
```

---

### 🎥 Terminal Demo (.cast)
[![asciicast](https://asciinema.org/a/08axr9EqYyrzxvYrCGxMnqFIp.svg)](https://asciinema.org/a/08axr9EqYyrzxvYrCGxMnqFIp)

---

## 📊 Analysis

### Q1. Compare the time complexity of linear and binary search algorithms.

| Operation        | Description                  | Time Complexity |
|------------------|------------------------------|------------------|
| Linear Search    | Sequential search by name    | `O(n)`           |
| Binary Search    | Search after sorting by name | `O(log n)`       |

### Q2. Discuss which algorithm is more suitable for your platform and why.

**Use Linear Search When:**
- Inventory is small (e.g., <100 products)
- Data isn’t sorted
- Frequent updates make sorting costly

**Use Binary Search When:**
- Inventory is large
- Data is already sorted or sortable
- You need faster lookup time

---

## 🧩 Exercise 7: Financial Forecasting

### 📜 Scenario
You are developing a financial forecasting tool that predicts future values based on past data.

---

### 🛠 Steps
- **Understand Recursive Algorithms:**
  - Explain the concept of recursion and how it can simplify certain problems.
- **Setup:**
  - Create a method to calculate the future value using a recursive approach.
- **Implementation:**
  - Implement a recursive algorithm to predict future values based on past growth rates.
- **Analysis:**
  - Discuss the time complexity of your recursive algorithm.
  - Explain how to optimize the recursive solution to avoid excessive computation.

---

### 🔁 Understanding Recursive Algorithms

#### Q1. Explain the concept of recursion.
Recursion is a programming technique where a function calls itself with a smaller version of the original problem, continuing until it reaches a base case. It's often more elegant and simplifies code for problems that are naturally recursive.

---

### ⚙️ Setup

#### Problem
Given:
- Principal Amount
- Array of Past Growth Rates
- Number of Years

Find:
- Future value after applying compounded growth recursively.

---

### 💡 Example
If you invest 100 at 5% in year 1 → 105  
In year 2 at 10% → 105 * 1.10 = 115.5

---

### 📄 Main.java
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the initial principal amount: ");
        double principal = scanner.nextDouble();
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();
        double[] growthRates = new double[years];

        for (int i = 0; i < years; i++) {
            System.out.print("Enter the growth rate for year " + (i + 1) + ": ");
            growthRates[i] = scanner.nextDouble() / 100;
        }

        double futureValue = RecursiveForecast.calculateFutureValue(principal, growthRates, 0);
        System.out.printf("The future value after %d years is: %.2f%n", years, futureValue);
        scanner.close();
    }
}
```

---

### 📄 RecursiveForecast.java
```java
public class RecursiveForecast {
    public static double calculateFutureValue(double principal, double[] growthRates, int year) {
        if (year == growthRates.length) {
            return principal;
        }
        double updatedPrincipal = principal * (1 + growthRates[year]);
        return calculateFutureValue(updatedPrincipal, growthRates, year + 1);
    }
}
```

---

## 📊 Analysis

### Time Complexity
- `O(n)` — One recursive call per year

### Space Complexity
- `O(n)` — Call stack grows with each recursive call

---

## 🚀 Optimization

You can convert the recursive function to an **iterative** one for better performance:

```java
public class Forecast {
    public static double calculateFutureValue(double principal, double[] growthRates) {
        for (double rate : growthRates) {
            principal *= (1 + rate);
        }
        return principal;
    }
}
```

- Time: `O(n)`
- Space: `O(1)`

---

## ✅ Summary

| Metric              | Recursive Approach   | Iterative Approach    |
|---------------------|----------------------|------------------------|
| Time Complexity     | O(n)                 | O(n)                   |
| Space Complexity    | O(n) (call stack)    | O(1)                   |
| Readability         | High (very clean)    | Moderate               |
| StackOverflow Risk  | Yes (if n is huge)   | No                     |
=======
# 📘 Cognizant Digital Nurture Program 4.0 – Java FSE

## Week 1 – Data Structures and Algorithms

## 🧩 Exercise 2: E-commerce Platform Search Function

### 📜 Scenario
You are working on the search functionality of an e-commerce platform. The search needs to be optimized for fast performance.

---

### 🛠 Steps
- **Understand Asymptotic Notation:**
  - Explain Big O notation and how it helps in analyzing algorithms.
  - Describe the best, average, and worst-case scenarios for search operations.
- **Setup:**
  - Create a class Product with attributes for searching, such as productId, productName, and category.
- **Implementation:**
  - Implement linear search and binary search algorithms.
  - Store products in an array for linear search and a sorted array for binary search.
- **Analysis:**
  - Compare the time complexity of linear and binary search algorithms.
  - Discuss which algorithm is more suitable for your platform and why.

---

### 📐 Understanding Asymptotic Notation

#### Q1. Explain Big O notation and how it helps in analyzing algorithms.
Big O notation is used to describe how the runtime or space requirements of an algorithm grow as the input size increases. It helps us compare algorithms based on their scalability and efficiency.

#### Q2. Describe the best, average, and worst-case scenarios for search operations.

Some common running times are:

| Time Complexity | Description        |
|------------------|--------------------|
| `O(n^2)`         | Quadratic time     |
| `O(n log n)`     | Linearithmic time  |
| `O(n)`           | Linear time        |
| `O(log n)`       | Logarithmic time   |
| `O(1)`           | Constant time      |

- Linear search is `O(n)` in the worst case.
- Binary search is `O(log n)` in the worst case.

---

### ⚙️ Setup
This exercise simulates a basic inventory system using:
- Java classes for data modeling (`Product`)
- Search operations using `SearchService`

---

## 💻 Source Code

### 📄 Product.java
```java
public class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return "Product{" +
               "productId=" + productId +
               ", productName='" + productName + ''' +
               ", category='" + category + ''' +
               '}';
    }
}
```

---

### 📄 SearchService.java
```java
import java.util.Arrays;

public class SearchService {

    public static Product linearSearch(Product[] products, String searchName) {
        for (Product product : products) {
            if (product.getProductName().equals(searchName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String searchName) {
        Arrays.sort(products, (p1, p2) -> p1.getProductName().compareTo(p2.getProductName()));
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].getProductName().compareTo(searchName);
            if (cmp == 0) return products[mid];
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }
}
```

---

### 📄 Main.java
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shampoo", "Personal Care"),
            new Product(103, "Book", "Stationery"),
            new Product(104, "Tablet", "Electronics"),
            new Product(105, "Pen", "Stationery")
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product name to search: ");
        String searchName = sc.nextLine();
        sc.close();

        Product foundLinear = SearchService.linearSearch(products, searchName);
        System.out.println("Linear Search Result: " + (foundLinear != null ? foundLinear : "Not Found"));

        Product foundBinary = SearchService.binarySearch(products, searchName);
        System.out.println("Binary Search Result: " + (foundBinary != null ? foundBinary : "Not Found"));
    }
}
```

---

### 🖥 Sample Output
```
Enter product name to search: Laptop
Linear Search Result: Product{productId=101, productName='Laptop', category='Electronics'}
Binary Search Result: Product{productId=101, productName='Laptop', category='Electronics'}
```

---

### 🎥 Terminal Demo (.cast)
[![asciicast](https://asciinema.org/a/08axr9EqYyrzxvYrCGxMnqFIp.svg)](https://asciinema.org/a/08axr9EqYyrzxvYrCGxMnqFIp)

---

## 📊 Analysis

### Q1. Compare the time complexity of linear and binary search algorithms.

| Operation        | Description                  | Time Complexity |
|------------------|------------------------------|------------------|
| Linear Search    | Sequential search by name    | `O(n)`           |
| Binary Search    | Search after sorting by name | `O(log n)`       |

### Q2. Discuss which algorithm is more suitable for your platform and why.

**Use Linear Search When:**
- Inventory is small (e.g., <100 products)
- Data isn’t sorted
- Frequent updates make sorting costly

**Use Binary Search When:**
- Inventory is large
- Data is already sorted or sortable
- You need faster lookup time

---

## 🧩 Exercise 7: Financial Forecasting

### 📜 Scenario
You are developing a financial forecasting tool that predicts future values based on past data.

---

### 🛠 Steps
- **Understand Recursive Algorithms:**
  - Explain the concept of recursion and how it can simplify certain problems.
- **Setup:**
  - Create a method to calculate the future value using a recursive approach.
- **Implementation:**
  - Implement a recursive algorithm to predict future values based on past growth rates.
- **Analysis:**
  - Discuss the time complexity of your recursive algorithm.
  - Explain how to optimize the recursive solution to avoid excessive computation.

---

### 🔁 Understanding Recursive Algorithms

#### Q1. Explain the concept of recursion.
Recursion is a programming technique where a function calls itself with a smaller version of the original problem, continuing until it reaches a base case. It's often more elegant and simplifies code for problems that are naturally recursive.

---

### ⚙️ Setup

#### Problem
Given:
- Principal Amount
- Array of Past Growth Rates
- Number of Years

Find:
- Future value after applying compounded growth recursively.

---

### 💡 Example
If you invest 100 at 5% in year 1 → 105  
In year 2 at 10% → 105 * 1.10 = 115.5

---

### 📄 Main.java
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the initial principal amount: ");
        double principal = scanner.nextDouble();
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();
        double[] growthRates = new double[years];

        for (int i = 0; i < years; i++) {
            System.out.print("Enter the growth rate for year " + (i + 1) + ": ");
            growthRates[i] = scanner.nextDouble() / 100;
        }

        double futureValue = RecursiveForecast.calculateFutureValue(principal, growthRates, 0);
        System.out.printf("The future value after %d years is: %.2f%n", years, futureValue);
        scanner.close();
    }
}
```

---

### 📄 RecursiveForecast.java
```java
public class RecursiveForecast {
    public static double calculateFutureValue(double principal, double[] growthRates, int year) {
        if (year == growthRates.length) {
            return principal;
        }
        double updatedPrincipal = principal * (1 + growthRates[year]);
        return calculateFutureValue(updatedPrincipal, growthRates, year + 1);
    }
}
```

---

## 📊 Analysis

### Time Complexity
- `O(n)` — One recursive call per year

### Space Complexity
- `O(n)` — Call stack grows with each recursive call

---

## 🚀 Optimization

You can convert the recursive function to an **iterative** one for better performance:

```java
public class Forecast {
    public static double calculateFutureValue(double principal, double[] growthRates) {
        for (double rate : growthRates) {
            principal *= (1 + rate);
        }
        return principal;
    }
}
```

- Time: `O(n)`
- Space: `O(1)`

---

## ✅ Summary

| Metric              | Recursive Approach   | Iterative Approach    |
|---------------------|----------------------|------------------------|
| Time Complexity     | O(n)                 | O(n)                   |
| Space Complexity    | O(n) (call stack)    | O(1)                   |
| Readability         | High (very clean)    | Moderate               |
| StackOverflow Risk  | Yes (if n is huge)   | No                     |
>>>>>>> b235c42 (Updated Week 1 and completed it)
