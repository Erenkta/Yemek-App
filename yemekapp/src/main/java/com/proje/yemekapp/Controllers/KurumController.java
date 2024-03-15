package com.proje.yemekapp.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proje.yemekapp.Entities.Kurum.Dtos.KurumCreateDto;
import com.proje.yemekapp.Entities.Kurum.Dtos.KurumMenuDto;
import com.proje.yemekapp.Services.concretes.KurumService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;





@RestController
@RequiredArgsConstructor

public class KurumController {
    
    private final KurumService kurumService;

    @PostMapping("/api/v1/kurum")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> createKurum(@RequestBody @Valid KurumCreateDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(kurumService.createKurum(dto));
    }

    @RequestMapping(method = RequestMethod.GET,value = "/api/v1/kurum", params={"kurumId"})
    public ResponseEntity<KurumCreateDto> getKurumById(@RequestParam(name = "kurumId") Long kurumId) {
        return ResponseEntity.status(HttpStatus.FOUND).body(kurumService.getById(kurumId));
    }
    
    @RequestMapping(method = RequestMethod.GET,value = "/api/v1/kurum", params={"kurumAdi"})
    public ResponseEntity<KurumCreateDto> getKurumByAd(@RequestParam(name = "kurumAdi") String kurumAdi) {
        return ResponseEntity.status(HttpStatus.FOUND).body(kurumService.getByName(kurumAdi));
    }
    
    @RequestMapping(method = RequestMethod.GET,value = "/api/v1/kurum", params={"kurumIl"})
    public ResponseEntity<List<KurumCreateDto>> getKurumByIl(@RequestParam(name = "kurumIl") String kurumIl) {
        return ResponseEntity.status(HttpStatus.FOUND).body(kurumService.getByIl(kurumIl));
    }

    @GetMapping("/api/v1/kurum/{id}/menu")
    public ResponseEntity<KurumMenuDto> getMenuByKurumId(@PathVariable(name = "id") Long kurumId) {
       return ResponseEntity.status(HttpStatus.FOUND).body(kurumService.getMenu(kurumId));
    }
    
    
    
    


}
