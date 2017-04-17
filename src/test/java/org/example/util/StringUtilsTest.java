package org.example.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringUtilsTest {

    @Test(expected = IllegalArgumentException.class)
    public void capitalizeNull() throws Exception {
        StringUtils.capitalize(null);
    }

    @Test
    public void capitalize() {
        assertThat(StringUtils.capitalize(""), is(""));
        assertThat(StringUtils.capitalize("a"), is("A"));
        assertThat(StringUtils.capitalize("ab"), is("Ab"));
        assertThat(StringUtils.capitalize("ABC"), is("Abc"));
    }
}