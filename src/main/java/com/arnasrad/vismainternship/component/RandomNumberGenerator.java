package com.arnasrad.vismainternship.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Random;

@Component
public class RandomNumberGenerator {

    @Autowired
    private Random random;

    public int generateRandomIntInRange(int min, int max) {

        return random.ints(min, (max + 1)).findFirst().orElseThrow(NoSuchElementException::new);
    }
}
