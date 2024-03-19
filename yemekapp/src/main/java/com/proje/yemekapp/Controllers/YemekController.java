package com.proje.yemekapp.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proje.yemekapp.Entities.Yemek.Dtos.YemekCreateDto;
import com.proje.yemekapp.Services.concretes.YemekService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequiredArgsConstructor
public class YemekController {

    private final YemekService yemekService;
    

    @PostMapping("/api/v1/{menuId}/yemek")
    public String createYemek(@RequestBody YemekCreateDto yemekDto , @PathVariable Long menuId) {
        return yemekService.createYemek(yemekDto, menuId);
    }
    @RequestMapping(path = "/api/v1/yemek", method=RequestMethod.GET,params = {"yemekId"})
    public ResponseEntity<YemekCreateDto> getById(@RequestParam(name = "yemekId") Long yemekId) {
        return ResponseEntity.status(HttpStatus.FOUND).body(yemekService.getById(yemekId));
    }
    @RequestMapping(path = "/api/v1/yemek", method=RequestMethod.GET,params = {"yemekAdi"})
    public ResponseEntity<YemekCreateDto> getByName(@RequestParam(name = "yemekAdi") String yemekAdi) {
        return ResponseEntity.status(HttpStatus.FOUND).body(yemekService.getByYemekAdi(yemekAdi));
    }
    @GetMapping("/api/v1/yemek/vegan")
    public ResponseEntity<List<YemekCreateDto>> getAllVeganYemek() {
        return ResponseEntity.status(HttpStatus.OK).body(yemekService.getByVegan());
    }
    @GetMapping("/api/v1/yemek/vejeteryan")
    public ResponseEntity<List<YemekCreateDto>> getAllVejeteryanYemek() {
        return ResponseEntity.status(HttpStatus.OK).body(yemekService.getByVejeteryan());
    }

    
    
    
    
    
}
