package com.proje.yemekapp.Utils.Exceptions.MenuExceptions;

/**
 * Menüye verilen tarih o içimizde bulunduğumuz yılda değilse verilen hata
 */
public class MenuDateHasExpired  extends RuntimeException{
    public MenuDateHasExpired(){
        super("Lütfen Geçerli Bir Tarih Giriniz");
    }
    
}