package net.proselyte.customerdemo.services.implementations;

import lombok.RequiredArgsConstructor;
import net.proselyte.customerdemo.model.Group;
import net.proselyte.customerdemo.repo.GroupRepo;
import net.proselyte.customerdemo.services.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepo groupRepo;

    @Override
    public List<Group> getAll() {
        return groupRepo.findAll();
    }
}
