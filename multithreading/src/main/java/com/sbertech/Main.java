package com.sbertech;

import com.sbertech.task7.Task7Decreaser;
import com.sbertech.task7.Task7Increaser;
import com.sbertech.task7.Task7ResourceProcessor;

public class Main {
    public static void main(String[] args) {
        Resource resource = new Resource();
        ResourceProcessor resourceProcessor = new ResourceProcessor(resource);
        Task7ResourceProcessor task7ResourceProcessor = new Task7ResourceProcessor(resource);

        for (int i = 0; i < 3; i++) {
            new Increaser(resourceProcessor).start();
        }

        // Task 7
//        new Task7Increaser(task7ResourceProcessor).start();
//        new Thread(new Task7Decreaser(task7ResourceProcessor)).start();

        // Расскомментировать нижний код и закомментить верхний, чтобы все правильно отрабатывало
        // я сделал разделение по задачам: до 7й и 7я отдельно для наглядности
    }
}
