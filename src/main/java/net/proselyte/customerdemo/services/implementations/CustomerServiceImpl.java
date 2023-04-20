package net.proselyte.customerdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.proselyte.customerdemo.dao.CustomerDao;
import net.proselyte.customerdemo.model.Customer;
import net.proselyte.customerdemo.repo.CustomerRepo;
import net.proselyte.customerdemo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {



    private final CustomerRepo customerRepo;
    @Override
    public Customer getById(Long id) {
        log.info("IN CustomerServiceImpl method getByID {}", id);
        return customerRepo.findById(id).get();
    }

    @Override
    public void save(Customer customer) {
        log.info("IN CustomerServiceImpl method save {}", customer);
        customerRepo.save(customer);
    }

    @Override
    public void delete(Long id) {
        log.info("IN CustomerServiceImpl method delete {}", id);
        customerRepo.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        log.info("IN CustomerServiceImpl method getAll");
        return customerRepo.findAll();
    }
}
