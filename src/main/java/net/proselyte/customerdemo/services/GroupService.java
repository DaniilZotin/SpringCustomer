package net.proselyte.customerdemo.services;

import net.proselyte.customerdemo.model.Customer;
import net.proselyte.customerdemo.model.Group;

import java.util.List;

public interface GroupService {

    List<Group> getAll();

    void save(Group group);

}
