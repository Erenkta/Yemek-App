package com.proje.yemekapp.Services.abstracts;

import java.util.List;

import com.proje.yemekapp.Entities.Menu.Dtos.MenuCreateDto;
import com.proje.yemekapp.Entities.Menu.Dtos.MenuInfoDto;

public interface MenuManager {

    //Create
    String createMenu(MenuCreateDto menuDto,Long kurumId);

    //Read
    MenuCreateDto getById(Long menuId);
    MenuCreateDto getByMenuAdi(String menuAdi);
    List<MenuCreateDto> getByOgun(Boolean zaman); /* Akşam yemeği mi yoksa kahvaltı mı */
    List<MenuCreateDto> getByMenuTarih(String menuTarih);
    MenuInfoDto getMenuDetail(Long menuId);

    //TODO : Update ve Delete işlemleri. Ayrıca Read kısmındaki Listelerin Pagination'a çevrilmesi
    
}
