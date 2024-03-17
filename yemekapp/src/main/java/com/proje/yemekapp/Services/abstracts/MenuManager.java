package com.proje.yemekapp.Services.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.proje.yemekapp.Entities.Menu.MenuEntity;
import com.proje.yemekapp.Entities.Menu.Dtos.MenuCreateDto;

public interface MenuManager {

    //Create
    MenuCreateDto createMenu(MenuCreateDto menuDto,Long kurumId);

    //Read
    MenuCreateDto getById(Long menuId);
    MenuCreateDto getByMenuAdi(String menuAdi);
    List<MenuCreateDto> getByOgun(Boolean zaman); /* Akşam yemeği mi yoksa kahvaltı mı */
    List<MenuCreateDto> getByMenuTarih(String menuTarih);
    List<MenuCreateDto> getByKurum(Long kurumId); // O kuruma ait tüm menüler 

    //TODO : Update ve Delete işlemleri. Ayrıca Read kısmındaki Listelerin Pagination'a çevrilmesi
    
}
