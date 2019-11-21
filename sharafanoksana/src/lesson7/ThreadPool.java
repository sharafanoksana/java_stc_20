/**
 * @author Sharafan Oksana
 * @date 20.11.2019
 * @package lesson7_1
 */
package lesson7;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

public class ThreadPool implements Executor {
    /**
     * Queue<Runnable> workQueue - очередь задач на выполнение, если запущено больше потоков чем размер начального пула.
     */
    private final Queue<Runnable> workQueue = new ConcurrentLinkedQueue<>();
    private volatile boolean isRunning = true;

    public ThreadPool(int nThreads) {
        for (int i = 0; i < nThreads; i++) {
            new Thread(new TaskWorker()).start();
        }
    }

    /**
     * Если запущено меньше потоков начального размера пула, пул попробует стартовать новый поток
     * @param command
     */
    @Override
    public void execute(Runnable command) {
        if (isRunning) {
            workQueue.offer(command); //пытается вставить элемент в конец очереди.
        }
    }

    /**
     * метод завершает выполнение программы
     */
    public void shutdown() {
        isRunning = false;
    }

    private final class TaskWorker implements Runnable {
        /**
         * Каждый addWorker запускает новый поток с задачей Runnable, которая опрашивает workQueue на наличие
         * новых задач и выполняет их.
         */
        @Override
        public void run() {
            while (isRunning) {
                Runnable nextTask = workQueue.poll(); //удаляет верхний элемент из очереди
                if (nextTask != null) {
                    nextTask.run();
                }
            }
        }
    }
}
