package net.proselyte.customerdemo.services;

import net.proselyte.customerdemo.dao.DeveloperDao;
import net.proselyte.customerdemo.model.Developer;

public interface DeveloperService {
    DeveloperDao createDeveloper(Developer developer, Long groupId);
}
