package com.seleniumexpress.employeeapp.service;

import com.seleniumexpress.employeeapp.dto.AddressDTO;
import com.seleniumexpress.employeeapp.dto.EmployeeDTO;
import com.seleniumexpress.employeeapp.entity.Employee;
import com.seleniumexpress.employeeapp.feingclient.AddressClient;
import com.seleniumexpress.employeeapp.repo.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    private final ModelMapper modelMapper;

    private final AddressClient addressClient;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo, ModelMapper modelMapper, AddressClient addressClient) {
        this.employeeRepo = employeeRepo;
        this.modelMapper = modelMapper;
        this.addressClient = addressClient;
    }

    public EmployeeDTO getEmployeeById(int id) {

        Employee employee = employeeRepo.findById(id).get();

        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);

        ResponseEntity<AddressDTO> response = addressClient.getAddressByEmployeeId(id);

        AddressDTO addressDTO = response.getBody();

        employeeDTO.setAddressDTO(addressDTO);

        return employeeDTO;
    }
}
