import java.util.Scanner;
import java.util.ArrayList;
class HitShop {
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Double> prices = new ArrayList<>();
    static ArrayList<Integer> quantities = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        names.add("Ao thun");
//        names.add("Binh nuoc");
//
//        prices.add(150000.0);
//        prices.add(50000.0);
//
//        quantities.add(2);
//        quantities.add(1);
        addItems("Ao thun", 150000.0, 2);
        addItems("Binh nuoc", 50000.0, 1);

        int choice;
        do {
            printMenu();
            System.out.println("Nhap lua chon: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Them mat hang: ");
                    System.out.println("Ten hang: ");
                    String name = scanner.nextLine();
                    System.out.println("Don gia: ");
                    double price = scanner.nextDouble();
                    System.out.println("So luong: ");
                    int quantity = scanner.nextInt();
                    addItems(name, price, quantity);
                    printItems();
                    break;
                case 2:
                    System.out.println("Xoa mat hang: ");
                    System.out.println("Nhap STT mat hang can xoa: ");
                    int index = scanner.nextInt();
                    removeItems(index);
                    System.out.println("Danh sach con lai: ");
                    printItems();
                    break;
                case 3:
                    printItems();
                    break;
                case 4:
                    System.out.println("Tong tien hang: " + calculateTotal());
                    System.out.println("Tong thanh toan: " + finalTotal());
                    break;
                case 5:
                    System.out.println("Nhap ten hang can tim: ");
                    String keyword = scanner.nextLine();
                    searchItems(keyword);
                    break;
                case 0:
                    System.out.println("Thoat");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }while (choice != 0) ;
    }

    static void addItems(String name, double price, int quantity){
        names.add(name);
        prices.add(price);
        quantities.add(quantity);
    }
    static void removeItems(int index){
        if(index<1|| index> names.size()){
            System.out.println("Khong tim thay mat hang");
            return;
        }
        names.remove(index-1);
        prices.remove(index-1);
        quantities.remove(index-1);
        System.out.println("Xoa mat hang thanh cong!");
    }
    static void printItems(){
        if(names.isEmpty()){
            System.out.println("Danh sach trong!");
            return;
        }
        System.out.println("=====DANH SACH MAT HANG=====");
        for(int i=0; i<names.size(); i++){
            System.out.println("STT" + (i+1) + "|" + names.get(i) + "|" + prices.get(i) + "|" + quantities.get(i));
        }
    }
    static double calculateTotal(){
        double total = 0;
        for(int i=0; i<prices.size(); i++){
            total += prices.get(i) * quantities.get(i);
        }
        return total;
    }
    static void printMenu(){
        System.out.println("======HITSHOP=====");
        System.out.println("1. Them mat hang");
        System.out.println("2. Xoa mat hang");
        System.out.println("3. Xem danh sach");
        System.out.println("4. Tinh tong tien");
        System.out.println("5. Tim kiem mat hang");
        System.out.println("0. Thoat");
    }
    static void searchItems(String keyword){
        boolean found = false;
        for(int i=0; i<names.size(); i++){
            if(names.get(i).equalsIgnoreCase(keyword)){
                found = true;
                System.out.println("STT: " + (i+1));
                System.out.println("Ten hang: " + names.get(i));
                System.out.println("Don gia: " + prices.get(i));
                System.out.println("So luong: " + quantities.get(i));
                System.out.println("Thanh tien: " + (prices.get(i) * quantities.get(i)));
            }
        }
        if(!found){
            System.out.println("Khong tim thay mat hang!");
        }
    }
    static double finalTotal(){
        double total1 = calculateTotal();
        double VAT = total1*0.1;
        double shipping = names.isEmpty() ? 0 : 20000;
        double finalTotal = total1 + VAT + shipping;

        System.out.println("Tam tinh: " + total1);
        System.out.println("VAT 10%: " + VAT);
        System.out.println("Phi van chuyen: " + shipping);
        return finalTotal;
    }

}