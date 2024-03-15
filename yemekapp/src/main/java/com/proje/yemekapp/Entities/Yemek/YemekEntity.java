package com.proje.yemekapp.Entities.Yemek;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.proje.yemekapp.Entities.Menu.MenuEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Base Objecttir. DTO'ları bu object üzerinden oluştur
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Yemek")
@Builder
public class YemekEntity {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String yemekAdi;

    private String yemekTuru; // Çorba - Tatlı - Ana öğün - Meyve

    private Boolean vegan;

    private Boolean vejeteryan;

    private int yemekKalori;
   
    private int yemekGramaj;

    @ManyToOne
    @JoinColumn(name = "menu")
    @JsonBackReference
    private MenuEntity menu;


    
}
