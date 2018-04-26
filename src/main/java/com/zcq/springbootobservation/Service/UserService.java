package com.zcq.springbootobservation.Service;


import com.zcq.springbootobservation.Entity.UserType;
import com.zcq.springbootobservation.Mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<UserType> getAll(){
        return userDao.getAll();
    }
    public boolean verifyLogin(UserType usersType){ return userDao.verifyLogin(usersType);}
    public void register(UserType userType){ userDao.register(userType);}

}
