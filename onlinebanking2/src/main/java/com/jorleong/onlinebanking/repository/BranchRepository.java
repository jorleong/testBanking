package com.jorleong.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorleong.onlinebanking.domain.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer>{

}
