package shahul;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductInventory 
{
    private Map<Integer, Product> inventoryMap;
    private ArrayList<Product> inventoryList;

    public ProductInventory() 
    {
        inventoryMap = new HashMap<>();
        inventoryList = new ArrayList<>();
    }

    public void addProduct(Product product) 
    {
        inventoryMap.put(product.getProductId(), product);
        inventoryList.add(product);
    }

    public void removeProduct(int productId) 
    {
        Product product = inventoryMap.remove(productId);
        if (product != null) 
        {
            inventoryList.remove(product);
        }
        else
        {
            System.out.println("Product not found in inventory.");
        }
    }

    public void updateQuantity(int productId, int newQuantity) 
    {
        Product product = inventoryMap.get(productId);
        if (product != null) 
        {
            product.setQuantity(newQuantity);
        }
        else
        {
            System.out.println("Product not found in inventory.");
        }
    }

    public void displayProductDetails(int productId) {
        Product product = inventoryMap.get(productId);
        if (product != null) 
        {
            System.out.println(product);
        }
        else
        {
            System.out.println("Product not found in inventory.");
        }
    }

    public void displayAllProducts() 
    {
        for (Product product : inventoryList) 
        {
            System.out.println(product);
        }
    }

    public static void main(String[] args) 
    {
        ProductInventory inventory = new ProductInventory();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do 
        {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new product");
            System.out.println("2. Remove a product");
            System.out.println("3. Update the quantity of a product");
            System.out.println("4. Display details of a product");
            System.out.println("5. Display details of all products");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    inventory.addProduct(new Product(productId, productName, price, quantity));
                    break;
                case 2:
                    System.out.print("Enter product ID to remove: ");
                    int idToRemove = scanner.nextInt();
                    inventory.removeProduct(idToRemove);
                    break;
                case 3:
                    System.out.print("Enter product ID to update quantity: ");
                    int idToUpdate = scanner.nextInt();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    inventory.updateQuantity(idToUpdate, newQuantity);
                    break;
                case 4:
                    System.out.print("Enter product ID to display details: ");
                    int idToDisplay = scanner.nextInt();
                    inventory.displayProductDetails(idToDisplay);
                    break;
                case 5:
                    inventory.displayAllProducts();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
        while (choice != 6);
        scanner.close();
    }
}