package com.proje.yemekapp.Entities.Menu.Dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.proje.yemekapp.Entities.Kurum.Dtos.KurumCreateDto;
import com.proje.yemekapp.Entities.Menu.MenuEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/* Bir menü oluşturup bunu kuruma atamaya yarayan DTO  */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuCreateDto {
    
    private String menuAdi;
    private String menuOgun;
    private String menuTarih; 

}
