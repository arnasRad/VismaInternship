package com.arnasrad.vismainternship.service.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Random;

@Component
public class RandomNumberGeneratorService {

    private final Random random;

    @Autowired
    public RandomNumberGeneratorService(Random random) {
        this.random = random;
    }

    public int generateRandomIntInRange(int min, int max) {

        return random.ints(min, (max + 1)).findFirst().orElseThrow(NoSuchElementException::new);
    }
}
