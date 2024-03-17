package com.proje.yemekapp.Controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proje.yemekapp.Entities.Menu.Dtos.MenuCreateDto;
import com.proje.yemekapp.Services.concretes.MenuService;

import lombok.RequiredArgsConstructor;





@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/api/v1/{kurumId}/menu")
    public MenuCreateDto createMenu(@RequestBody MenuCreateDto menuCreateDto , @PathVariable Long kurumId) {
        return menuService.createMenu(menuCreateDto,kurumId);
    }
    


    
}