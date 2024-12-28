package com.div.ecommerce.ecommerce.exception;

import org.springframework.http.HttpStatus;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class ResourceNotFoundException extends ApiException{

//    public ResourceNotFoundException(String message) {
//        super(status, message);
//    }
    public ResourceNotFoundException(String resourceName) {
        super(HttpStatus.NOT_FOUND, String.format("%s With id= %d is not found !",resourceName,id));

    }
}
