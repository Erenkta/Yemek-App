package com.proje.yemekapp.Utils.Exceptions.KurumExceptions;

public class KurumNotFoundException extends RuntimeException {

    public KurumNotFoundException(){
        super("Bu bilgilere ait kurum bulunamadı"); // TODO Bilgilerin ne olduğunu da belirt
    }
    
}
