package cn.xx996.jpademo.api;

import cn.xx996.jpademo.dao.UserDao;
import cn.xx996.jpademo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    final
    UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/u")
    public ResponseEntity updateUser() {

        Optional<UserEntity> userEntity = userDao.findById(1L);

        if (userEntity.isPresent()) {

            userEntity.get().setName("lzz");
            userDao.save(userEntity.get());
        }
        return ResponseEntity.status(HttpStatus.OK).body("2222");
    }

}
