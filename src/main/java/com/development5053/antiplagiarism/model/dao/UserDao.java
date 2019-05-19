package com.development5053.antiplagiarism.model.dao;

import com.development5053.antiplagiarism.model.entity.security.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<SiteUser,Long> {

//    @Query("from SiteUser user where user.email = :mail ")
//    SiteUser findByEmail(@Param("mail") String mail);

//    @Query("from SiteUser where SiteUser.username = :name ")
//    SiteUser findByName(@Param("name") String name);
}
