package com.proje.yemekapp.Utils.Exceptions.KurumExceptions;

/**
 * Oluşturulan Kurumun henüz menüsü eklenmemişse bu exception throw edilmelidir
 */
public class KurumMenuNotFoundException extends RuntimeException{

    public KurumMenuNotFoundException(){
        super("Bu kuruma ait bir menü bulunamadı");
    }
    
}
