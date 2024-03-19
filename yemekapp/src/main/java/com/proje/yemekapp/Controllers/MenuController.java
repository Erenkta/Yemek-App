package com.proje.yemekapp.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proje.yemekapp.Entities.Menu.Dtos.MenuCreateDto;
import com.proje.yemekapp.Entities.Menu.Dtos.MenuInfoDto;
import com.proje.yemekapp.Services.concretes.MenuService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;







@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/api/v1/{kurumId}/menu")
    public ResponseEntity<String> createMenu(@RequestBody MenuCreateDto menuCreateDto , @PathVariable Long kurumId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(menuService.createMenu(menuCreateDto,kurumId));
    }
    @RequestMapping(path = "/api/v1/menu", method=RequestMethod.GET,params={"menuId"})
    public ResponseEntity<MenuCreateDto> getMenuById(@RequestParam Long menuId) {
        return ResponseEntity.status(HttpStatus.FOUND).body(menuService.getById(menuId));
    }
    @RequestMapping(path = "/api/v1/menu", method=RequestMethod.GET,params={"menuAdi"})
    public ResponseEntity<MenuCreateDto> getMenuByName(@RequestParam String menuAdi) {
        return ResponseEntity.status(HttpStatus.FOUND).body(menuService.getByMenuAdi(menuAdi));
    }
    @RequestMapping(path = "/api/v1/menu", method=RequestMethod.GET,params = {"menuTarih"})
    public ResponseEntity<List<MenuCreateDto>> getMenuByTarih(@RequestParam String menuTarih) {
        return ResponseEntity.status(HttpStatus.FOUND).body(menuService.getByMenuTarih(menuTarih));
    }
    @GetMapping("/api/v1/menu/{menuId}/details")
    public ResponseEntity<MenuInfoDto> getMenuDetails(@PathVariable(name = "menuId") Long menuId) {
        return ResponseEntity.status(HttpStatus.FOUND).body(menuService.getMenuDetail(menuId));
    }
    
    


    
    


    
}