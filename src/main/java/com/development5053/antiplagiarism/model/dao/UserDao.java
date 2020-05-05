package com.development5053.antiplagiarism.model.dao;

import com.development5053.antiplagiarism.model.entity.security.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<SiteUser, Long> {

//    @Query("from SiteUser user where user.email = :mail ")
//    SiteUser findByEmail(@Param("mail") String mail);

    @Query(value = "SELECT u FROM SiteUser u WHERE u.username = ?1")
    SiteUser findByName(String name);
}
