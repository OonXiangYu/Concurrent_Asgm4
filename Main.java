import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    private static ScoreInformation[] scoreData = new ScoreInformation[] { 
        new ScoreInformation("Maguire","John",70), 
        new ScoreInformation("Farell","Mary",85), 
        new ScoreInformation("Konsilla","Alice",82), 
        new ScoreInformation("Dunne","Jill",97), 
        new ScoreInformation("Burns","Geread",66), 
        new ScoreInformation("Kelly","Philip",80), 
        new ScoreInformation("Murphy","Judy",48), 
        new ScoreInformation("Doyle ","James",90), 
        new ScoreInformation("Walsh ","Joe",55), 
        new ScoreInformation("Byrne ","Bill",73), 
        new ScoreInformation("O'Sullivan","Mary",54), 
        new ScoreInformation("Rogers","Chris",78), 
        new ScoreInformation("O'Toole","Pat",51), 
        new ScoreInformation("Ryan","Aisling",93), 
        new ScoreInformation("Mc Carthy","Ann",95) 
        }; 

    public static void main(String[] args){

        System.out.println("Question 1\n");

        // Number of student
        long numberOfStudents = Stream.of(scoreData).count();
        System.out.println("Number of students: " + numberOfStudents);

        // Average Score
        OptionalDouble avgScore = Stream.of(scoreData).mapToInt(student -> student.score).average();
        System.out.printf("Average score of students %.2f \n" ,avgScore.getAsDouble());

        // Number of student who get A
        long numberOfA = Stream.of(scoreData).filter(student -> student.score >= 90).count();
        System.out.println("Number of students who get A :" + numberOfA);

        // Students who gets lower than 70
        List<String> studentsLower70 = Stream.of(scoreData).filter(student -> student.score < 70).map(student -> student.firstName + " " + student.lastName).collect(Collectors.toList());
        System.out.println("Students who score lower than 70 : " + studentsLower70);

        System.out.println("-----------------------");

        // Students order by last name
        Stream.of(scoreData).sorted(Comparator.comparing(student -> student.lastName)).forEach( student -> System.out.println(student.firstName + " " + student.lastName + " : " + student.score));

        System.out.println("-----------------------");

        // Students order by scores
        Stream.of(scoreData).sorted(Comparator.comparing(student -> student.score)).forEach( student -> System.out.println(student.firstName + " " + student.lastName + " : " + student.score));

        System.out.println("\nQuestion 2\n");

        MyList<Integer> data = new MyArrayList<>();
        
         // Test add(E x)
         data.add(1);
         data.add(2);
         data.add(3);

        // Test add(List<E> lst)
        data.add(Arrays.asList(4, 5, 6));

        // Test forAll(Predicate<E> pr) and exists(Predicate<E> pr)
        Predicate<Integer> var1 = x -> x > 0;
        Predicate<Integer> var2 = x -> x > 3;
        System.out.println("All elements is positive: " + data.forAll(var1));
        System.out.println("Exists an element > 3: " + data.exists(var2));

        //Test count(Predicate<E> pr)
        System.out.println("Amount of elements thats are positive : " + data.count(var1));

        // Test map(Function<E, E> fn)
        Function<Integer, Integer> square = x -> x * x;
        List<Integer> squaredList = data.map(square);
        System.out.println("Squared List: " + squaredList);

        // Test filter(Predicate<E> pr)
        System.out.println("All elements is positive: " + data.filter(var1));

        // Test mapFilter(Function<E, E> fn, Predicate<E> pr)
        System.out.println("The elements which > 3 then get the squared of it : " + data.mapFilter(square, var2));

    }
}
