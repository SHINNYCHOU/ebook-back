package com.ebook.demo.Repository;

import com.ebook.demo.base.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<users, String> {
}
