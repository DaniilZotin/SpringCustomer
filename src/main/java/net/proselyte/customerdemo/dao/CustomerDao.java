package net.proselyte.customerdemo.dao;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.proselyte.customerdemo.model.Customer;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Component
public class CustomerDao {
    private String firstName;

    private String lastName;

    private String address;

    private BigDecimal budget;

    private List<OrderDao> orders;

    public CustomerDao(){

    }

    public static CustomerDao customerToCustomerDao(Customer customer){
        CustomerDao customerDao = new CustomerDao();
        customerDao.setFirstName(customer.getFirstName());
        customerDao.setLastName(customer.getLastName());
        customerDao.setAddress(customer.getAddress());
        customerDao.setBudget(customer.getBudget());
        customerDao.setOrders(customer.getOrders().stream().map(OrderDao::toModel).collect(Collectors.toList()));
        return customerDao;
    }


}
