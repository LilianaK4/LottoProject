package pl.lotto.domain.numberreceiver;

import org.junit.jupiter.api.Test;
import pl.lotto.domain.numberreceiver.dto.InputNumbersResultDto;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


class NumberReceiverFacadeTest {

    NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacade(new NumberValidator());

    @Test
    public void it_should_return_success_when_user_input_six_numbers_in_range() {
        //given
        Set<Integer> numbersFromUser = Set.of(1, 2, 3, 4, 5, 6);
        //when
        InputNumbersResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        assertThat(result.message()).isEqualTo("success");
    }

    @Test
    public void it_should_return_failed_when_user_input_at_least_one_number_out_of_range() {
        //given
        Set<Integer> numbersFromUser = Set.of(1, 2, 3, 4, 5, 600);
        //when
        InputNumbersResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        assertThat(result.message()).isEqualTo("failed");
    }

    @Test
    public void it_should_return_failed_when_user_input_less_than_six_numbers() {
        //given
        Set<Integer> numbersFromUser = Set.of(1, 2, 3, 4, 5);
        //when
        InputNumbersResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        assertThat(result.message()).isEqualTo("failed");
    }

    @Test
    public void it_should_return_failed_when_user_input_more_than_six_numbers() {
        //given
        Set<Integer> numbersFromUser = Set.of(1, 2, 3, 4, 5, 6, 7);
        //when
        InputNumbersResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        assertThat(result.message()).isEqualTo("failed");
    }


}