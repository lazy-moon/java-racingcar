package com.nextstep.racingcar;

import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Car {
    private static final int THRESHOLD = 3;
    private static final String DASH = "-";

    private CarName name;
    private int position = 0;
    private Supplier<Integer> numberGenerator;

    public Car(CarName name, Supplier<Integer> numberGenerator) {
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public void tryMove() {
        int number = numberGenerator.get();
        if (isMove(number)) {
            position++;
        }
    }

    private boolean isMove(int number) {
        return THRESHOLD < number;
    }

    public boolean equalsPosition(Car other) {
        return this.position == other.position;
    }

    private boolean compareTo(Car other) {
        return this.position < other.position;
    }

    public Car compareAndGet(Car other) {
        return (this.compareTo(other)) ? other : this;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    public String toDetailString() {
        return name + " : " + makeDashes();
    }

    private String makeDashes() {
        return Stream.generate(() -> DASH)
                .limit(position)
                .collect(Collectors.joining());
    }
}
