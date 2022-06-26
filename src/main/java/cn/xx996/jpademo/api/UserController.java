package cn.xx996.jpademo.api;

import cn.xx996.jpademo.dao.UserDao;
import cn.xx996.jpademo.entity.UserEntity;
import cn.xx996.jpademo.search.SearchCriteria;
import cn.xx996.jpademo.specification.UserSpecification;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {

    final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/s")
    public ResponseEntity selectUser(@RequestParam(required = false) Integer age, @RequestParam(required = false) String name) {


        return ResponseEntity.status(HttpStatus.OK).body(userDao.findAllByAgeAndName(age, name));
    }


    @GetMapping("/u")
    public ResponseEntity updateUser() {

        Optional<UserEntity> userEntity = userDao.findById(1L);

        if (userEntity.isPresent()) {

            UserEntity userEntity1 = userEntity.get();
            userEntity1.setName(UUID.randomUUID().toString());
            userEntity1.setId(1L);
            userDao.saveAndFlush(userEntity1);
        }
        return ResponseEntity.status(HttpStatus.OK).body("2222");
    }

    @PostMapping
    ResponseEntity specification(@RequestBody List<SearchCriteria> searchCriteria) {
        UserSpecification<UserEntity> appleSpecification = new UserSpecification();
        searchCriteria.stream().map(
                searchCriterion -> new SearchCriteria(searchCriterion.getKey(),
                        searchCriterion.getValue(),
                        searchCriterion.getOperation())).forEach(appleSpecification::add);
        List<UserEntity> msGenreList = userDao.findAll(appleSpecification);
        msGenreList.forEach(System.out::println);

    return  ResponseEntity.status(HttpStatus.OK).body(msGenreList);
    }

}
