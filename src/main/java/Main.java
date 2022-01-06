
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("One");
    list.add("Two");
    list.add("Three");
    list.add("Four");
    list.add("Five");

    //map
    System.out.println("---map---");
    List<Integer> collect = list.stream().map(String::length).collect(Collectors.toList());
    collect.forEach(System.out::println);

    //filter, forEach
    System.out.println("---filter, forEach---");
    Student student1 = new Student("Ivan", 'm', 22, 3, 8.3);
    Student student2 = new Student("Elena", 'f', 18, 1, 5);
    Student student3 = new Student("Andrej", 'm', 26, 2, 3);
    Student student4 = new Student("Dima", 'm', 40, 5, 10);
    Student student5 = new Student("Oksana", 'f', 38, 2, 4);
    Student student6 = new Student("Anton", 'm', 26, 4, 7);
    List<Student> students = List.of(student1, student2, student3, student4, student5, student6);

    students.stream().filter((s) -> s.getAge() > 18 && s.getSex() == 'm')
        .forEach(System.out::println);

    //reduce, isPresent
    System.out.println("---reduce, isPresent---");
    List<Integer> integerList = List.of(3, 1, 2);
    System.out.println(
        integerList.stream().reduce((accumulator, element) -> accumulator * element).get());

    integerList.stream()
        .reduce((accumulator, element) -> accumulator * element).ifPresent(System.out::println);

    System.out.println(integerList.stream()
        .reduce(2, (accumulator, element) -> accumulator * element));

    //sorted
    System.out.println("---sorted---");
    integerList.stream().sorted().forEach(System.out::println);

    students.stream().sorted((x, y) -> x.getName().compareTo(y.getName()))
        .forEach(System.out::println);
    System.out.println("------");
    students.stream().sorted((x, y) -> Integer.compare(x.getAge(), y.getAge()))
        .forEach(System.out::println);
  }
}
