package com.nextstep.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Race {
    private int moveLimit;
    private List<Car> cars = new ArrayList<>();
    private static final int THRESHOLD = 3;

    public Race(int carCount, int moveLimit) {
        this.moveLimit = moveLimit;
        for ( int ix = 0 ; ix < carCount ; ix ++ ) {
            cars.add(new Car());
        }
    }

    public List<Car> moveAndGet(Supplier<Integer> numberGenerator) {
        for (Car car : cars) {
            int number = numberGenerator.get();
            tryMove(car, number);
        }
        return cars;
    }

    private void tryMove(Car car, int number) {
        if (isMove(number)) {
            car.move();
        }
    }

    private boolean isMove(int number) {
        return THRESHOLD < number;
    }

    public boolean isNotFinished() {
        boolean isNotFinished = true;
        for ( Car car : cars) {
            isNotFinished = isNotFinished && car.isNotFinished(moveLimit);
        }
        return isNotFinished;
    }
}
