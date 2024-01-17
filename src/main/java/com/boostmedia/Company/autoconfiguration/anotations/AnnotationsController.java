package com.boostmedia.Company.autoconfiguration.anotations;

import com.boostmedia.Company.autoconfiguration.DevService;
import com.boostmedia.Company.autoconfiguration.ProdService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/anotations/")
public class AnnotationsController {

    DevService devService;
    ProdService prodService;
    AnnotationsController(){
       // this.devService = devService;
      //  this.prodService = prodService;
    }

}
