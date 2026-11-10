import model.Product;
import model.Customer;
import model.CartItem;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class HitShop{
    private static final List<CartItem> cart = new ArrayList<>();
    private static final Customer currentCustomer = new Customer("C01","Linh Nguyen","0900000001");

    public static void main(String[] args) {
        Product product1 = new Product("P01", "Ao thun", 150000, 20);
        Product product2 = new Product("P02", "Binh nuoc", 50000, 10);
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1.Them mat hang: ");
            System.out.println("2.Xoa mat hang: ");
            System.out.println("3.Xem gio hang: ");
            System.out.println("4.Xem tong tien: ");
            System.out.println("0.Thoat: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println(product1.getId() + "|" + product1.getName());
                    System.out.println(product2.getId() + "|" + product2.getName());
                    System.out.println("Nhap ma san pham");
                    String id = scanner.nextLine();

                    Product product = null;
                    if (id.equals("P01")) {
                        product = product1;
                    } else if (id.equals("P02")) {
                        product = product2;
                    }
                    if (product == null) {
                        System.out.println("Khong tim thay san pham nao!");
                        break;
                    }

                    System.out.println("Nhap so luong: ");
                    int quantity = scanner.nextInt();
                    if (quantity <= 0) {
                        System.out.println("So luong phai lon hon 0!");
                        break;
                    }
                    addItem(product, quantity);
                    System.out.println("Them mat hang thanh cong!");
                    break;

                case 2:
                    if (cart.isEmpty()) {
                        System.out.println("Gio hang dang trong!");
                        break;
                    }

                    printItems();
                    System.out.println("Nhap so thu tu can xoa: ");
                    int displayNumber = scanner.nextInt();
                    int index = displayNumber - 1;
                    if (index < 0 || index >= cart.size()) {
                        System.out.println("Khong tim thay mat hang!");
                    } else {
                        removeItem(index);
                        System.out.println("Xoa mat hang thanh cong!");
                    }
                    break;
                case 3:
                    printItems();
                    break;
                case 4:
                    System.out.println("Tong tien: " + calculateTotal());
                    break;
                case 0:
                    System.out.println("Da thoat!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!!");

            }
        } while (choice != 0);
        scanner.close();
    }

        static void addItem(Product product, int quantity){
            CartItem item = new CartItem(product, quantity);
            cart.add(item);
        }
        static void removeItem(int index){
            cart.remove(index);
        }
        static void printItems() {
            System.out.println("Khach hang: " + currentCustomer);
            if (cart.isEmpty()) {
                System.out.println("Gio hang dang trong!");
                return;
            }
            for (int i = 0; i < cart.size(); i++) {
                CartItem item = cart.get(i);
                Product product = item.getProduct();
                System.out.println((i + 1) + "." + product.getId() + "|" + product.getName() + "|" + product.getPrice() + "| SL: " + item.getQuantity() + "| Thanh tien: " + item.getTotal());
            }
        }
        static double calculateTotal(){
        double total = 0;
        for(CartItem item : cart){
            total += item.getTotal();
        }
        return total;
    }
}