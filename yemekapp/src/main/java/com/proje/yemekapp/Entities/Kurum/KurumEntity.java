package com.proje.yemekapp.Entities.Kurum;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.proje.yemekapp.Entities.Menu.MenuEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder.Default;

/**
 * Base Objecttir. DTO'ları bu object üzerinden oluştur
 */

@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor
@Entity
@Table(name = "Kurum") 
@Builder
public class KurumEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    private String kurumAdi;

    private String kurumIl;

    private String kurumAdres;

    @OneToMany(mappedBy ="kurum",cascade = CascadeType.REMOVE)
    @JsonManagedReference
    @Default
    private List<MenuEntity> menu = new ArrayList<>();


}


/**
 * {
    "id" : 1,
    "kurumAdi":"test",
    "kurumIl":"test",
    "kurumAdres":"test",
    "sabahListesi":[
        {
            "id":12,
            "listeAdi":"test",
            "listeOgun":"test",
            "listeTarih":"test",
            "yemekListesi":[
                {
                    "id":111,
                    "yemekAdi":"test",
                    "yemekTuru":"test",
                    "vegan":false,
                    "vejeteryan":false,
                    "yemekKalori":12,
                    "yemekGramaj":12,
                    "liste_id":12
                }
            ],
            "kurum_id":1
        }
    ]
}
 */