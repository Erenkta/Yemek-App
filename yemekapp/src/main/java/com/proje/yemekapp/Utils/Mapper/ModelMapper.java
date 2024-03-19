package com.proje.yemekapp.Utils.Mapper;

import org.springframework.stereotype.Component;

import com.proje.yemekapp.Entities.Kurum.KurumEntity;
import com.proje.yemekapp.Entities.Kurum.Dtos.KurumCreateDto;
import com.proje.yemekapp.Entities.Menu.MenuEntity;
import com.proje.yemekapp.Entities.Menu.Dtos.MenuCreateDto;
import com.proje.yemekapp.Entities.Menu.Dtos.MenuInfoDto;
import com.proje.yemekapp.Entities.Yemek.YemekEntity;
import com.proje.yemekapp.Entities.Yemek.Dtos.YemekCreateDto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@Component
public class ModelMapper {


    public MenuEntity toMenuEntity(MenuCreateDto menuDto) {
        boolean ogun = menuDto.getMenuOgun().contains("Akşam");
        MenuEntity menuEntity = MenuEntity.builder()
                .menuAdi(menuDto.getMenuAdi())
                .menuOgun(ogun)
                .menuTarih(menuDto.getMenuTarih())
                .build();
                return menuEntity;

    }
    
    public MenuCreateDto toMenuDto(MenuEntity menuEntity) {
        System.out.println(menuEntity.getMenuOgun());
        return MenuCreateDto.builder()
                .menuAdi(menuEntity.getMenuAdi())
                .menuOgun(menuEntity.getMenuOgun() ? "Akşam Yemeği" : "Sabah Kahvaltısı")
                .menuTarih(menuEntity.getMenuTarih())
                .build();
    }
    
    public KurumEntity toKurumEntity(KurumCreateDto kurumDto) {
        KurumEntity kurumEntity =  KurumEntity.builder()
                .kurumAdi(kurumDto.getKurumAdi())
                .kurumIl(kurumDto.getKurumIl())
                .kurumAdres(kurumDto.getKurumAdres())
                .build();
                return kurumEntity;
    }

    public KurumCreateDto toKurumDto(KurumEntity kurumEntity) {
        return KurumCreateDto.builder()
                .kurumAdi(kurumEntity.getKurumAdi())
                .kurumIl(kurumEntity.getKurumIl())
                .kurumAdres(kurumEntity.getKurumAdres())
                .build();
    }
   
    public YemekCreateDto toYemekDto(YemekEntity yemekEntity) {
        return YemekCreateDto.builder()
                .yemekAdi(yemekEntity.getYemekAdi())
                .yemekTuru(yemekEntity.getYemekTuru())
                .vegan(yemekEntity.getVegan())
                .vejeteryan(yemekEntity.getVejeteryan())
                .yemekKalori(yemekEntity.getYemekKalori())
                .yemekGramaj(yemekEntity.getYemekGramaj())
                .build();
    }

    public YemekEntity toYemekEntity(YemekCreateDto yemekDto) {
        return YemekEntity.builder()
                .yemekAdi(yemekDto.getYemekAdi())
                .yemekTuru(yemekDto.getYemekTuru())
                .vegan(yemekDto.getVegan())
                .vejeteryan(yemekDto.getVejeteryan())
                .yemekKalori(yemekDto.getYemekKalori())
                .yemekGramaj(yemekDto.getYemekGramaj())
                .build();
    }

    public MenuInfoDto toMenuInfoDto(MenuEntity menuEntity){
        return MenuInfoDto.builder()
        .menuAdi(menuEntity.getMenuAdi())
        .menuTarih(menuEntity.getMenuTarih())
        .menuOgun(menuEntity.getMenuOgun() ? "Akşam Yemeği" : "Sabah Kahvaltısı") 
        .yemekListe(
            menuEntity.getYemekler().stream()
            .map(item->this.toYemekDto(item))
            .toList()
        )
        .build();
    }
}
