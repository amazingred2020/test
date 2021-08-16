package com.senlainc.advice;

public class EntityNotFoundException  extends RuntimeException{
    public EntityNotFoundException(Long id){
        super(String.format("Entity with current id - \"%d\" not found", id));
    }
}
