package com.proje.yemekapp.Services.abstracts;

import java.util.List;

import com.proje.yemekapp.Entities.Kurum.Dtos.KurumCreateDto;
import com.proje.yemekapp.Entities.Menu.Dtos.MenuCreateDto;

public interface KurumManager {
    
    //Create
    String createKurum(KurumCreateDto kurumDto);

    // Read 
    KurumCreateDto getById(Long kurumId);
    KurumCreateDto getByName(String kurumAdi);
    List<KurumCreateDto> getByIl(String kurumIl);
    List<MenuCreateDto> getMenu(Long kurumId);

    
    //TODO : Update ve Delete işlemleri. Ayrıca Read kısmındaki Listelerin Pagination'a çevrilmesi
    
} 