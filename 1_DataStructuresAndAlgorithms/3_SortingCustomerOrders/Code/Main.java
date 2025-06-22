public class Main {
    
    // Bubble Sort
    public static void bubbleSort(Order[] ord) {
        int n = ord.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ord[j].getTotalPrice() > ord[j + 1].getTotalPrice()) {
                    Order temp = ord[j];
                    ord[j] = ord[j + 1];
                    ord[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] ord, int low, int high) {
        if (low < high) {
            int pi = partition(ord, low, high);
            quickSort(ord, low, pi - 1);
            quickSort(ord, pi + 1, high);
        }
    }

    // Partition for Quick Sort
    public static int partition(Order[] ord, int low, int high) {
        double pivot = ord[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (ord[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = ord[i];
                ord[i] = ord[j];
                ord[j] = temp;
            }
        }
        Order temp = ord[i + 1];
        ord[i + 1] = ord[high];
        ord[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] ords = {
                new Order(1, "Rahul", 2500.00),
                new Order(2, "YBJ", 1500.00),
                new Order(3, "Sai", 3000.00),
                new Order(4, "Gill", 2000.00)
        };

        System.out.println("Original Orders:");
        for (Order o : ords) {
            System.out.println(o);
        }

        Order[] bs = ords.clone();
        bubbleSort(bs);
        System.out.println("\nOrders after Bubble Sort:");
        for (Order o : bs) {
            System.out.println(o);
        }

        Order[] qs = ords.clone();
        quickSort(qs, 0, qs.length - 1);
        System.out.println("\nOrders after Quick Sort:");
        for (Order o : qs) {
            System.out.println(o);
        }
    }

}
