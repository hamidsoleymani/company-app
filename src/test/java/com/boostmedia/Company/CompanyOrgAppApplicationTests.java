package com.boostmedia.Company;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class CompanyOrgAppApplicationTests {

    int a[] = {2, 3};
List<Integer> aa=  List.of(1,3);
    List<Integer> ab= List.of(1,3);
    @Test
    void contextLoads() {
        assertArrayEquals(a, new int[]{2, 3});
        assertIterableEquals(aa, ab);
    }


    @Test
    void save() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("1a");
        });
        String actualMessage = exception.getMessage();
    }
}
