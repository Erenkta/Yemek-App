package com.proje.yemekapp.Entities.Menu.Dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.proje.yemekapp.Entities.Menu.MenuEntity;
import com.proje.yemekapp.Entities.Yemek.Dtos.YemekCreateDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Menüyü ve içindeki yemekleri içeren Dto
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuYemekDto {

    private String menuAdi;
    private Boolean aksamOgunu; 
    private String menuTarih; 

    @JsonManagedReference
    private List<YemekCreateDto> yemekler = new ArrayList<>();

    public static MenuYemekDto toMenuYemekDto(MenuEntity entity) {
       return MenuYemekDto.builder()
        .menuAdi(entity.getMenuAdi())
        .aksamOgunu(entity.getAksamOgunu())
        .menuTarih(entity.getMenuTarih())
        .yemekler(
            entity.getYemekler().stream()
            .map(item->YemekCreateDto.toYemekDto(item))
            .toList()
        )
       .build();
    }


}
