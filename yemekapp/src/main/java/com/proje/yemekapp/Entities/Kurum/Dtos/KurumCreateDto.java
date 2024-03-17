package com.proje.yemekapp.Entities.Kurum.Dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
