package com.proje.yemekapp.Services.concretes;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.proje.yemekapp.Entities.Menu.MenuEntity;
import com.proje.yemekapp.Entities.Yemek.YemekEntity;
import com.proje.yemekapp.Entities.Yemek.Dtos.YemekCreateDto;
import com.proje.yemekapp.Repositories.MenuRepository;
import com.proje.yemekapp.Repositories.YemekRepository;
import com.proje.yemekapp.Services.abstracts.YemekManager;
import com.proje.yemekapp.Utils.Exceptions.MenuExceptions.MenuNotFoundException;
import com.proje.yemekapp.Utils.Exceptions.YemekExceptions.YemekNotFoundException;
import com.proje.yemekapp.Utils.Mapper.ModelMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class YemekService implements YemekManager {

    private final YemekRepository yemekRepository;
    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    @Override
    public String createYemek(YemekCreateDto yemekDto,Long menuId) {
       YemekEntity entity = modelMapper.toYemekEntity(yemekDto);
       MenuEntity menuEntity = menuRepository.findById(menuId).orElseThrow(()-> new MenuNotFoundException());
       entity.setMenu(menuEntity);
       yemekRepository.save(entity);

        return "Yemek oluşturuldu";
    }

    @Override
    public YemekCreateDto getById(Long yemekId) {
        YemekEntity entity = yemekRepository.findById(yemekId).orElseThrow(()-> new YemekNotFoundException());
        YemekCreateDto response = modelMapper.toYemekDto(entity);
        return response;
    }

    @Override
    public YemekCreateDto getByYemekAdi(String yemekAdi) {
        YemekEntity entity = yemekRepository.findByYemekAdi(yemekAdi).orElseThrow(()-> new YemekNotFoundException());
        YemekCreateDto response = modelMapper.toYemekDto(entity);
        return response;
    }

    @Override
    public List<YemekCreateDto> getByVegan() {
        List<YemekEntity> entities = yemekRepository.findAll();
        List<YemekCreateDto> response = entities.stream().filter(item->item.getVegan()).map(item->modelMapper.toYemekDto(item)).toList();
        return response;
    }

    @Override
    public List<YemekCreateDto> getByVejeteryan() {
        List<YemekEntity> entities = yemekRepository.findAll();
        List<YemekCreateDto> response = entities.stream().filter(item->item.getVejeteryan()).map(item->modelMapper.toYemekDto(item)).toList();
        return response;
    }
    
}
