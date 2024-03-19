package com.proje.yemekapp.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proje.yemekapp.Entities.Menu.MenuEntity;
import com.proje.yemekapp.Entities.Kurum.KurumEntity;


/**
 * YemekListeRepository
 */
public interface MenuRepository extends JpaRepository<MenuEntity,Long> {
    Optional<MenuEntity> findByMenuAdi(String menuAdi);

    List<MenuEntity> findByMenuOgun(Boolean menuOgun);
    List<MenuEntity> findByMenuTarih(String menuTarih);
    List<MenuEntity> findByKurum(KurumEntity kurum);
    
}