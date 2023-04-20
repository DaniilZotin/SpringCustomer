package net.proselyte.customerdemo.services;

import net.proselyte.customerdemo.dao.OrderDao;
import net.proselyte.customerdemo.model.Customer;
import net.proselyte.customerdemo.model.Order;

public interface OrderService {

    OrderDao createOrder(Order order, Long customerId);
}
