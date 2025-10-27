package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int attemptCount;

    public RacingGame(String[] carNames, int attemptCount){
        this.cars = createCars(carNames);
        this.attemptCount = attemptCount;
    }

    private List<Car> createCars(String[] carNames){
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            name = name.trim();
            if (name.length() > 5 || name.isEmpty()){
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다");
            }
            carList.add(new Car(name));
        }
        return carList;
    }

    public void start(){
        System.out.println(); // 빈 줄
        System.out.println("실행 결과");

        for (int i = 0; i < attemptCount; i++){
            moveAllCars();
            printRoundResult();
            System.out.println();
        }

        printWinners();
    }

    private void moveAllCars(){
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    private void printRoundResult(){
        for (Car car : cars){
            String bar = "-".repeat(car.getPosition());
            System.out.println(car.getName() + " : " + bar);
        }
    }
}
