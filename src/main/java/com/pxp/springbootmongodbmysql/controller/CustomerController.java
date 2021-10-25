package com.pxp.springbootmongodbmysql.controller;

import com.pxp.springbootmongodbmysql.model.CustomerModel;
import com.pxp.springbootmongodbmysql.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService studentService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }


    @RequestMapping(value = "readresources", method = RequestMethod.GET)
    public String insertDBData(){
        return studentService.insertData();
    }

}
