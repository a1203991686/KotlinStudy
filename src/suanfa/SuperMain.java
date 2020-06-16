package suanfa;

public class SuperMain extends Main {

    protected SuperMain() {
        System.out.println("SuperMain: 1234");
    }

    @Override
    protected void print() {
        System.out.println("SuperMain: 1234");
    }

    public static void main(String[] args) {

    }
}
