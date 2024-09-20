package dev.atcx.tiramisu.base.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class CollectionUtils {

    private CollectionUtils() {
        super();
    }

    public static <T> boolean isNotEmpty(final T[] array) {
        return !isEmpty(array);
    }

    public static <T> boolean isEmpty(final T[] array) {
        return array == null || array.length == 0;
    }

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return iterable != null ? StreamSupport.stream(iterable.spliterator(), false).toList() : new ArrayList<>();
    }

}
