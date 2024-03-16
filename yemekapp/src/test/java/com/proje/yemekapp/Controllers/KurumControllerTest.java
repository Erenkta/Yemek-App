package com.proje.yemekapp.Controllers;

import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proje.yemekapp.TestData;
import com.proje.yemekapp.Entities.Kurum.KurumEntity;
import com.proje.yemekapp.Entities.Kurum.Dtos.KurumCreateDto;
import com.proje.yemekapp.Entities.Kurum.Dtos.KurumMenuDto;
import com.proje.yemekapp.Repositories.KurumRepository;
import com.proje.yemekapp.Services.concretes.KurumService;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class KurumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private KurumRepository kurumRepository;

    @MockBean
    private KurumService kurumService;


    @Autowired
    private ObjectMapper objectMapper;

    private KurumEntity kurumEntity;
    private KurumCreateDto kurumCreateDto;
    private KurumMenuDto kurumMenuDto;

    @BeforeEach
    public void init(){
        kurumEntity = TestData.testKurumEntity();
        kurumCreateDto = TestData.testKurumCreateDto();
        kurumMenuDto = TestData.testKurumMenuDto();
    }

    @Test
    public void testThat_CreateKurumAPI_ReturnsStringAndHttp201() throws Exception{
        given(kurumService.createKurum(Mockito.any(KurumCreateDto.class)))
        .willReturn("Kurum başarıyla oluşturuldu");

        ResultActions result = mockMvc.perform(post("/api/v1/kurum")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(kurumCreateDto)));

        String responseBody = result.andReturn().getResponse().getContentAsString();


        result.andExpect(MockMvcResultMatchers.status().isCreated());
        Assertions.assertThat(responseBody.equals("Kurum başarıyla oluşturuldu"));
    }

    @Test
    public void testThat_CreateKurumAPI_ThrowsException_WhenKurumIsEmpty() throws Exception{
        KurumCreateDto emptyKurum = new KurumCreateDto();

        ResultActions response = mockMvc.perform(post("/api/v1/kurum")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(emptyKurum)));

        response.andExpect(MockMvcResultMatchers.status().isBadRequest());
        response.andExpect(result -> { //MvcResult
            Throwable ex = result.getResolvedException();
            assertTrue(ex instanceof MethodArgumentNotValidException);
        });
    }

    @Test
    public void testThat_GetKurumById_ReturnsKurum() throws Exception{

        when(kurumService.getById(Mockito.anyLong())).thenReturn(kurumCreateDto);
        
        ResultActions response = mockMvc.perform(get("/api/v1/kurum")
        .param("kurumId", "1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(kurumCreateDto)));

        response.andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.jsonPath("$.kurumAdi",CoreMatchers.is(kurumCreateDto.getKurumAdi())));

    }
    @Test
    public void testThat_GetKurumByName_ReturnsKurum() throws Exception{
       
        when(kurumService.getByName(Mockito.anyString())).thenReturn(kurumCreateDto);
        
        ResultActions response = mockMvc.perform(get("/api/v1/kurum")
        .param("kurumAdi", "test")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(kurumCreateDto)));

        response.andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.jsonPath("$.kurumAdi",CoreMatchers.is(kurumCreateDto.getKurumAdi())));
    }
    @Test
    public void testThat_GetKurumByIl_ReturnsKurum() throws Exception{
       
        when(kurumService.getByIl(Mockito.anyString())).thenReturn(List.of(kurumCreateDto));
        
        ResultActions response = mockMvc.perform(get("/api/v1/kurum")
        .param("kurumIl", "test")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(kurumCreateDto)));

        response.andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.jsonPath("$.[0].size()", Matchers.greaterThanOrEqualTo(1)));

    }
    @Test
    public void testThat_GetMenu_ReturnsMenu() throws Exception{
       
        when(kurumService.getMenu(Mockito.anyLong())).thenReturn(kurumMenuDto);
        
        ResultActions response = mockMvc.perform(get("/api/v1/kurum/1/menu")
        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.jsonPath("$.menu", CoreMatchers.notNullValue())); 
       

    }
   
    
}
