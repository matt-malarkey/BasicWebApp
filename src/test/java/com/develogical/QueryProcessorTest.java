package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
    public void largestInt() {
        assertThat(queryProcessor.process("67fcfb30: which of the following numbers is the largest: 47, 5, 9, 657"), containsString("657"));
        assertThat(queryProcessor.process("9999: which of the following numbers is the largest: 641, 18"), containsString("641"));
    }

    @Test
    public void plus() {
        // api?q=5076e740:%20what%20is%2010%20plus%2014
        assertThat(queryProcessor.process("448r23e239: what is 10 plus 14"), containsString("24"));
    }
}
