package com.proje.yemekapp.Services.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proje.yemekapp.Entities.Kurum.KurumEntity;
import com.proje.yemekapp.Entities.Kurum.Dtos.KurumCreateDto;
import com.proje.yemekapp.Entities.Menu.Dtos.MenuCreateDto;
import com.proje.yemekapp.Repositories.KurumRepository;
import com.proje.yemekapp.Services.abstracts.KurumManager;
import com.proje.yemekapp.Utils.Exceptions.KurumExceptions.KurumIsNullException;
import com.proje.yemekapp.Utils.Exceptions.KurumExceptions.KurumMenuNotFoundException;
import com.proje.yemekapp.Utils.Exceptions.KurumExceptions.KurumNotFoundException;
import com.proje.yemekapp.Utils.Mapper.ModelMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KurumService implements KurumManager {

    private final KurumRepository kurumRepository;
    private final ModelMapper modelMapper;
    @Override
    public String createKurum(KurumCreateDto kurumDto)  {
        if(kurumDto == null){
            throw new KurumIsNullException();
        }
            KurumEntity entity = modelMapper.toKurumEntity(kurumDto);
            kurumRepository.save(entity);
       
        return "Kurum başarıyla oluşturuldu";

    }

    @Override
    public KurumCreateDto getById(Long kurumId) {
        Optional<KurumEntity> entity = kurumRepository.findById(kurumId);
        KurumCreateDto fromDb = modelMapper.toKurumDto(
            entity.orElseThrow(()->new KurumNotFoundException())
        );

        return fromDb;
    }

    @Override
    public KurumCreateDto getByName(String kurumAdi) {

        Optional<KurumEntity> entity = kurumRepository.findByKurumAdi(kurumAdi);
        KurumCreateDto fromDb = modelMapper.toKurumDto(
            entity.orElseThrow(()->new KurumNotFoundException())
        );
        

        return fromDb;
    }

    @Override
    public List<KurumCreateDto> getByIl(String kurumIl) {
        Optional<List<KurumEntity>> entityOptional = kurumRepository.findByKurumIl(kurumIl);
        List<KurumEntity> entity = entityOptional.orElseThrow(()->new KurumNotFoundException());
        List<KurumCreateDto> fromDb =  entity.stream()
        .map(item->modelMapper.toKurumDto(item))
        .toList();

        return fromDb;
    }

    
    @Override
    public List<MenuCreateDto> getMenu(Long kurumId) {
        Optional<KurumEntity> entityOptional = kurumRepository.findById(kurumId);

        KurumEntity entity = entityOptional.orElseThrow(()->new KurumNotFoundException());
        
        if(entity.getMenu().size() == 0){
            throw new KurumMenuNotFoundException();
        }
        
        List<MenuCreateDto> response = entity.getMenu().stream().map(item->modelMapper.toMenuDto(item)).toList();
        return response;
    }

}
