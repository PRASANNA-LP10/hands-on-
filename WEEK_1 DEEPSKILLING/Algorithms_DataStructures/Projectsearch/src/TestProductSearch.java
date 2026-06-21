import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class TestProductSearch {
    public static Product linearsearch(int id){
        for(Product p: Product.productarray){
            if (p.getProductID()==id)return p;
        }
        return null;
    }


    public static Product binarysearch(int id){
        int left=0;
        int right=Product.productarray.size()-1;
        Collections.sort(Product.productarray);
        while(left<=right){
            int mid=(left+right)/2;
            if(Product.productarray.get(mid).getProductID()==id)return Product.productarray.get(mid);
            else if (Product.productarray.get(mid).getProductID()<id)left=mid+1;
            else right=mid-1;
            }
        return null;
    }

}
