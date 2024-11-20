package com.example.demo.minus.service;

import org.springframework.stereotype.Service;

@Service
public class MinusService {
    public int subtract(int num1, int num2) {
        return num1 - num2;
    }
}
