package com.proje.yemekapp.Services.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proje.yemekapp.Entities.Menu.MenuEntity;
import com.proje.yemekapp.Entities.Menu.Dtos.MenuCreateDto;
import com.proje.yemekapp.Repositories.KurumRepository;
import com.proje.yemekapp.Repositories.MenuRepository;
import com.proje.yemekapp.Services.abstracts.MenuManager;
import com.proje.yemekapp.Utils.Exceptions.KurumExceptions.KurumNotFoundException;
import com.proje.yemekapp.Utils.Exceptions.MenuExceptions.MenuNotFoundException;
import com.proje.yemekapp.Utils.Mapper.ModelMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MenuService implements MenuManager{

    private final MenuRepository menuRepository;
    private final KurumRepository kurumRepository;
    private final ModelMapper mapper;
    

    @Override
    public MenuCreateDto createMenu(MenuCreateDto menuDto,Long kurumId) {
        
        MenuEntity entity = mapper.toMenuEntity(menuDto);
        entity.setKurum(kurumRepository.findById(kurumId).orElseThrow(()-> new KurumNotFoundException()));
        menuRepository.save(entity);

        return menuDto;
        
    }

    @Override
    public MenuCreateDto getById(Long menuId) {
        Optional<MenuEntity> optionalEntity = menuRepository.findById(menuId);
        MenuCreateDto response = mapper.toMenuDto(optionalEntity.orElseThrow(()->new MenuNotFoundException()));
        return response;
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
