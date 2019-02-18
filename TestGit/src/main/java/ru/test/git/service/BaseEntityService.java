package ru.test.git.service;

import ru.test.git.entitties.BaseEntity;
import ru.test.git.entitties.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseEntityService {

    List<BaseEntity> list = new ArrayList<BaseEntity>();

    public BaseEntityService() {
        this.list.addAll(Arrays.<BaseEntity>asList(new BaseEntity((long) 1), new BaseEntity((long) 2), new BaseEntity((long) 3)));
    }

    public List<BaseEntity> getAllPersons(){
        return list;
    }

    public void showAllPersons(){
        for (BaseEntity p : list){
            System.out.println(p.getId());
        }
    }

}
