package net.proselyte.customerdemo.repo;

import net.proselyte.customerdemo.model.Customer;
import net.proselyte.customerdemo.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepo extends JpaRepository<Developer, Long> {
}
