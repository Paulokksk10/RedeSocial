package com.zuiter.services.exception;

public class PostagemNaoEncontradaException extends RuntimeException{
    public PostagemNaoEncontradaException(String message){
        super(message);
    }
}
