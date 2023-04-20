package net.proselyte.customerdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.proselyte.customerdemo.dao.OrderDao;
import net.proselyte.customerdemo.model.Customer;
import net.proselyte.customerdemo.model.Order;
import net.proselyte.customerdemo.repo.CustomerRepo;
import net.proselyte.customerdemo.repo.OrderRepo;
import net.proselyte.customerdemo.services.OrderService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final CustomerRepo customerRepo;


    @Override
    public OrderDao createOrder(Order order, Long id) {
        Customer customer = customerRepo.findById(id).get();
        order.setCustomer(customer);
        return OrderDao.toModel(orderRepo.save(order)) ;
    }
}
