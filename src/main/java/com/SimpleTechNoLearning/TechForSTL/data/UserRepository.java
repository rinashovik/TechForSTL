package com.SimpleTechNoLearning.TechForSTL.data;

import com.SimpleTechNoLearning.TechForSTL.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
