package pl.lotto.domain.numberreceiver;

import lombok.AllArgsConstructor;
import pl.lotto.domain.numberreceiver.dto.InputNumbersResultDto;

import java.util.Set;

@AllArgsConstructor
public class NumberReceiverFacade {

    private final NumberValidator validator;

    public InputNumbersResultDto inputNumbers(Set<Integer> numbersFromUser) {
        boolean areAllNumbersInRange = validator.areAllNumbersInRange(numbersFromUser);
        if(areAllNumbersInRange)
            return InputNumbersResultDto.builder()
                    .message("success")
                    .build();
        else
            return InputNumbersResultDto.builder()
                    .message("failed")
                    .build();
    }


}
