package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        addPredicate(s -> s != null);
        return this;
    }
    public NumberSchema positive() {
        addPredicate(s -> s == null || s > 0);
        return this;
    }
    public NumberSchema range(int numb1, int numb2) {
        addPredicate(s -> (s >= numb1 && s <= numb2));
        return this;
    }
}
