package net.proselyte.customerdemo.repo;

import net.proselyte.customerdemo.model.Group;
import net.proselyte.customerdemo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepo extends JpaRepository<Group,Long> {
}
