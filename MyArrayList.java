import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

interface MyList<E>{ 

    public void add(E x); 
    public void add(List<E> lst); 
    public boolean forAll(Predicate<E> pr); 
    public boolean exists(Predicate<E> pr); 
    public long count(Predicate<E> pr); 
    public List<E> map(Function<E,E> fn); 
    public List<E> filter(Predicate<E> pr); 
    public List<E> mapFilter(Function<E,E> fn, Predicate<E> pr); 
} 
    
public class MyArrayList<E> implements MyList<E> {
    private final ArrayList<E> data = new ArrayList<>();
    
    @Override
    public synchronized void add(E x) {
        data.add(x);
    }

    @Override
    public synchronized void add(List<E> lst) {
        data.addAll(lst);
    }

    @Override
    public boolean forAll(Predicate<E> pr) {
        synchronized (data) {
            return data.parallelStream().allMatch(pr);
        }
    }

    @Override
    public boolean exists(Predicate<E> pr) {
        synchronized (data) {
            return data.parallelStream().anyMatch(pr);
        }
    }

    @Override
    public long count(Predicate<E> pr) {
        synchronized (data) {
            return data.parallelStream().filter(pr).count();
        }
    }

    @Override
    public List<E> map(Function<E, E> fn) {
        synchronized (data) {
            return data.parallelStream().map(fn).collect(Collectors.toList());
        }
    }

    @Override
    public List<E> filter(Predicate<E> pr) {
        synchronized (data) {
            return data.parallelStream().filter(pr).collect(Collectors.toList());
        }
    }

    @Override
    public List<E> mapFilter(Function<E, E> fn, Predicate<E> pr) {
        synchronized (data) {
            return data.parallelStream().filter(pr).map(fn).collect(Collectors.toList());
        }
    }
}
