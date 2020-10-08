package com.example.demo.respository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.username = :name")
    User findByUser( @Param("name") String username);
}
