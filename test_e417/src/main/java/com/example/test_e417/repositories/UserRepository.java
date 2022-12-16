package com.example.test_e417.repositories;

import com.example.test_e417.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername (String Username);
    User getById (Long id);

}
