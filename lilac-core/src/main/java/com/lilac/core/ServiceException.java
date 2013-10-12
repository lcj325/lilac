package com.lilac.core;

/**
 * @author andy
 * @since 2013-5-16
 */
@SuppressWarnings("serial")
public class ServiceException extends RuntimeException {

    public ServiceException(){
        super();
    }

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(Throwable cause){
        super(cause);
    }

    public ServiceException(String message, Throwable cause){
        super(message, cause);
    }
}