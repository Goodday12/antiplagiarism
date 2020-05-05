package com.development5053.antiplagiarism.model.service;

import com.development5053.antiplagiarism.model.entity.Code;

import java.util.List;
import java.util.Optional;

public interface DaoCodeService {

    List<Code> findAll();

    void save(Code code);

    void delete(Code code);

    Optional<Code> getById(long id);

}
