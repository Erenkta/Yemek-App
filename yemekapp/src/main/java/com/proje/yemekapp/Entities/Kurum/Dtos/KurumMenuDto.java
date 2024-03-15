package com.proje.yemekapp.Entities.Kurum.Dtos;

import java.util.List;

import com.proje.yemekapp.Entities.Menu.MenuEntity;
import com.proje.yemekapp.Entities.Menu.Dtos.MenuYemekDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Kurum'a ait menüyü içeren DTO
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KurumMenuDto {

    private String kurumAdi;
    private MenuYemekDto menu;
   


    public static KurumMenuDto toKurumMenuDto(String kurumAdi,List<MenuEntity> menuEntities){
       return KurumMenuDto.builder()
        .kurumAdi(kurumAdi)
        .menu(MenuYemekDto.toMenuYemekDto(menuEntities.get(0)))
        .build();

    }
    
}
