import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;  

/**
 * a.) Class name: Customer
 * b.) Date of code: 8-17-23
 * c.) Dylan Tran
 * d.) This class prints orders to a log for the customer's orders.
 * e.) The ArrayList data structure is used to hold a list of orders by a customer.
 * f.) A scan algorithm is used to go through all of the customer's orders in order to print them. A loop is used here because it is efficient for traversing a body of
 * orders in a consistent manner.
 */

public class Customer
{

    /**
     * This method adds a customer's orders to a file.
     * @param customer a list of orders under a customer's name
     * @param file the file that the order list for a customer will be printed to
     */

    public void addToCustomer(List<Order> customer, String file)
    {
        try(PrintWriter print = new PrintWriter(file))
        {
            for(Order order : customer)
            {
                print.println(order.getNum() + "," + order.getItems());
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method loads the information about a customer's orders to a file.
     * @param file a file that the information about a customer's orders is stored in
     * @return customer the orders for a certain customer
     */

    public static List<Order> loadCustomer(String file)
    {
        List<Order> customer = new ArrayList<>();

        try(Scanner scan = new Scanner(new File(file)))
        {
            while(scan.hasNextLine())
            {
                String order = scan.nextLine();
                String[] info = order.split(",");
                if(info.length > 1)
                {
                    int number = Integer.parseInt(info[0]);
                    String items = info[1];
                    order.add(new Order(number, items));
                }
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        return customer;
    }
}