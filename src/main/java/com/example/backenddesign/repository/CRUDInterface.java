package com.example.backenddesign.repository;

import java.util.List;

public interface CRUDInterface <T>{
    //Create
    public boolean create(T entity);

    //Read
    public T getSingleEntityById();
    public List<T> getAllEntities();

    //Update
    public boolean update(T entity);

    //Delete
    public boolean deleteById(int id);
}