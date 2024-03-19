package com.proje.yemekapp.Utils.Exceptions.MenuExceptions;

/**
 * Menu objesi null geldiğinde dönülecek Hata
 */
public class MenuIsNullException extends RuntimeException {

    public MenuIsNullException(){
        super("Menü bilgisi boş bırakılamaz");
    }
    
}