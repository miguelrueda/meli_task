package com.example.melitask.helper;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

public class ArrayHelperTests {

    @Test
    public void mergeArrayTest_Success() {
        String [] test1 = {"", "es", "", "mensaje", ""};
        String [] test2 = {"este", "", "un", "", "secreto"};
        String [] test3 = {"", "", "un", "mensaje", "secreto"};

        List<String[]> stringLists = List.of(test1, test2, test3);
        String[] merged = ArrayHelper.mergeArrays(stringLists);

        String [] expected = {"este", "es", "un", "mensaje", "secreto"};

        assertThat(merged).isEqualTo(expected);
    }
}
