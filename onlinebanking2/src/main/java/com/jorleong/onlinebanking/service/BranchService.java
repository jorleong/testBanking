package com.jorleong.onlinebanking.service;

import java.util.List;

import com.jorleong.onlinebanking.domain.Branch;

public interface BranchService {
	public void save(Branch branch);
	public void updateById(long bCode);
	public void deleteById(long bCode);
	public Branch getById(int bCode);
	public List<Branch> findAll();
	public boolean existsById(long bCode);
}
