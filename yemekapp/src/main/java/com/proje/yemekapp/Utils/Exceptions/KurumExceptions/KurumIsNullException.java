
package com.proje.yemekapp.Utils.Exceptions.KurumExceptions;

public class KurumIsNullException extends RuntimeException {
    
    public KurumIsNullException(){
        super("Kurum bilgisi boş bırakılamaz");
    }
}