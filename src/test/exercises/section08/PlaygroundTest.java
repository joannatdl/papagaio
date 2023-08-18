package exercises.section08;

import org.junit.jupiter.api.Test;

import static exercises.section08.Playground.getLetterFromOrdinalPositions;
import static exercises.section08.Playground.getOrdinalPositions;
import static org.junit.jupiter.api.Assertions.*;

class PlaygroundTest {
    @Test
    public void TestGetOrdinalPositions() {
        String input = "a, z, w, f, c, h";
        String expectedOutput = "1, 26, 23, 6, 3, 8";
        String output = getOrdinalPositions(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void TestGetLetterFromOrdinalPositions() {
        String expectedOutput = "a, z, w, f, c, h";
        String input = "1, 26, 23, 6, 3, 8";
        String output = getLetterFromOrdinalPositions(input);
        assertEquals(expectedOutput, output);
    }

}