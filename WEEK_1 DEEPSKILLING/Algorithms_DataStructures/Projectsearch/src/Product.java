import java.util.ArrayList;

public class Product implements Comparable<Product>{

    private int productID;
    private String productName;
    private String category;


    static ArrayList<Product> productarray=new ArrayList<>();


    public Product(int productID, String productName, String category) {
        this.productID = productID;
        this.productName = productName;
        this.category = category;
        productarray.add(this);


    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return this.productID-o.productID;
    }


}
