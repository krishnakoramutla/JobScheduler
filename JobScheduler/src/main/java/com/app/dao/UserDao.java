package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
