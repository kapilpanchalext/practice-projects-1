package com.app.tips.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.app.tips.bean.Program;

public interface ProgramRepository extends CrudRepository<Program, UUID>{

}
