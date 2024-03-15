package com.proje.yemekapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proje.yemekapp.Entities.Yemek.YemekEntity;

/**
 * YemekRepository
 */
public interface YemekRepository extends JpaRepository<YemekEntity,Long> {

    
}