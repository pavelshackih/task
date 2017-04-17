package org.example.task2;

import org.example.task2.model.Book;
import org.example.task2.model.Result;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WordCounterTaskTest {

    @Test
    public void compute() throws Exception {
        Result expected = new Result();
        expected.getDuplicate().add("asd");
        expected.getUnique().add("vba");
        expected.getUnique().add("zxc");
        expected.getUnique().add("vbn");

        Book book1 = new Book("asd vba asd");
        Book book2 = new Book("zxc vbn asd");
        Book lib = new Book(Arrays.asList(book1, book2));

        ForkJoinPool pool = new ForkJoinPool();
        Result actual = pool.invoke(new WordCounterTask(lib));

        assertThat(actual, is(expected));
    }
}