package com.proje.yemekapp.Services.concretes;

import java.time.Year;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proje.yemekapp.Entities.Menu.MenuEntity;
import com.proje.yemekapp.Entities.Menu.Dtos.MenuCreateDto;
import com.proje.yemekapp.Entities.Menu.Dtos.MenuInfoDto;
import com.proje.yemekapp.Repositories.KurumRepository;
import com.proje.yemekapp.Repositories.MenuRepository;
import com.proje.yemekapp.Services.abstracts.MenuManager;
import com.proje.yemekapp.Utils.Exceptions.KurumExceptions.KurumNotFoundException;
import com.proje.yemekapp.Utils.Exceptions.MenuExceptions.MenuDateHasExpired;
import com.proje.yemekapp.Utils.Exceptions.MenuExceptions.MenuIsNullException;
import com.proje.yemekapp.Utils.Exceptions.MenuExceptions.MenuNotFoundException;
import com.proje.yemekapp.Utils.Mapper.ModelMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MenuService implements MenuManager{

    private final MenuRepository menuRepository;
    private final KurumRepository kurumRepository;
    private final ModelMapper modelMapper;
    

    @Override
    public String createMenu(MenuCreateDto menuDto,Long kurumId) {
        if(menuDto == null){
            throw new MenuIsNullException();
        }
        
        MenuEntity entity = modelMapper.toMenuEntity(menuDto);
        entity.setKurum(kurumRepository.findById(kurumId).orElseThrow(()-> new KurumNotFoundException()));
        menuRepository.save(entity);

        return "Menu başarıyla oluşturuldu";
        
    }

    @Override
    public MenuCreateDto getById(Long menuId) {
        Optional<MenuEntity> optionalEntity = menuRepository.findById(menuId);
        MenuCreateDto response = modelMapper.toMenuDto(optionalEntity.orElseThrow(()->new MenuNotFoundException()));
        return response;
    }

    @Override
    public MenuCreateDto getByMenuAdi(String menuAdi) {
        Optional<MenuEntity> optionalEntity = menuRepository.findByMenuAdi(menuAdi);
        MenuCreateDto response = modelMapper.toMenuDto(optionalEntity.orElseThrow(()->new MenuNotFoundException()));
        return response;
    }

    @Override
    public List<MenuCreateDto> getByOgun(Boolean zaman) {
        List<MenuEntity> entityList = menuRepository.findByMenuOgun(zaman);
        List<MenuCreateDto> response = entityList.stream()
        .map(item->modelMapper.toMenuDto(item))
        .toList();
        return response;
    }

    @Override
    public List<MenuCreateDto> getByMenuTarih(String menuTarih) {
        int year = Year.now().getValue();

        if(Integer.parseInt(menuTarih.split("/")[1])!= year){
            throw new MenuDateHasExpired();
        }
        
       List<MenuEntity> entityList = menuRepository.findByMenuTarih(menuTarih);
       List<MenuCreateDto> response = entityList.stream()
        .map(item->modelMapper.toMenuDto(item))
        .toList();
        return response;
    }

    @Override
    public MenuInfoDto getMenuDetail(Long menuId) {
        MenuEntity entity = menuRepository.findById(menuId).orElseThrow(()->new MenuNotFoundException());
        MenuInfoDto response = modelMapper.toMenuInfoDto(entity);
        return response;
    }

}
