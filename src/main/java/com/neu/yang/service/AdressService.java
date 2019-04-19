package com.neu.yang.service;

import com.neu.yang.model.Adress;

import java.util.List;

public interface AdressService {
    List<Adress> findAdress(String user);
}
