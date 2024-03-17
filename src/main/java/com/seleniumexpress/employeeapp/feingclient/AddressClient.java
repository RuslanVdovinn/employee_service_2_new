package com.seleniumexpress.employeeapp.feingclient;

import com.seleniumexpress.employeeapp.dto.AddressDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//http://localhost:8081/address-app/api/address/1
@FeignClient(name = "address-service", url = "http://localhost:8081", path = "/address-app/api/")
//@RibbonClient(name = "address-service")
public interface AddressClient { //proxy

    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressDTO> getAddressByEmployeeId(@PathVariable("employeeId") int id);
}
