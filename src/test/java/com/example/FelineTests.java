package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

public class FelineTests {

    @Test
    public void getFamilyIsCorrect() {
        String expectedFelineFamilyName = "Кошачьи";

        MatcherAssert.assertThat("Некорректное название семейства кошачьих",
                new Feline().getFamily(),
                equalTo(expectedFelineFamilyName)
        );
    }

    @Test
    public void getKittensInputCountIsCorrect() {
        int expectedCount = 5;

        MatcherAssert.assertThat("Некорректное количество котят",
                new Feline().getKittens(expectedCount),
                equalTo(expectedCount)
        );
    }

    @Test
    public void getKittensDefaultIsCorrect() {
        int expectedCount = 1;

        MatcherAssert.assertThat("Некорректное количество котят",
                new Feline().getKittens(),
                equalTo(expectedCount)
        );
    }

    @Test
    public void eatMeatIsCorrect() throws Exception {
        Feline feline = new Feline();

        MatcherAssert.assertThat("Неправильный список еды",
                feline.eatMeat(),
                equalTo(List.of("Животные", "Птицы", "Рыба"))
        );
    }

    @Test
    public void getFoodHerbivoreIsCorrect() throws Exception {
        Animal animal = new Animal();

        MatcherAssert.assertThat(
                animal.getFood("Травоядное"),
                equalTo(List.of("Трава", "Различные растения"))
        );
    }

    @Test(expected = Exception.class)
    public void getFoodThrowsException() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Неизвестно");
    }
}
