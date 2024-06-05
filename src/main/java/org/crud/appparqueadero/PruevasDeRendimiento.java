/*package org.crud.appparqueadero;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;


//public class PruevasDeRendimiento {

Pruevas Unitarias

* Ejemplo de Pruebas de Rendimiento:
Para realizar pruebas de rendimiento,
*  se pueden usar herramientas como JMH
* (Java Microbenchmark Harness). Aquí hay
* un ejemplo básico de cómo configurar
*  una prueba de rendimiento con JMH.



    @State(Scope.Thread)
    public class TaskManagerBenchmark {

        private ConcurrentTaskManager taskManager;

        @Setup(Level.Trial)
        public void setup() {
            taskManager = new ConcurrentTaskManager();
            for (int i = 0; i < 1000; i++) {
                taskManager.addTask(new Task(i, "Task " + i));
            }
        }

        @Benchmark
        @BenchmarkMode(Mode.Throughput)
        @OutputTimeUnit(TimeUnit.MILLISECONDS)
        public void testAddTask() {
            taskManager.addTask(new Task(1001, "Task 1001"));
        }

        @Benchmark
        @BenchmarkMode(Mode.Throughput)
        @OutputTimeUnit(TimeUnit.MILLISECONDS)
        public void testRemoveTask() {
            taskManager.removeTask(500);
        }

        @Benchmark
        @BenchmarkMode(Mode.Throughput)
        @OutputTimeUnit(TimeUnit.MILLISECONDS)
        public void testGetNextTask() {
            taskManager.getNextTask();
        }
    }

//}
*/