package servlet3;

public class Main {
    public static void main(String[] args) {
        int s = redo(83, 3);
        System.out.print(s);
    }

    static int redo(int i, int j) {
        if (i == 0)
            return 0;
        else
            return redo(i / j, j) + 1;
    }
}
