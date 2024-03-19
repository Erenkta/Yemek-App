package com.proje.yemekapp.Utils;

import java.util.List;

import org.springframework.stereotype.Component;

import com.proje.yemekapp.Entities.Kurum.KurumEntity;
import com.proje.yemekapp.Entities.Menu.MenuEntity;
import com.proje.yemekapp.Entities.Yemek.YemekEntity;
import com.proje.yemekapp.Repositories.KurumRepository;
import com.proje.yemekapp.Repositories.MenuRepository;
import com.proje.yemekapp.Repositories.YemekRepository;

/**
 * Bu methotları kullanarak db için test oluştur
 */
@Component
public class CreateTestData {
    
        public void createDbTestData(
        KurumRepository kurumRepository
        ,MenuRepository yemekListeRepository
        ,YemekRepository yemekRepository){




            KurumEntity test = KurumEntity.builder()
            .id(1L)
            .kurumAdi("Test Kurum")
            .kurumIl("Test İl")
            .kurumAdres("Test Adres")
            .build();
            kurumRepository.save(test);

            
            MenuEntity testListe = MenuEntity.builder()
            .id(1L)
            .menuAdi("test")
            .menuOgun(true)
            .menuTarih("GG/AA/YYYY")
            .build();
            yemekListeRepository.save(testListe);

            YemekEntity testYemek = YemekEntity.builder()
            .id(1L)
            .yemekAdi("Test Yemek")
            .yemekTuru("Test Tür")
            .vegan(false)
            .vejeteryan(false)
            .yemekKalori(0)
            .yemekGramaj(0)
            .build();
            
            yemekRepository.save(testYemek);

    
   
            
            // Relations

            testListe.setYemekler(List.of(testYemek));
            testListe.setKurum(test);
            yemekListeRepository.save(testListe);

            testYemek.setMenu(testListe);
            yemekRepository.save(testYemek);

            test.setMenu(List.of(testListe));
            kurumRepository.save(test);
    
        }
    
}
