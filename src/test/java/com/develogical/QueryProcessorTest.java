package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsLowerCaseQueryByDefault() throws Exception {
        assertThat(queryProcessor.process("Test"), is("test"));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void name() {
        assertThat(queryProcessor.process("33e3e: name"), containsString("horse"));
    }

    @Test
    public void largestInt() {
        assertThat(queryProcessor.process("67fcfb30: which of the following numbers is the largest: 47, 5, 9, 657"), containsString("657"));
        assertThat(queryProcessor.process("9999: which of the following numbers is the largest: 641, 18"), containsString("641"));
    }

    @Test
    public void plus() {
        assertThat(queryProcessor.process("448r23e239: what is 10 plus 14"), containsString("24"));
    }

    @Test
    public void multiply() {
        assertThat(queryProcessor.process("80f91450: what is 8 multiplied by 3"), containsString("24"));
    }

    @Test
    public void cubeSquare() {
        assertThat(queryProcessor.process("448r23e239: both cube and square 15625, 594, 842, 400"), containsString("15625"));
        assertThat(queryProcessor.process("1139b740: which of the following numbers is both a square and a cube: 13, 81"), containsString("81"));
    }

    @Test
    public void primes() {
        assertThat(queryProcessor.process("62049600: which of the following numbers are primes: 163, 383, 447, 67"), containsString("163,383,67"));
    }

}
