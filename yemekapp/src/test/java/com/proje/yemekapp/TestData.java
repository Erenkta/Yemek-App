package com.proje.yemekapp;

import java.util.List;

import org.checkerframework.checker.units.qual.K;

import com.proje.yemekapp.Entities.Kurum.KurumEntity;
import com.proje.yemekapp.Entities.Kurum.Dtos.KurumCreateDto;
import com.proje.yemekapp.Entities.Kurum.Dtos.KurumMenuDto;
import com.proje.yemekapp.Entities.Menu.MenuEntity;
import com.proje.yemekapp.Entities.Menu.Dtos.MenuYemekDto;
import com.proje.yemekapp.Entities.Yemek.YemekEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TestData {
    
    public static KurumEntity testKurumEntity(){
        KurumEntity kurum =  KurumEntity.builder()
        .id(0L)
        .kurumAdi("test")
        .kurumAdres("test")
        .kurumIl("test")
        .build();

        MenuEntity menu = MenuEntity.builder()
        .id(0L)
        .aksamOgunu(true)
        .kurum(kurum)
        .menuAdi("test")
        .menuTarih("test") 
        .build();

        YemekEntity yemek = YemekEntity.builder()
        .id(0L)
        .menu(menu)
        .vegan(false)
        .vejeteryan(false)
        .yemekAdi("test")
        .yemekGramaj(100)
        .yemekKalori(100)
        .yemekTuru("Çorba")
        .build();
        menu.setYemekler(List.of(yemek));
        kurum.setMenu(List.of(menu));
        return kurum;
    }
    public static KurumCreateDto testKurumCreateDto(){
        return KurumCreateDto.builder()
        .kurumAdi("test")
        .kurumIl("test")
        .kurumAdres("test")
        .build();
    }
    public static KurumMenuDto testKurumMenuDto(){
        return KurumMenuDto.builder()
        .kurumAdi("test")
        .menu(MenuYemekDto.builder()
        .menuAdi("test menu")
        .menuTarih("test tarih")
        .aksamOgunu(true)
        .yemekler(List.of()).build())
        .build();

    }
}
