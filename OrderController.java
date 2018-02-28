package Swiggy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * User: sbalaguruna
 * Date: 2/25/2018
 * Time: 11:14 AM
 */
public class OrderController
{
    Queue<Order> orderList = new LinkedList<>();
    List<DeliveryExecutive> deliveryExecutiveList = new LinkedList<>();

    public void placeOrder(Order order)
    {
        orderList.add(order);
    }

    public void addExecutive(DeliveryExecutive executive)
    {
        deliveryExecutiveList.add(executive);
    }

    public void processOrder()
    {
        while(!orderList.isEmpty())
        {
            Order curOrder = orderList.remove();
            DeliveryExecutive selectedExecutive = Helper.getMatchingExecutive(curOrder, deliveryExecutiveList);
            selectedExecutive.addToOrder(curOrder);
        }
    }

    public void deliverOrder()
    {
        for(DeliveryExecutive executive : deliveryExecutiveList)
        {
            new Thread(() -> executive.serveOrders()).start();

        }
    }
}
