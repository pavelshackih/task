package org.example.task2.model;

import java.util.HashSet;
import java.util.Set;

public class Result {

    private Set<String> unique = new HashSet<>();
    private Set<String> duplicate = new HashSet<>();

    public void next(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        if (unique.contains(word)) {
            unique.remove(word);
            duplicate.add(word);
        } else {
            unique.add(word);
        }
    }

    public void merge(Result result) {
        for (String s : result.duplicate) {
            next(s);
        }
        for (String s : result.unique) {
            next(s);
        }
    }

    public Set<String> getUnique() {
        return unique;
    }

    public Set<String> getDuplicate() {
        return duplicate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (unique != null ? !unique.equals(result.unique) : result.unique != null) return false;
        return duplicate != null ? duplicate.equals(result.duplicate) : result.duplicate == null;
    }

    @Override
    public int hashCode() {
        int result = unique != null ? unique.hashCode() : 0;
        result = 31 * result + (duplicate != null ? duplicate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "unique=" + unique +
                ", duplicate=" + duplicate +
                '}';
    }
}
