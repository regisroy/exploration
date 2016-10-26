package fizzbuzz;

public class FizzBuzz {


    public String compute(String i) {
        return compute(Integer.valueOf(i));
    }

    public String compute(Integer i) {
        if (i % 3 == 0) {
            return "Fizz";
        }
        return String.valueOf(i);
    }
}
