package com.proje.yemekapp.Services.concretes;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proje.yemekapp.Entities.Yemek.Dtos.YemekCreateDto;
import com.proje.yemekapp.Services.abstracts.YemekManager;

@Service
public class YemekService implements YemekManager {

    @Override
    public ResponseEntity<?> createYemek(YemekCreateDto yemekDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createYemek'");
    }

    @Override
    public YemekCreateDto getById(Long yemekId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public YemekCreateDto getByYemekAdi(String yemekAdi) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByYemekAdi'");
    }

    @Override
    public List<YemekCreateDto> getByVegan() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByVegan'");
    }

    @Override
    public List<YemekCreateDto> getByVejeteryan() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByVejeteryan'");
    }

    @Override
    public List<YemekCreateDto> getByMenu() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByMenu'");
    }
    
}
