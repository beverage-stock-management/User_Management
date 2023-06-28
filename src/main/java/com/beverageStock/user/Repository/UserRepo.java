package com.beverageStock.user.Repository;

import com.beverageStock.user.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,Integer> {
    User findUserByUserId(String uId);
}
