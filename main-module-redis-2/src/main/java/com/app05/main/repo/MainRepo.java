package com.app05.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app05.main.model.MainData;

@Repository
public interface MainRepo extends JpaRepository<MainData, Long>{

}
