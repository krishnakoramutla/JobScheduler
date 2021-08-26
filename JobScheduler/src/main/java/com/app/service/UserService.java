package com.app.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.model.User;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Scheduled(fixedRate = 5000)
	public void add2db() {
		User user = new User();
		user.setName("user" + new Random().nextInt(374483));
		dao.save(user);
		System.out.println("add service call in" + new Date().toString());
	}

	@Scheduled(cron = "0/15 * * * * *")
	public void fetchDb() {
		List<User> users = dao.findAll();
		System.out.println("fetch service call in" + new Date().toString());
		System.out.println("total records =" + users.size());
		logger.info("users {}", users);
	}

}
