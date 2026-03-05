package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {
    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }
    public NumberSchema positive() {
        addValidation("positive", s -> s == null || s > 0);
        return this;
    }
    public NumberSchema range(int start, int end) {
        addValidation("range", s -> (s >= start && s <= end));
        return this;
    }
}
