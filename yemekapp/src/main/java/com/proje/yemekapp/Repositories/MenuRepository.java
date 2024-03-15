package com.proje.yemekapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proje.yemekapp.Entities.Menu.MenuEntity;

/**
 * YemekListeRepository
 */
public interface MenuRepository extends JpaRepository<MenuEntity,Long> {

    
}