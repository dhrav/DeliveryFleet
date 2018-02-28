package Swiggy;

import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * User: sbalaguruna
 * Date: 2/25/2018
 * Time: 11:16 AM
 */
public class DeliveryExecutive
{
    int id;
    Location executiveLoc;
    LocalTime lastDeliveredTime;

    Queue<Order> orderList = new LinkedList<>();

    public DeliveryExecutive(int id, Location executiveLoc, LocalTime lastDeliveredTime)
    {
        this.id = id;
        this.executiveLoc = executiveLoc;
        this.lastDeliveredTime = lastDeliveredTime;
    }

    public int getId() {
        return id;
    }

    public Location getExecutiveLoc() {
        return executiveLoc;
    }

    public LocalTime getLastDeliveredTime() {
        return lastDeliveredTime;
    }

    public Queue<Order> getOrderList() {
        return orderList;
    }

    public void addToOrder(Order order)
    {
        orderList.add(order);
    }

    public void serveOrders()
    {
        while(!orderList.isEmpty())
        {
            Order curOrder = orderList.remove();
            System.out.println("Executive : " + getId());
            System.out.println("Going to deliver the order id " + curOrder.getId());
            System.out.println("Distance travelled to deliver the order " + Helper.getDistance(executiveLoc, curOrder.getRestuarantLoc()));
        }
    }
}
