package net.proselyte.customerdemo.dao;

import lombok.Data;
import net.proselyte.customerdemo.model.Group;


@Data
public class GroupDao {

    private String nameGroup;
    private Integer community;

    public static GroupDao toModel(Group group) {
        GroupDao groupDao = new GroupDao();
        groupDao.setNameGroup(group.getNameGroup());
        groupDao.setCommunity(groupDao.getCommunity());

        return groupDao;
    }

}
