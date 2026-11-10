public class Item{
    private Product product;
    private int quantity;

    public Item(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity(){
        return quantity;
    }
    public Product getProduct(){
        return
    }
    public double getTotal(){
        product.getPrice()* quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}