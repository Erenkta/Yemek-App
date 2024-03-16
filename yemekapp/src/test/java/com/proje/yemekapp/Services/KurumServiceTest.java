package com.proje.yemekapp.Services;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.proje.yemekapp.TestData;
import com.proje.yemekapp.Entities.Kurum.KurumEntity;
import com.proje.yemekapp.Entities.Kurum.Dtos.KurumCreateDto;
import com.proje.yemekapp.Entities.Kurum.Dtos.KurumMenuDto;
import com.proje.yemekapp.Repositories.KurumRepository;
import com.proje.yemekapp.Services.concretes.KurumService;
import com.proje.yemekapp.Utils.Exceptions.KurumExceptions.KurumNotFoundException;
import com.proje.yemekapp.Utils.Exceptions.KurumExceptions.KurumIsNullException;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class) 
public class KurumServiceTest {

    @Mock
    private KurumRepository kurumRepository;

    @InjectMocks
    private KurumService kurumService;

    private KurumEntity kurumEntity = TestData.testKurumEntity();
    private KurumCreateDto kurumCreateDto = TestData.testKurumCreateDto();
    private KurumMenuDto kurumMenuDto = TestData.testKurumMenuDto();


    @Test
    public void testThat_CreateKurum_ReturnsString_WhenKurumIsCreated(){
        when(kurumRepository.save(Mockito.any(KurumEntity.class))).thenReturn(kurumEntity); // davranışını belirledik
        String actualMessage = kurumService.createKurum(kurumCreateDto);
        String expectedMessage = "Kurum başarıyla oluşturuldu";
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }    

    @Test
    public void testThat_CreateKurum_ThrowsException_WhenKurumIsNull(){
       Exception exception =  assertThrows(
           KurumIsNullException.class
        , ()->{
                kurumService.createKurum(null);
        });
       
        Mockito.verifyNoInteractions(kurumRepository);
        String expectedMesssage = "Kurum bilgisi boş bırakılamaz";
        Assertions.assertTrue(expectedMesssage.contains(exception.getLocalizedMessage()));
    }

    @Test
    public void testThat_GetById_ReturnsKurum(){
        when(kurumRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(kurumEntity));
        KurumCreateDto fromDb = kurumService.getById(0L);

        Assertions.assertTrue(fromDb.getKurumAdi().equals(kurumEntity.getKurumAdi()));
    }
    @Test
    public void testThat_GetById_ThrowsException_WhenKurumCannotFound(){
        Exception exception = assertThrows(
            KurumNotFoundException.class, 
            ()->{
                kurumService.getById(0L);
            });

           String actualMessage ="Bu bilgilere ait kurum bulunamadı";
           Assertions.assertTrue(actualMessage.contains(exception.getLocalizedMessage()));
    }
    @Test
    public void testThat_GetByName_ReturnKurum(){
        when(kurumRepository.findByKurumAdi(Mockito.anyString())).thenReturn(Optional.ofNullable(kurumEntity));
        KurumCreateDto fromDb = kurumService.getByName("test");

        Assertions.assertNotNull(fromDb);
        Assertions.assertEquals(fromDb.getKurumAdi(), kurumEntity.getKurumAdi());
    }
    @Test
    public void testThat_GetByName_ThrowsException(){
        Exception exception = assertThrows(
            KurumNotFoundException.class,
            ()->{
                kurumService.getByName("test");
            });
            String actualMessage ="Bu bilgilere ait kurum bulunamadı";
            Assertions.assertTrue(actualMessage.contains(exception.getLocalizedMessage()));
    }
    @Test
    public void testThat_GetByIl_ReturnKurum(){
        when(kurumRepository.findByKurumIl(Mockito.anyString())).thenReturn(Optional.ofNullable(List.of(kurumEntity)));
       List<KurumCreateDto> fromDb = kurumService.getByIl("test");

        Assertions.assertNotNull(fromDb);
        Assertions.assertEquals(fromDb.size(),1);
    }
    @Test
    public void testThat_GetByIl_ThrowsException(){
        Exception exception = assertThrows(
            KurumNotFoundException.class,
            ()->{
                kurumService.getByIl("test");
            });
            String actualMessage ="Bu bilgilere ait kurum bulunamadı";
            Assertions.assertTrue(actualMessage.contains(exception.getLocalizedMessage()));
    }
    @Test
    public void testThat_GetMenu_ReturnMenuOfKurum(){
        when(kurumRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(kurumEntity));
        KurumMenuDto response = kurumService.getMenu(0L);

        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.getKurumAdi().equals(kurumEntity.getKurumAdi()));

       
    }
    @Test
    public void testThat_GetMenu_ThrowsException(){
        Exception exception = assertThrows(
            KurumNotFoundException.class,
            ()->{
                kurumService.getMenu(0L);
            });
            String actualMessage ="Bu bilgilere ait kurum bulunamadı";
            Assertions.assertTrue(actualMessage.contains(exception.getLocalizedMessage()));
    }
    
}
