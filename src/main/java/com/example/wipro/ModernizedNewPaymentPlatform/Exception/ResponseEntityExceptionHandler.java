package com.example.wipro.ModernizedNewPaymentPlatform.Exception;


import com.example.wipro.ModernizedNewPaymentPlatform.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.Date;

@RestControllerAdvice
public class ResponseEntityExceptionHandler {

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<ExceptionResponse> handleAuthException(Exception ex){

        ExceptionResponse response=new ExceptionResponse(new Date(), "Unathorized Exception", ex.getMessage());

        return new ResponseEntity<ExceptionResponse>(response,HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleAccountNotException(Exception ex){

        ExceptionResponse response=new ExceptionResponse(new Date(), "Not_Found Exception", ex.getMessage());

        return new ResponseEntity<ExceptionResponse>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BalanceNotSufficientException.class)
    public ResponseEntity<ExceptionResponse> handlebalanceinsufficientException(Exception ex){

        ExceptionResponse response=new ExceptionResponse(new Date(),
                "BadRequest Exception", ex.getMessage());

        return new ResponseEntity<ExceptionResponse>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception ex){

        ExceptionResponse response=new ExceptionResponse(new Date(),
                "Internal Server Error",ex.getMessage());

        return new ResponseEntity<ExceptionResponse>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
