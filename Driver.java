package Swiggy;

import java.sql.Timestamp;
import java.time.LocalTime;

/**
 * Created by IntelliJ IDEA.
 * User: sbalaguruna
 * Date: 2/25/2018
 * Time: 3:07 PM
 */
public class Driver
{
    public static void main(String args[])
    {
        OrderController controller = new OrderController();

        //Add order to be delivered
        Order order = new Order(123, new Location(43.87, -1.7297222222222221), LocalTime.of(10, 54, 30)) ;
        controller.placeOrder(order);

        //Add list of delivery executives present
        DeliveryExecutive executive1 = new DeliveryExecutive(567, new Location(43.816, -1.6997222222222223), LocalTime.of(8, 20, 34));
        controller.addExecutive(executive1);
        DeliveryExecutive executive2 = new DeliveryExecutive(554, new Location(53.816, -1.6997222222222223), LocalTime.of(8, 20, 34));
        controller.addExecutive(executive2);

        //process - assign delivery executive and deliver the order
        controller.processOrder();
        controller.deliverOrder();
    }
}
