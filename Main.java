import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;
import java.util.List;

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
    }
}
