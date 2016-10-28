package fizzbuzz;

public class Fizzbuzz {

    public String compute(String i) {
        Integer integer = Integer.valueOf(i);
        if(integer % 3 == 0)
            return "Fizz";
        if(integer % 5 == 0)
            return "Buzz";
        return String.valueOf(i);
    }
}
