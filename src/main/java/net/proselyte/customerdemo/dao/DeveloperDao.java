package net.proselyte.customerdemo.dao;

import lombok.Data;
import net.proselyte.customerdemo.model.Developer;

@Data
public class DeveloperDao {

    private String role;
    private Integer experience;

    public static DeveloperDao toModel(Developer developer){
        DeveloperDao developerDao = new DeveloperDao();
        developerDao.setExperience(developer.getExperience());
        developerDao.setRole(developer.getRole());
        return developerDao;
    }
}
