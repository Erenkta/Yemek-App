package com.proje.yemekapp.Utils.Exceptions.YemekExceptions;

public class YemekNotFoundException extends RuntimeException {
    public YemekNotFoundException(){
        super("Bu bilgilere ait yemek bulunamadı");
    }
}
