package com.KuntzeProjects.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.KuntzeProjects.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
