package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int NUMBER_COUNT_PER_LOTTO = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final List<Integer> allLottoNumbers;

    static {
        allLottoNumbers = gatherAllNumbers();
    }

    private static List<Integer> gatherAllNumbers() {
        List<Integer> allLottoNumbers = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            allLottoNumbers.add(i);
        }
        return allLottoNumbers;
    }

    public static List<Lotto> generate(int lottoCount) {
        List<Lotto> randomLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            randomLottos.add(new Lotto(generateLottoNumbers()));
        }
        return randomLottos;
    }

    private static List<Integer> generateLottoNumbers() {
        List<Integer> cloneAllLottoNumbers = new ArrayList<>();
        cloneAllLottoNumbers.addAll(allLottoNumbers);
        Collections.shuffle(cloneAllLottoNumbers);
        List<Integer> resultNumbers = pickLottoNumbers(cloneAllLottoNumbers);
        Collections.sort(resultNumbers);
        return resultNumbers;
    }

    private static List<Integer> pickLottoNumbers(List<Integer> cloneAllLottoNumbers) {
        List<Integer> resultNumbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_COUNT_PER_LOTTO; i++) {
            resultNumbers.add(cloneAllLottoNumbers.get(i));
        }
        return resultNumbers;
    }
}
