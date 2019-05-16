package com.neu.yang.service;

import com.neu.yang.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAddress(String user);
    void update(Address address);
    void save(Address address);
    int findMaxId();
}
