package org.rail;

import java.util.Random;
import java.util.concurrent.*;

public class Sixth {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 8; i++) {
                System.out.println(executorService.submit(new RunningTask()).get());

            }
        }
    }

    public static class RunningTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            Random random = new Random();
            int timeout = random.nextInt(6);
            TimeUnit.SECONDS.sleep(timeout);
            return "I was sleeping for a " + timeout + " seconds";
        }
    }

}
