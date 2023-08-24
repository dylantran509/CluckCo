import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;  

/**
 * a.) Class name: Order
 * b.) Date of code: 8-17-23
 * c.) Dylan Tran
 * d.) This class prints items from the cart with their information - name and price - into a file holding an order.
 * e.) The ArrayList data structure is used to hold a list of products in an order.
 * f.) A scan algorithm that parses a file line by line to separate and print items from an order is used; it was most efficient to do this as a loop
 * that scans items and then parses individual items to separate each item's name and price.
 */

public class Order
{

    /**
     * This method adds products in the cart to an order file.
     * @param order a list of products that make up an order
     * @param file the file that the products list for an order will be printed to
     */

    public void addToOrder(List<Product> order, String file)
    {
        try(PrintWriter print = new PrintWriter(file))
        {
            for(Product product : order)
            {
                print.println(product.getName() + "," + product.getPrice());
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method loads the information about an order from a file.
     * @param file a file that the information about an order is stored in
     * @return order the contents of an order
     */

    public static List<Product> loadOrder(String file)
    {
        List<Product> order = new ArrayList<>();

        try(Scanner scan = new Scanner(new File(file)))
        {
            while(scan.hasNextLine())
            {
                String product = scan.nextLine();
                String[] info = product.split(",");
                if(info.length == 2)
                {
                    String name = info[0];
                    double price = Double.parseDouble(info[1]);
                    order.add(new Product(name, price));
                }
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        return order;
    }
}