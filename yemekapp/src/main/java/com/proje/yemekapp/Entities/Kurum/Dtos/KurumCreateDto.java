package com.proje.yemekapp.Entities.Kurum.Dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.proje.yemekapp.Entities.Kurum.KurumEntity;
import com.proje.yemekapp.Entities.Menu.Dtos.MenuCreateDto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder.Default;

/**
 * Kurum Adı , Kurumun ili ve Adresini içeren DTO
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KurumCreateDto {

    @NotEmpty
    private String kurumAdi;
    @NotEmpty
    private String kurumIl;
    @NotEmpty
    private String kurumAdres;

}
