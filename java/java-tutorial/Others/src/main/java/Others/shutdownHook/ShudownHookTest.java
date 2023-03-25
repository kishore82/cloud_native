package Others.shutdownHook;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShudownHookTest
{
    public static void main(String[] args)
    {
        Runnable obj = new Runnable()
        {

            @Override
            public void run()
            {
                for (int i = 0; i < 10; i++)
                {
                    System.out.printf("%d * %d = %d \n", 5, i, i * 5);
                }

            }

        };
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(obj);
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                System.out.println("Cleaning up resources and shutting down executor service");
                service.shutdown();
            }
        });
    }
}
