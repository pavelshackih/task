package org.example.task2;

import org.example.task2.model.Book;
import org.example.task2.model.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class WordCounterTask extends RecursiveTask<Result> {

    private final Book book;

    WordCounterTask(Book book) {
        this.book = book;
    }

    @Override
    protected Result compute() {
        Result result = new Result();
        // TODO: remove special symbols
        String[] arr = book.getText().split(" ");
        for (String s : arr) {
            result.next(s);
        }
        List<WordCounterTask> tasks = new ArrayList<>();
        for (Book b : book.getChilds()) {
            WordCounterTask task = new WordCounterTask(b);
            task.fork();
            tasks.add(task);
        }
        for (WordCounterTask task : tasks) {
            result.merge(task.join());
        }
        return result;
    }
}