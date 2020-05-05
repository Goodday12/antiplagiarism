package com.development5053.antiplagiarism.model.service.impl;

import com.development5053.antiplagiarism.model.dao.CodeDao;
import com.development5053.antiplagiarism.model.entity.Code;
import com.development5053.antiplagiarism.model.service.DaoCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DaoCodeServiceImpl implements DaoCodeService {

    @Autowired
    private CodeDao dao;

    @Override
    public List<Code> findAll() {
        return dao.findAll();
    }

    @Override
    public Optional<Code> getById(long id) {
        return dao.findById(id);
    }

    @Override
    public void save(Code code) {
        dao.save(code);
    }

    @Override
    public void delete(Code code) {
        dao.delete(code);
    }
}
