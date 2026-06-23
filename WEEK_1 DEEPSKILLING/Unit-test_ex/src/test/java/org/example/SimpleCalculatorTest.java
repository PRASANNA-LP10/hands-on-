package org.example;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SimpleCalculatorTest {
    SimpleCalculator calculator;

    @BeforeEach
    void setUp(){
        calculator=new SimpleCalculator();
    }


    @DisplayName("test for add")
    @ParameterizedTest
    @CsvSource({
            "2,2",
            "2,3",
            "3,5",
            "7,9"
    })
    @Order(1)
    void additionoftwonums(int a,int b){
        int res;
        res=a+b;
        assertEquals(res,calculator.sum(a,b));
    }

    @Test
    @Order(3)
    void threePlusSevelEqualsTen(){
        assertEquals(4,calculator.sum(3,7));
    }

    @Test
    @Order(2)
    void threeMulThreeEqualsNine(){

        assertEquals(9,calculator.mul(3,3),"3*3=9");
    }
    @ParameterizedTest
    @Order(4)
    @ValueSource(ints={10,40,0,3})
    void divisionTestThrowsException(int a){
        Exception e=assertThrows(ArithmeticException.class,()->{
            calculator.div(a,0);
        });

        System.out.println(e.getMessage());
    }


    @AfterEach
    void tearDown(){
        calculator=null;
    }


    @ParameterizedTest
    @Order(5)
    @ValueSource(ints={20,17,30,40})
    void ageChecker(int age){
        assertTrue(age>18);
    }
}