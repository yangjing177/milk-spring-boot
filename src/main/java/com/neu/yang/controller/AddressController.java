package com.neu.yang.controller;

import com.neu.yang.model.Address;
import com.neu.yang.model.Car;
import com.neu.yang.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @ResponseBody
    @PostMapping("/list")
    public List<Address> addressList(@RequestBody String user) {
        List<Address> list=addressService.findAddress(user);
        return list;
    }

    @ResponseBody
    @PostMapping("/update")
    public void update(@RequestBody Address address) {
        addressService.update(address);
        List<Address> list = addressService.findAddress(address.getUserName());
        for(Address addr:list){
            if(addr.getDefaultAddress()==0&&address.getId()!=addr.getId()){
                addr.setDefaultAddress(1);
                addressService.update(addr);
            }
        }
    }

    @ResponseBody
    @PostMapping("/insert")
    public void insert(@RequestBody Address address) {
        int addId=addressService.findMaxId();
        address.setIsDeleted(0);
        addressService.save(address);
        List<Address> list = addressService.findAddress(address.getUserName());
        for(Address addr:list){
            if(addr.getDefaultAddress()==0&&addId>=addr.getId()){
                addr.setDefaultAddress(1);
                addressService.update(addr);
            }
        }
    }

    @ResponseBody
    @PostMapping("/delete")
    public void delete(@RequestBody Address address) {
        address.setIsDeleted(1);
        addressService.update(address);
    }
}
