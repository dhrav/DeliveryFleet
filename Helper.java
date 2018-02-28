package Swiggy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sbalaguruna
 * Date: 2/25/2018
 * Time: 11:09 AM
 */
public class Helper
{

    public static double getDistance(Location executiveLoc, Location restuarantLoc)
    {
       double latitudeDistance = toRadian(executiveLoc.latitude - restuarantLoc.latitude);
       double longitudeDistance = toRadian(executiveLoc.longitude - restuarantLoc.longitude);

       double earthRadius = 6371;

       double result = (Math.sin(latitudeDistance / 2) * Math.sin(latitudeDistance / 2))
                       + (Math.cos(toRadian(executiveLoc.latitude)) * Math.cos(toRadian(restuarantLoc.latitude)))
                      * (Math.sin(longitudeDistance / 2)*Math.sin(longitudeDistance / 2));

          double distance = 2 * Math.asin(Math.sqrt(result));

        return earthRadius * distance;
    }

    private static double toRadian(double degree)
    {
      return degree * Math.PI/180;
    }

    public static DeliveryExecutive getMatchingExecutive(Order curOrder, List<DeliveryExecutive> deliveryExecutiveList)
    {
        Collections.sort(deliveryExecutiveList, getComparatorByWaitingTime());
        DeliveryExecutive executiveNearBy = null;
        double minDistance = Double.MAX_VALUE;
        for(DeliveryExecutive executive : deliveryExecutiveList)
        {
           double nearestKm = getDistance(executive.getExecutiveLoc(), curOrder.getRestuarantLoc());
           if(nearestKm < minDistance)
           {
               executiveNearBy = executive;
               minDistance = nearestKm;
           }
        }
        return executiveNearBy;
    }

    public static Comparator<DeliveryExecutive> getComparatorByWaitingTime()
    {
        return Comparator.comparing(DeliveryExecutive::getLastDeliveredTime);
    }
}
