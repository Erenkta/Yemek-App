package com.proje.yemekapp.Entities.Menu.Dtos;

import java.util.List;

import com.proje.yemekapp.Entities.Yemek.Dtos.YemekCreateDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuInfoDto {

    private String menuAdi;
    private String menuTarih;
    private String menuOgun;
    private List<YemekCreateDto> yemekListe;


    
}
