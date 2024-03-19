package com.proje.yemekapp.Services.abstracts;

import java.util.List;

import com.proje.yemekapp.Entities.Yemek.Dtos.YemekCreateDto;

public interface YemekManager {

    //Create
    String createYemek(YemekCreateDto yemekDto,Long menuId);

    //Read
    YemekCreateDto getById(Long yemekId);
    YemekCreateDto getByYemekAdi(String yemekAdi);
    List<YemekCreateDto> getByVegan();
    List<YemekCreateDto> getByVejeteryan();

    
    //TODO : Update ve Delete işlemleri. Ayrıca Read kısmındaki Listelerin Pagination'a çevrilmesi
    
} 