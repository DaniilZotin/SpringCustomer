package net.proselyte.customerdemo.dao;

import lombok.Data;
import net.proselyte.customerdemo.model.Group;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Component
public class GroupDao {

    private String nameGroup;
    private BigDecimal community;

    private List<DeveloperDao> developerDaoList;

    public static GroupDao toModel(Group group) {
        GroupDao groupDao = new GroupDao();
        groupDao.setNameGroup(group.getNameGroup());
        groupDao.setCommunity(group.getCommunity());
        groupDao.setDeveloperDaoList(group.getDevelopers().stream().map(DeveloperDao::toModel).collect(Collectors.toList()));
        return groupDao;
    }





}
