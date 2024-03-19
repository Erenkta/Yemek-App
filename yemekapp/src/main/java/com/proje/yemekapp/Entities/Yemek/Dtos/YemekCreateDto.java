package com.proje.yemekapp.Entities.Yemek.Dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class YemekCreateDto {
    
    @NotEmpty
    private String yemekAdi;
    @NotEmpty
    private String yemekTuru; // Çorba - Tatlı - Ana öğün - Meyve

    @Default
    private Boolean vegan = false;
    @Default
    private Boolean vejeteryan = false;

    @NotEmpty
    private int yemekKalori;
    @NotEmpty
    private int yemekGramaj;
}

