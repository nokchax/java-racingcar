package racingcar.car;

import racingcar.dto.CarDto;
import racingcar.strategy.MoveStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    public static final int MINIMUM_NUMBER_OF_CARS = 1;

    private final List<Car> cars;

    public Cars(int numberOfCars, MoveStrategy moveStrategy) {
        validate(numberOfCars, moveStrategy);

        cars = Stream.generate(() -> Car.from(moveStrategy))
                .limit(numberOfCars)
                .collect(Collectors.toList());
    }

    private void validate(int numberOfCars, MoveStrategy moveStrategy) {
        if (numberOfCars < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("Number of cars can't be under 1");
        }

        if (Objects.isNull(moveStrategy)) {
            throw new IllegalArgumentException("MoveStrategy can't be null");
        }
    }

    public void moveCars() {
        cars.forEach(Car::move);
    }

    public List<CarDto> getCarDtos() {
        return cars.stream()
                .map(CarDto::from)
                .collect(Collectors.toList());
    }
}
