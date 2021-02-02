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
        assertThat(queryProcessor.process("which of the following numbers is the largest: 47, 5, 9, 657"), containsString("657"));
    }

    @Test
    public void addNumbers() {
        assertThat(queryProcessor.process("what is 15 plus 35"), containsString("50"));
    }
}
