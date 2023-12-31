public class Product {
    private String name;
    private String description;
    private float price;
    private int quantity;

    public Product(String name,String description,float price,int quantity){
        this.name = name ;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public float getPrice(){return this.price;}
    public int getQuantity(){return this.quantity;}

    public void setName(String name) {this.name = name;}
    public void setDescription(String description) {this.description = description;}
    public void setPrice(float price) {this.price = price;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
}
