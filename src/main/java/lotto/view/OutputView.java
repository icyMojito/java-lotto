package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class OutputView {
    public static final String COMMA = ", ";

    private OutputView() { /* prevent creating OutputView instance */ }

    public static void printLottoNumbers(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        String result = numbers.stream()
                .map(String::valueOf)
                .collect(joining(COMMA));
        StringBuilder sb = new StringBuilder();
        sb.append("[")
                .append(result)
                .append("]");

        System.out.println(sb.toString());
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoCount));
    }
}
