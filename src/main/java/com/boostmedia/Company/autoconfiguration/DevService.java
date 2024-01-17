package com.boostmedia.Company.autoconfiguration;

import org.springframework.stereotype.Service;

//@Service
public class DevService {
    String name;

    DevService() {
        this.name = "forDev";
    }

    public String stringdev() {
        return this.name;
    }
}
