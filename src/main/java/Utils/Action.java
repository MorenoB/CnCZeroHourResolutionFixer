package Utils;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Action<T> {
    private final Set<Consumer<T>> listeners = new HashSet();

    public void addListener(Consumer<T> listener) {
        listeners.add(listener);
    }

    public void broadcast(T args) {
        listeners.forEach(x -> x.accept(args));
    }
}
