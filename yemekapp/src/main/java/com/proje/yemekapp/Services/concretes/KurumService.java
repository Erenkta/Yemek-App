package com.proje.yemekapp.Services.concretes;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.proje.yemekapp.Entities.Kurum.KurumEntity;
import com.proje.yemekapp.Entities.Kurum.Dtos.KurumCreateDto;
import com.proje.yemekapp.Entities.Kurum.Dtos.KurumMenuDto;
import com.proje.yemekapp.Repositories.KurumRepository;
import com.proje.yemekapp.Services.abstracts.KurumManager;
import com.proje.yemekapp.Utils.Exceptions.KurumExceptions.KurumCannotFoundException;
import com.proje.yemekapp.Utils.Exceptions.KurumExceptions.KurumIsNullException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KurumService implements KurumManager {

    private final KurumRepository kurumRepository;

    @Override
    public String createKurum(KurumCreateDto kurumDto)  {
        if(kurumDto == null){
            throw new KurumIsNullException();
        }
            KurumEntity entity = KurumCreateDto.toKurumEntity(kurumDto);
            kurumRepository.save(entity);
       
        return "Kurum başarıyla oluşturuldu";

    }

    @Override
    public KurumCreateDto getById(Long kurumId) {
        Optional<KurumEntity> entity = kurumRepository.findById(kurumId);
        KurumCreateDto fromDb = KurumCreateDto.toKurumDto(
            entity.orElseThrow(()->new KurumCannotFoundException())
        );

        return fromDb;
    }

    @Override
    public KurumCreateDto getByName(String kurumAdi) {
        Optional<KurumEntity> entity = kurumRepository.findByKurumAdi(kurumAdi);
        KurumCreateDto fromDb = KurumCreateDto.toKurumDto(
            entity.orElseThrow(()->new KurumCannotFoundException())
        );

        return fromDb;
    }

    @Override
    public List<KurumCreateDto> getByIl(String kurumIl) {
        Optional<List<KurumEntity>> entityOptional = kurumRepository.findByKurumIl(kurumIl);
        List<KurumEntity> entity = entityOptional.orElseThrow(()->new KurumCannotFoundException());
        List<KurumCreateDto> fromDb =  entity.stream()
        .map(item->KurumCreateDto.toKurumDto(item))
        .toList();

        return fromDb;
    }

    @Override
    public KurumMenuDto getMenu(Long kurumId) {
        Optional<KurumEntity> entityOptional = kurumRepository.findById(kurumId);
        KurumEntity entity = entityOptional.orElseThrow(()->new KurumCannotFoundException());
        KurumMenuDto response = KurumMenuDto.toKurumMenuDto(entity.getKurumAdi(), entity.getMenu());
        return response;
        
    }

}