package com.SimpleTechNoLearning.TechForSTL.data;

import com.SimpleTechNoLearning.TechForSTL.models.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository extends CrudRepository<UserProfile, Integer> {

Iterable<UserProfile> findAllById(Iterable<Integer> profileId);

}
