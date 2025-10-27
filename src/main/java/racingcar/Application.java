package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] carNames = InputView.readCarNames();
        int attemptCount = InputView.readAttemptCount();

        RacingGame game = new RacingGame(carNames, attemptCount);
        game.start();
    }
}

