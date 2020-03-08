package com.lin.sleeve.dao;

import com.lin.sleeve.entity.Spu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpuRepository extends JpaRepository<Spu, Long> {
    Spu findOneById(Long id);
}
