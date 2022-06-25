package cn.xx996.jpademo.service;

import cn.xx996.jpademo.dao.UserDao;
import cn.xx996.jpademo.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    UserDao userDao;


    @Test
    @Rollback(false)
    public void addUser() {


        UserEntity userEntity = new UserEntity();
        userEntity.setName("zz");
        userDao.save(userEntity);
    }

    @Test
    public void updateUser() {

        Optional<UserEntity> userEntity = userDao.findById(1L);
        if (userEntity.isPresent()) {
            userEntity.get().setName("22222222222");
            userDao.save(userEntity.get());
        }

    }
}
