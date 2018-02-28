Assumptions:
1. The inputs - Set of Orders and delivery executives are initialized and processing is done for the same.
2. Need to extend the support for dynamic update of change in order/executives.
3. Also, the customer details of the order are not in this scope.
4. Only the matching of delivery executive and order is done in this module.

Code Details:
1. Order - details of order.
2. Delivery Executive - details of delivery executive
3. Order Controller - 
i) Maintains the list of orders and list of executives present.
ii) Adds newly placed order
iii) Process the order - Assigns it to the delivery executive
iV) Delivery executive maintains the queue of orders to be delivered and delivers the orders present in his queue.


Extensions:
1.How to scale this approach to whole city ?
	a.This can be extended by seggregating the delivery executives based on area instead of just relying on the current location and delivery time.
	b.After assigning the executive, if any other executive gets free and nearby, then it can be reassigned to that person.

2.How to fetch DEs to be mapped with order ?
	a.The mapping of DEs for an order can be found by looking into the queue of orders the delivery executives might be delivering.

3.Some areas might want to increase efficiency i.e maximum utilization of delivery boys.
On the other hand, some might want to increase quality i.e prioritize order delay, equal
distribution of orders among delivery boys. How should the code be designed so that
these factors can be easily incorporated in future?

As mapping of order with delivery executive is a separate module, we can incorporate the above things/constraints by the following:
a. prioritize the order delay - As we maintain the order queue, the order placed first can be processed first. Also the orders present in the delivery executive's queue to be processed, can be looked into periodically to reassign/speeden the order placed before the tolerant threshold.
b. Equal distribution among the distribution boys - We can maintain the no. of orders delivered in delivery executive class. And we can sort the delivery executives based on least number of orders delivered and highest waiting time. We can sort based on these criteria and add these to comparator chain.

4. To prioritize premium customer:
a. We might need to maintain the customers who placed the order.
b. The orders need to be sorted based on the order placed time and type of customer who placed the order (Premium/Non-premium) and then processed.



 


