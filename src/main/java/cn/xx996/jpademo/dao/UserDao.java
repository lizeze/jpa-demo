package cn.xx996.jpademo.dao;

import cn.xx996.jpademo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> , JpaSpecificationExecutor<UserEntity> {



     List<UserEntity> findAllByAgeAndName(Integer age,String name);
}
