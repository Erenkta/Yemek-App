package com.proje.yemekapp.Entities.Menu.Dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.proje.yemekapp.Entities.Kurum.Dtos.KurumCreateDto;
import com.proje.yemekapp.Entities.Menu.MenuEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuCreateDto {
    private String menuAdi;
    private Boolean aksamOgunu; // Akşam mı sabah mı bunu belli etmeli
    private String menuTarih; // Ne zamanın yemeği // ay ve yıldan oluşmalı


    @JsonBackReference
    private KurumCreateDto kurum;

    public static MenuEntity toMenuEntity(MenuCreateDto menuDto) {
        return MenuEntity.builder()
                .menuAdi(menuDto.getMenuAdi())
                .aksamOgunu(menuDto.getAksamOgunu())
                .menuTarih(menuDto.getMenuTarih())
                .kurum(KurumCreateDto.toKurumEntity(menuDto.getKurum()))
                .build();
    }

    public static MenuCreateDto toMenuDto(MenuEntity menuEntity) {
        return MenuCreateDto.builder()
                .menuAdi(menuEntity.getMenuAdi())
                .aksamOgunu(menuEntity.getAksamOgunu())
                .menuTarih(menuEntity.getMenuTarih())
                .kurum(KurumCreateDto.toKurumDto(menuEntity.getKurum()))
                .build();
    }

}
