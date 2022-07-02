package com.poly.service;

import java.util.List;

public interface IGenaralService<T> {
   T insert(T t);
   T update(T t);
   T delete(Integer id);
   List<T> findAll(Integer page);
   
   
}
