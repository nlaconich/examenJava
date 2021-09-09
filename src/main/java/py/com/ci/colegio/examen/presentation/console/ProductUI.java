package py.com.ci.colegio.examen.presentation.console;

import java.util.List;
import java.util.Scanner;
import py.com.ci.colegio.examen.product.controller.ProductController;
import py.com.ci.colegio.examen.product.entities.Product;

/**
 *
 * @author nick
 */
public class ProductUI {

    Scanner sc = new Scanner(System.in);
    ProductController productController = new ProductController();
    Product product= new Product();
    public static void main(String[] args) {
        ProductUI ui = new ProductUI();
        ui.mainMenu();
    }

    public void mainMenu() {
        System.out.println("Welcome to ProductUI");
        System.out.println("----------------------------------------");
        System.out.println("Choose an option ");
        System.out.println("1 : List all Products");
        System.out.println("2 : Add a Product");
        System.out.println("3 : Delete a Product");
        System.out.println("4 : Update a Product");
        System.out.println("5 : Exit");
        System.out.println("Option: ");
        String option = sc.next();
        try {
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption) {
                case 1:
                    listAllProducts();
                    break;
                case 2:
                    registerProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    return;
            }
            mainMenu();
        } catch (Exception ex) {

            mainMenu();
        }
    }

    public void listAllProducts() {
        List<Product> listProducts=productController.getAll();
        if (!listProducts.isEmpty()) {
            for (Product product : listProducts) {
                System.out.println(product);
            }
        } else {
            System.out.println("No product found");
        }
    }

    private void registerProduct() {

        sc.nextLine();
        System.out.println("Insert Name");
        String name = sc.nextLine();
        System.out.println("Insert Description");
        String description = sc.nextLine();

        product.setProductName(name);
        product.setProcuctDescription(description);

        productController.add(product);
    }

    private void deleteProduct() {
        this.listAllProducts();
        
        System.out.println("Insert Id ");
        int id = sc.nextInt();
        product.setProductId(id);
        
        boolean ban = productController.delete(product);
        if (ban == true) {
            System.out.println("Delete Successful");
        } else {
            System.out.println("Japiro");
        }
    }

    private void updateProduct() {

        this.listAllProducts();
        System.out.println("Insert Id ");
        int id = sc.nextInt();

        sc.nextLine();
        System.out.println("Insert new Name ");
        String name = sc.nextLine();
        System.out.println("Insert new Description");
        String description = sc.nextLine();

        product.setProductId(id);
        product.setProductName(name);
        product.setProcuctDescription(description);
        
        boolean ban = productController.update(product);
        if (ban == true) {
            System.out.println("Update Successful");
        } else {
            System.out.println("Japiro");
        }
    }
}
