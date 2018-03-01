package com.itpx.cloud.reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itpx.cloud.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
