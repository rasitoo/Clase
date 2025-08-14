package Threads;

import java.util.concurrent.*;

/**
 * @author Rodrigo
 * @date 17 diciembre, 2024
 */
public class SumarMatrizIACopilot {
    //Github Copilot, copiando las instrucciones del ejercicio directamente
    private static final int ROWS = 1000;
    private static final int COLS = 10000;
    private static final int[][] matrix = new int[ROWS][COLS];

    static {
        // Initialize the matrix with 1s
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                matrix[i][j] = 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] threadCounts = {4, 8, 16, 32};

        for (int threadCount : threadCounts) {
            long startTime = System.currentTimeMillis();
            int totalSum = sumMatrixWithThreads(threadCount);
            long endTime = System.currentTimeMillis();
            System.out.println("Total sum with " + threadCount + " threads: " + totalSum);
            System.out.println("Time taken: " + (endTime - startTime) + " ms");
        }
    }

    private static int sumMatrixWithThreads(int threadCount) {
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        Future<Integer>[] futures = new Future[threadCount];
        int rowsPerThread = ROWS / threadCount;
        int remainingRows = ROWS % threadCount;

        for (int i = 0; i < threadCount; i++) {
            int startRow = i * rowsPerThread;
            int endRow = startRow + rowsPerThread;
            if (i == threadCount - 1) {
                endRow += remainingRows;
            }
            futures[i] = executor.submit(new SumTask(startRow, endRow));
        }

        int totalSum = 0;
        try {
            for (Future<Integer> future : futures) {
                totalSum += future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        return totalSum;
    }

    static class SumTask implements Callable<Integer> {
        private final int startRow;
        private final int endRow;

        SumTask(int startRow, int endRow) {
            this.startRow = startRow;
            this.endRow = endRow;
        }

        @Override
        public Integer call() {
            int sum = 0;
            for (int i = startRow; i < endRow; i++) {
                for (int j = 0; j < COLS; j++) {
                    sum += matrix[i][j];
                }
            }
            return sum;
        }
    }
}


