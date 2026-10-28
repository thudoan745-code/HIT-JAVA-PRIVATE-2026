import java.util.Scanner;
public class HitShop{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên mặt hàng: ");
        String productName = scanner.nextLine();
        System.out.println("Nhập đơn giá: ");
        double price = scanner.nextDouble();
        System.out.println("Nhập số lượng: ");
        int quantity = scanner.nextInt();

        double total = price*quantity;

        final double VAT_RATE = 0.10;
        final double SHIPPING_FEE = 2000;
        double totalPayment = total + total*VAT_RATE + SHIPPING_FEE;

        System.out.println("=====THONG TIN HOA DON CUA MAT HANG=====");
        System.out.println("Tên mặt hàng là: " + productName);
        System.out.println("Đơn giá là: " + price);
        System.out.println("Số lượng là: " + quantity);
        System.out.println("Thành tiền là: " + total);
        System.out.println("Tổng thanh toán là: " + totalPayment);

        }
    }
}