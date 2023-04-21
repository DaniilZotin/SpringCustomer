package net.proselyte.customerdemo.dao;

import lombok.Data;
import net.proselyte.customerdemo.model.Group;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Data
@Component
public class GroupDao {

    private String nameGroup;
    private BigDecimal community;

    public static GroupDao toModel(Group group) {
        GroupDao groupDao = new GroupDao();
        groupDao.setNameGroup(group.getNameGroup());
        groupDao.setCommunity(group.getCommunity());

        return groupDao;
    }

}
