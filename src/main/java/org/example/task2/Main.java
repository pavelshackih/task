package org.example.task2;

import org.example.task2.model.Book;
import org.example.task2.model.Result;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        Book book1 = new Book("asd vba asd");
        Book book2 = new Book("zxc vbn asd");
        Book lib = new Book(Arrays.asList(book1, book2));

        ForkJoinPool pool = new ForkJoinPool();
        Result result = pool.invoke(new WordCounterTask(lib));
        System.out.println("Duplicated: " + result.getDuplicate());
        System.out.println("Unique" + result.getUnique());
    }
}
