package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class PlusService {
	public int plus(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}
}