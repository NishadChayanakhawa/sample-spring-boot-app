package io.github.nishadchayanakhawa.samplespringapp.jparepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.nishadchayanakhawa.samplespringapp.model.User;

public interface UserRepository extends JpaRepository<User,String>{
	public User findByUsername(String username);
}
