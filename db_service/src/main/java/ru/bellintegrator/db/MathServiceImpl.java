package ru.bellintegrator.db;

import org.springframework.stereotype.Component;

@Component
public class MathServiceImpl implements MathService {
    public int add(int a, int b)
    {
        return a + b;
    }
}
