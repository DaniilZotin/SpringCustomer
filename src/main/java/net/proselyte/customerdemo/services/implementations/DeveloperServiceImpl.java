package net.proselyte.customerdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import net.proselyte.customerdemo.dao.DeveloperDao;
import net.proselyte.customerdemo.model.Developer;
import net.proselyte.customerdemo.model.Group;
import net.proselyte.customerdemo.repo.DeveloperRepo;
import net.proselyte.customerdemo.repo.GroupRepo;
import net.proselyte.customerdemo.services.DeveloperService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {

    private final GroupRepo groupRepo;

    private final DeveloperRepo developerRepo;
    @Override
    public DeveloperDao createDeveloper(Developer developer, Long groupId) {
        Group groupInsertDeveloper = groupRepo.findById(groupId).get();
        developer.setGroup(groupInsertDeveloper);

        developerRepo.save(developer);

        return DeveloperDao.toModel(developer);
    }
}
