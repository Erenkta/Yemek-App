
package com.proje.yemekapp.Utils.Exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.proje.yemekapp.Utils.Exceptions.KurumExceptions.KurumIsNullException;
import com.proje.yemekapp.Utils.Exceptions.KurumExceptions.KurumMenuNotFoundException;
import com.proje.yemekapp.Utils.Exceptions.KurumExceptions.KurumNotFoundException;
import com.proje.yemekapp.Utils.Exceptions.MenuExceptions.MenuNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Tüm Hataların yakalanıp işlendiği class
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
        MethodArgumentNotValidException.class,
        NullPointerException.class,
        KurumIsNullException.class,
        KurumNotFoundException.class,
        KurumMenuNotFoundException.class,
        //Menu Exceptions
        MenuNotFoundException.class,
    })
    ResponseEntity<ApiError> handleExceptions(Exception exception,HttpServletRequest request){
        ApiError error = ApiError.builder()
        .path(request.getRequestURI())
        .build();

        System.out.println(exception);
        

        if(exception instanceof MethodArgumentNotValidException){
            error.setMessage("Hatali Kurum Bilgileri ! Lutfen Tekrar deneyin");
            error.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        else if( //Not Found Exceptions
        exception instanceof KurumIsNullException 
        || exception instanceof KurumMenuNotFoundException 
        || exception instanceof KurumNotFoundException
        || exception instanceof MenuNotFoundException
        ){
            error.setMessage(exception.getLocalizedMessage());
            error.setStatus(HttpStatus.NOT_FOUND.value());
        }
        return ResponseEntity.status(error.getStatus()).body(error);
    }


    
}