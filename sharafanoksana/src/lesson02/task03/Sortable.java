package lesson02.task03;

import java.util.Comparator;

public interface Sortable extends Comparator {
    public Person[] sort() throws Exception;
}
