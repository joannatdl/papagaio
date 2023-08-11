package exercises.section07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpoonerTest {
    String input;
    String expectedOutput;
    String output;


    @Test
    public void ReturnsEmptyStringForEmptyInput() {
        input = "";
        expectedOutput = "";
        output = Spooner.transpose(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void ReturnTheSameWordForSingleWordInput() {
        input = "hello";
        expectedOutput = "hello";
        output = Spooner.transpose(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void ReturnsTransposedStringsExampleA() {
        input = "sound bite";
        expectedOutput = "bound site";
        output = Spooner.transpose(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void ReturnsTransposedStringsExampleB() {
        input = "flat cap";
        expectedOutput = "cat flap";
        output = Spooner.transpose(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void ReturnsTransposedStringsExampleC() {
        input = "crushing blow";
        expectedOutput = "blushing crow";
        output = Spooner.transpose(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void ReturnsTransposedStringsExampleD() {
        input = "sad ballad";
        expectedOutput = "bad sallad";
        output = Spooner.transpose(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void ReturnsTransposedStringsExampleE() {
        input = "master plan";
        expectedOutput = "plaster man";
        output = Spooner.transpose(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void ReturnsTransposedStringsExampleF() {
        input = "trail snacks";
        expectedOutput = "snail tracks";
        output = Spooner.transpose(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    public void ReturnsTransposedStringsExampleG() {
        input = "crushing blow";
        expectedOutput = "blushing crow";
        output = Spooner.transpose(input);
        assertEquals(expectedOutput, output);
    }


}
