package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {

    private List<Predicate<T>> listPredicates = new ArrayList<>();

    public boolean isValid(T value) {
        for (var pred : listPredicates) {
            if (!pred.test(value)) {
                return false;
            }
        }
        return true;
    }

    protected void addPredicate(Predicate<T> predicate) {
        listPredicates.add(predicate);
    }
}
