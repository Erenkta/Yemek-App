package com.proje.yemekapp.Services.concretes;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.proje.yemekapp.Entities.Menu.Dtos.MenuCreateDto;
import com.proje.yemekapp.Services.abstracts.MenuManager;

public class MenuService implements MenuManager{

    @Override
    public ResponseEntity<?> createMenu(MenuCreateDto menuDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createMenu'");
    }

    @Override
    public MenuCreateDto getById(Long menuId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public MenuCreateDto getByMenuAdi(String menuAdi) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByMenuAdi'");
    }

    @Override
    public List<MenuCreateDto> getByOgun(Boolean zaman) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByOgun'");
    }

    @Override
    public List<MenuCreateDto> getByMenuTarih(String menuTarih) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByMenuTarih'");
    }

    @Override
    public List<MenuCreateDto> getByKurum(Long kurumId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByKurum'");
    }
    
}
