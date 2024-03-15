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
    
    @JsonBackReference
    private MenuCreateDto menu;

    public static YemekCreateDto toYemekDto(YemekEntity yemekEntity) {
        return YemekCreateDto.builder()
                .yemekAdi(yemekEntity.getYemekAdi())
                .yemekTuru(yemekEntity.getYemekTuru())
                .vegan(yemekEntity.getVegan())
                .vejeteryan(yemekEntity.getVejeteryan())
                .yemekKalori(yemekEntity.getYemekKalori())
                .yemekGramaj(yemekEntity.getYemekGramaj())
                .menu(MenuCreateDto.toMenuDto(yemekEntity.getMenu()))
                .build();
    }

    public static YemekEntity toYemekEntity(YemekCreateDto yemekDto) {
        return YemekEntity.builder()
                .yemekAdi(yemekDto.getYemekAdi())
                .yemekTuru(yemekDto.getYemekTuru())
                .vegan(yemekDto.getVegan())
                .vejeteryan(yemekDto.getVejeteryan())
                .yemekKalori(yemekDto.getYemekKalori())
                .yemekGramaj(yemekDto.getYemekGramaj())
                .menu(MenuCreateDto.toMenuEntity(yemekDto.getMenu()))
                .build();
    }

}
