package App;

import Modelos.Registro;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static void main() {
        List<Registro> lista = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            lista.add(new Registro(LocalDateTime.now().plusMinutes(i),
                    Math.random() * (50 - (-10) + 1) + (-10),
                    Math.random() * 100));
        }

        /**
         * 1. Filtrar los registros de temperatura que sean mayores a 25 grados, la humedad sea menor a 70 y la
         * fecha sea anterior a la fecha actual, y mostrarlos.
         */
        IO.println("----- Ejercicio 1 -----");
        lista.stream()
                .filter(r -> r.getTemperatura() > 25)
                .filter(r -> r.getHumedad() < 70)
                .filter(r -> r.getFechaHora().isBefore(LocalDateTime.now()))
                .forEach(System.out::println);


        /**
         * 2. Encontrar el registro con la temperatura más alta y mostrar el registro completo.
         */
        IO.println("----- Ejercicio 2 -----");
        lista.stream()
                .sorted(Comparator.comparing(Registro::getTemperatura).reversed())
                .limit(1)
                .forEach(System.out::println);


        /**
         * 3. Obtener una lista con las fechas/horas de todas las tomas de datos.
         */
        IO.println("----- Ejercicio 3 -----");
        lista.stream()
                .map(Registro::getFechaHora)
                .forEach(System.out::println);


        /**
         * 4. Incrementar en 5 unidades la humedad de todos los registros y mostrar las temperaturas,
         * humedades y fechas/horas actualizadas.
         */
        IO.println("----- Ejercicio 4 -----");
        lista.stream()
                .map(r -> new Registro(r.getFechaHora(),
                        r.getTemperatura(),
                        r.getHumedad() + 5))
                .forEach(System.out::println);


        /**
         * 5. Encontrar el registro con la temperatura más baja que tenga una humedad mayor a 80 y mostrar la
         * temperatura, humedad y fecha.
         */
        IO.println("----- Ejercicio 5 -----");
        lista.stream()
                .filter(r -> r.getHumedad() > 80)
                .sorted(Comparator.comparing(Registro::getTemperatura))
                .limit(1)
                .forEach(System.out::println);


        /**
         * 6. Verificar si algún registro tiene una temperatura mayor a 30 grados, humedad mayor a 90 y la fecha
         * es de hoy. Mostrar un mensaje indicando si hay algún registro que cumple esta condición o no.
         */
        IO.println("----- Ejercicio 6 -----");
        boolean registro = lista.stream()
                .anyMatch(r -> r.getTemperatura() > 80
                && r.getHumedad() > 90
                && r.getFechaHora().equals(LocalDateTime.now()));
        IO.println("¿Hay algun registro que cumpla la condición? " + registro);


        /**
         * 7. Muestra 10 registros saltándote los 5 primeros.
         */
        IO.println("----- Ejercicio 7 -----");
        lista.stream()
                .skip(5)
                .limit(10)
                .forEach(System.out::println);


        /**
         * 8. Muestra los registros ordenados por fecha (sorted(Comparator))
         */
        IO.println("----- Ejercicio 8 -----");
        lista.stream()
                .sorted(Comparator.comparing(Registro::getFechaHora).reversed())
                .forEach(System.out::println);


        /**
         * 9. Cuenta los registros que tengan temperatura mayor a 35 grados (count()).
         */
        IO.println("----- Ejercicio 9 -----");
        long cuenta = lista.stream()
                .filter(r -> r.getTemperatura() > 35)
                .count();
        IO.println("Registros: " + cuenta);


        /**
         * 10. Calcular la temperatura promedio de todos los registros (transformarlo en Stream<Double> y
         * llamar a average()).
         */
        IO.println("----- Ejercicio 10 -----");
        double temperatura = lista.stream()
                .mapToDouble(Registro::getTemperatura)
                .average()
                .orElse(0);
        IO.println("Temperatura media: " + temperatura + " Grados");


    }
}
