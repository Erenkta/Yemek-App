package com.proje.yemekapp.Entities.Menu;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.proje.yemekapp.Entities.Kurum.KurumEntity;
import com.proje.yemekapp.Entities.Yemek.YemekEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "Menu")
@Builder
public class MenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

  
    private String menuAdi; 


    private Boolean aksamOgunu; // Akşam mı sabah mı bunu belli etmeli // Boolean da olabilir // True ise aksam

    private String menuTarih; // Ne zamanın yemeği // ay ve yıldan oluşmalı
    
    @OneToMany(mappedBy = "menu")
    @JsonManagedReference
    private List<YemekEntity> yemekler;

    @ManyToOne
    @JoinColumn(name = "kurum")
    @JsonBackReference
    private KurumEntity kurum;


}
