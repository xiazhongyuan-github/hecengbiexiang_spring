package com.hitachi.elderly.applaud.repository;

import com.hitachi.elderly.applaud.entity.ApplaudEntity;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ApplaudRepository extends JpaRepository<ApplaudEntity,String>{
    @Transactional
    Integer deleteByCode(String code);
}
