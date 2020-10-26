package com.minibank.repository;

import com.minibank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value ="select count(*) from User")
    public int countUser();
}
