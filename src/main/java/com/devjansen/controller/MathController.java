package com.devjansen.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UnknownFormatConversionException;

@RestController
@RequestMapping("/math")
public class MathController {

    //http://localhost:8080/math/sum/3/2
    //http://localhost:8080/math/subtraction/3/2
    //http://localhost:8080/math/multiplication/3/2
    //http://localhost:8080/math/division/3/2
    //http://localhost:8080/math/mean/3/2

    //http://localhost:8080/math/sum/3/2
    @RequestMapping("/sum/{a}/{b}")
    public Double sum(@PathVariable("a") String a, @PathVariable("b") String b) throws IllegalArgumentException {
        if(!isNumeric(a) || !isNumeric(b)) throw new UnknownFormatConversionException("Please set a numeric value");
        return convertToDouble(a) + convertToDouble(b);
    }

    //http://localhost:8080/math/subtraction/3/2
    @RequestMapping("/subtraction/{a}/{b}")
    public Double subtraction(@PathVariable("a") String a, @PathVariable("b") String b) throws IllegalArgumentException {
        if(!isNumeric(a) || !isNumeric(b)) throw new UnknownFormatConversionException("Please set a numeric value");
        return convertToDouble(a) - convertToDouble(b);
    }

    //http://localhost:8080/math/multiplication/3/2
    @RequestMapping("/multiplication/{a}/{b}")
    public Double multiplication(@PathVariable("a") String a, @PathVariable("b") String b) throws IllegalArgumentException {
        if(!isNumeric(a) || !isNumeric(b)) throw new UnknownFormatConversionException("Please set a numeric value");
        return convertToDouble(a) * convertToDouble(b);
    }

    //http://localhost:8080/math/division/3/2
    @RequestMapping("/division/{a}/{b}")
    public Double division(@PathVariable("a") String a, @PathVariable("b") String b) throws IllegalArgumentException {
        if(!isNumeric(a) || !isNumeric(b)) throw new UnknownFormatConversionException("Please set a numeric value");
        return convertToDouble(a) / convertToDouble(b);
    }

    //http://localhost:8080/math/mean/3/2
    @RequestMapping("/mean/{a}/{b}")
    public Double mean(@PathVariable("a") String a, @PathVariable("b") String b) throws IllegalArgumentException {
        if(!isNumeric(a) || !isNumeric(b)) throw new UnknownFormatConversionException("Please set a numeric value");
        return (convertToDouble(a) + convertToDouble(b))/2;
    }

    private Double convertToDouble(String strNumber) throws IllegalArgumentException {
        if(strNumber == null || strNumber.isEmpty()) throw new UnknownFormatConversionException("Please set a numeric value");
        String number = strNumber.replace(",",".");
        return Double.parseDouble(number);
    }

    //verifica se é um numero
    private Boolean isNumeric(String strNumber){
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }


}
