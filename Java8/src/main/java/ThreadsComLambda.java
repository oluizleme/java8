public class ThreadsComLambda {

    public static void main(String[] args) {

        new Thread(() -> System.out.println("This is a thread with Lambda")).start();
    }
}
