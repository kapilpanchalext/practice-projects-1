package com.app05.userserviceredis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app05.userserviceredis.model.UserDetails;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Long>{

}
