package servlet3;

public class Main {
    public static void main(String[] args) {
        String string = "Madam";
        StringBuilder s = new StringBuilder(string);
        System.out.println(s.reverse().toString().equals(string));
    }
}
