package com.camilabdacosta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.camilabdacosta.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker,Long>{

}
