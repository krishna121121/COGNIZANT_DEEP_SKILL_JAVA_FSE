package EcommerceSearch;

import java.util.Arrays;

public class Search {
    public static Product linearSearch(Product[] products, int id){
        for(Product product : products){
            if(product.getProductId() == id){
                return product;
            }
        }
        return null;
    }
    public static Product binarySearch(Product[] products,int ind){
        int l = 0;
        int r  = products.length -1;
        while(l <= r){
            int mid = (l+r)/2;
            if(products[mid].getProductId() == ind){
                return products[mid];
            }else if(products[mid].getProductId() > ind){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mouse", "Electronics"),
                new Product(103, "Keyboard", "Electronics"),
                new Product(104, "Monitor", "Electronics"),
                new Product(105, "Printer", "Electronics")
        };

        System.out.println("Linear Search:");
        System.out.println(linearSearch(products, 104));

        System.out.println();

        Arrays.sort(products,
                (a, b) -> Integer.compare(a.getProductId(), b.getProductId()));

        System.out.println("Binary Search:");
        System.out.println(binarySearch(products, 104));
    }

}
