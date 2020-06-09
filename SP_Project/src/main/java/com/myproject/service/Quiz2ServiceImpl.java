package com.myproject.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myproject.persistence.Quiz2DAO;

@Service
public class Quiz2ServiceImpl implements Quiz2Service{
	
	@Inject
	private Quiz2DAO q2dao;

}
