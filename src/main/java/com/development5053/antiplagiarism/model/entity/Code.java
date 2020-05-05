package com.development5053.antiplagiarism.model.entity;


import com.development5053.antiplagiarism.model.entity.security.SiteUser;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Lob
    private String code;

    public String getCode() {
        return code;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private SiteUser user;

    @Override
    public String toString() {
        return "Code{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
