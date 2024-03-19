package com.proje.yemekapp.Utils.Exceptions.MenuExceptions;

public class MenuNotFoundException extends RuntimeException {

    public MenuNotFoundException(){
        super("Bu bilgilere ait bir menü bulunamadı");
    }
    
}
