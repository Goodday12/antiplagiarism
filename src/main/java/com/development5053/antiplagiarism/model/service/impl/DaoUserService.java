package com.development5053.antiplagiarism.model.service.impl;

import com.development5053.antiplagiarism.model.dao.UserDao;
import com.development5053.antiplagiarism.model.entity.security.SiteUser;
import com.development5053.antiplagiarism.model.service.DaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DaoUserService implements DaoService<SiteUser>, UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder encoder;


//    public DaoUserService(UserDao userDao, PasswordEncoder encoder) {
//        this.userDao = userDao;
//        this.encoder = encoder;
//    }

    @Override
    public List<SiteUser> findAll() {
        return userDao.findAll();
    }

    @Override
    public Optional<SiteUser> getById(long id) {
        return userDao.findById(id);
    }

    @Override
    public void save(SiteUser user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public SiteUser findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public void delete(SiteUser user) {
        userDao.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return userDao.findByName(s);
        return null;
    }
}
