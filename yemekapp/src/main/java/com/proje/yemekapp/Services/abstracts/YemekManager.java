package com.proje.yemekapp.Services.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.proje.yemekapp.Entities.Yemek.Dtos.YemekCreateDto;

public interface YemekManager {

    //Create
    ResponseEntity<?> createYemek(YemekCreateDto yemekDto);

    //Read
    YemekCreateDto getById(Long yemekId);
    YemekCreateDto getByYemekAdi(String yemekAdi);
    List<YemekCreateDto> getByVegan();
    List<YemekCreateDto> getByVejeteryan();
    List<YemekCreateDto> getByMenu(); // O menüde olan yemekleri getir 

    
    //TODO : Update ve Delete işlemleri. Ayrıca Read kısmındaki Listelerin Pagination'a çevrilmesi
    
} 