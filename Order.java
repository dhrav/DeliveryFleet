package Swiggy;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: sbalaguruna
 * Date: 2/25/2018
 * Time: 10:05 AM
 */
public class Order
{
    int id;
    Location restuarantLoc;
    LocalTime orderTime;

    public Order(int id, Location location, LocalTime orderTime)
    {
        this.id = id;
        restuarantLoc = location;
        this.orderTime = orderTime;
    }

    public int getId() {
        return id;
    }

    public Location getRestuarantLoc() {
        return restuarantLoc;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }
}
