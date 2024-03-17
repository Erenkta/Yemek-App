package com.proje.yemekapp.Entities.Yemek.Dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.proje.yemekapp.Entities.Menu.Dtos.MenuCreateDto;
import com.proje.yemekapp.Entities.Yemek.YemekEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class YemekCreateDto {
    
    private String yemekAdi;
    private String yemekTuru; // Çorba - Tatlı - Ana öğün - Meyve
    private Boolean vegan;
    private Boolean vejeteryan;
    private int yemekKalori;
    private int yemekGramaj;
}

