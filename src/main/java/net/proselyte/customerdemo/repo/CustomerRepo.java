package net.proselyte.customerdemo.repo;

import net.proselyte.customerdemo.model.Customer;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository interface for {@link net.proselyte.customerdemo.model.Customer} class
* */


public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
