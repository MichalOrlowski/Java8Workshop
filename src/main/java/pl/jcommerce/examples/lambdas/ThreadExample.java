package pl.jcommerce.examples.lambdas;

/**
 * Simple thread example
 *
 * @author Michal Orlowski
 *
 */
public class ThreadExample {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Ave oldschool");
            }
        });

        thread.start();

        Thread thread2 = new Thread(() -> System.out.println("Lambdas are cool"));

        thread2.start();
    }
}
