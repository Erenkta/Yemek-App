package com.proje.yemekapp.Utils.Exceptions.KurumExceptions;

public class KurumCannotFoundException extends RuntimeException {

    public KurumCannotFoundException(){
        super("Bu bilgilere ait kurum bulunamadı"); // TODO Bilgilerin ne olduğunu da belirt
    }
    
}
