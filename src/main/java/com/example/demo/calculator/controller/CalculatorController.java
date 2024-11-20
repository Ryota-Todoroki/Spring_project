package com.example.demo.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/calculate")
    public String calculate(
            @RequestParam(name = "num1", required = false, defaultValue = "0") int num1,
            @RequestParam(name = "num2", required = false, defaultValue = "0") int num2,
            @RequestParam(name = "operation", required = false, defaultValue = "add") String operation,
            Model model) {
        try {
            int result;
            switch (operation) {
                case "add":
                    result = calculatorService.add(num1, num2);
                    break;
                case "subtract":
                    result = calculatorService.subtract(num1, num2);
                    break;
                case "multiply":
                    result = calculatorService.multiply(num1, num2);
                    break;
                case "divide":
                    result = calculatorService.divide(num1, num2);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operation: " + operation);
            }
            model.addAttribute("result", result);
        } catch (IllegalArgumentException e) {
            model.addAttribute("result", e.getMessage());
        }
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("operation", operation);
        return "calculator";
    }
}
