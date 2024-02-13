package com.jorleong.onlinebanking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jorleong.onlinebanking.domain.Branch;
import com.jorleong.onlinebanking.repository.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService{
	
	@Autowired
	BranchRepository branchRepository;
	
	@Override
	public void save(Branch branch) {
		branchRepository.save(branch);
	}

	@Override
	public void updateById(long bCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long bCode) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public Branch getById(int bCode) {
		Optional<Branch> branch = branchRepository.findById(bCode);
		return branch.get();
	}

	@Override
	public List<Branch> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(long bCode) {
		return branchRepository.existsById((int) bCode);
	}


}
