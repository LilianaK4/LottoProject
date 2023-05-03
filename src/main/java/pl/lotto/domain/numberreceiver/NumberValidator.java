package pl.lotto.domain.numberreceiver;

import java.util.Set;

class NumberValidator {

    private final int MIN_NUMBER_FROM_USER = 1;
    private final int MAX_NUMBER_FROM_USER = 99;
    private final int EXPECTED_AMOUNT_OF_NUMBERS = 6;

    boolean areAllNumbersInRange(Set<Integer> numbersFromUser) {
        return numbersFromUser.stream()
                .filter(number -> number >= MIN_NUMBER_FROM_USER)
                .filter(number -> number <= MAX_NUMBER_FROM_USER)
                .count() == EXPECTED_AMOUNT_OF_NUMBERS;

    }
}
