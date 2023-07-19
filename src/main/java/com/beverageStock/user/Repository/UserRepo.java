package com.beverageStock.user.Repository;


import com.beverageStock.user.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {


    User save(User user);
}
