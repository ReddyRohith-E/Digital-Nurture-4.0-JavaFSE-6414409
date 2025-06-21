import java.util.Scanner;

public class Main {

    public static Product linearSearch(Product[] p, int targetId) {
        for (Product product : p) {
            if (product.getProductId() == targetId)
                return product;
        }
        return null;
    }

    public static Product binarySearch(Product[] p, int targetId) {
        int l = 0;
        int r = p.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int midId = p[m].getProductId();
            if (midId == targetId)
                return p[m];
            else if (midId < targetId)
                l = m + 1;
            else
                r = m - 1;
        }
        return null;
    }

    public static void sortProductsById(Product[] p) {
        int n = p.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (p[j].getProductId() > p[j + 1].getProductId()) {
                    Product temp = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product(10, "Laptop", "Electronics"),
                new Product(18, "Shoes", "Footwear"),
                new Product(7, "Book", "Stationery"),
                new Product(17, "Phone", "Electronics"),
                new Product(45, "T-shirt", "Fashion")
        };
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Product ID to search: ");
        String input = sc.nextLine();
        int target = Integer.parseInt(input);
        sc.close();

        // Linear Search
        Product linearResult = linearSearch(products, target);
        if (linearResult != null)
            System.out.println("Linear Search: Product found: " + linearResult);
        else
            System.out.println("Linear Search: Product with ID " + target + " not found");

        // Sort
        sortProductsById(products);
        // System.out.println("Products sorted by ID:");
        // for (Product product : products) {
        //     System.out.println(product);
        // } To verify sorting, uncomment this block
        System.out.println("Products sorted by ID successfully.");

        // Binary Search
        Product binaryResult = binarySearch(products, target);
        if (binaryResult != null)
            System.out.println("Binary Search: Product found: " + binaryResult);
        else
            System.out.println("Binary Search: Product with ID " + target + " not found");
    }
}
