package exercises.section07;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpperCaserTest {
    private UpperCaser uc = new UpperCaser();;
    private String input, output, expectedOutput;

    @Test
    public void ReturnsEmptyForEmptyInput() {
        input = "";
        expectedOutput = "";
        output = uc.createOutputFor(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void ReturnsUnchangedForOneLetter() {
        input = "a";
        expectedOutput = "a";
        output = uc.createOutputFor(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void ReturnsSecondLetterUppercasedForTwoLetters() {
        input = "ab";
        expectedOutput = "aB";
        output = uc.createOutputFor(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void PassesExampleTestA() {
        input = "cat";
        expectedOutput = "cAt";
        output = uc.createOutputFor(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void PassesExampleTestB() {
        input = "apple";
        expectedOutput = "aPpLe";
        output = uc.createOutputFor(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void DoesntExplodeIfContainsNumbers() {
        input = "hohoho1hohoho";
        expectedOutput = "hOhOhO1HoHoHo";
        output = uc.createOutputFor(input);
        assertEquals(expectedOutput, output);
    }
}
