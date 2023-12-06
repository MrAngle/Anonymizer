package com.lipsoft.anonymize.code;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.management.BadAttributeValueExpException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
    }
    // https://rekrutacjajava.pl/wszystkie-zadania/

    // Napisz metodę, która dla podanej liczby całkowitej, zlicza sumę wszystkich jej cyfr.

    @Test
    void test1() {
        int numberToCheck = 2551002;
        int copyOfNumer = numberToCheck;
        int results = 0;

        while (copyOfNumer != 0) {
            int numberToAdd = copyOfNumer % 10;
            copyOfNumer = copyOfNumer / 10;

            results += numberToAdd;
        }

        System.out.println("results for " + numberToCheck + " is " + results);
    }

    // https://rekrutacjajava.pl/zadanie-java-dokoncz-implementacje-ponizszej-metody-tak-aby-dla-podanej-listy-stringow/

    @Test
    void test2() {
        List<String> input = List.of("test", "tesa", "pamapm", "dsaasa");

        List<String> stringList = input.stream().filter(x -> x.endsWith("a") && x.length() >= 5).toList();

        stringList.forEach(System.out::println);
    }

    // https://rekrutacjajava.pl/zadanie-java-napisz-metode-ktora-przyjmuje-dwa-parametry-typu-bigdecimal/

    @Test
    void test3() {
        BigDecimal newPrice = BigDecimal.valueOf(63.26);
        BigDecimal oldPrice = BigDecimal.valueOf(50);

        BigDecimal results = newPrice.subtract(oldPrice)
                .multiply(BigDecimal.valueOf(100)).setScale(0)
                .divide(oldPrice, 0, RoundingMode.HALF_UP);

        System.out.println(results);
    }

    // https://rekrutacjajava.pl/zadanie-java-napisz-metode-ktora-dla-podanego-stringa/

    @Test
    void test4() {
//        String input = ""
    }

//    https://rekrutacjajava.pl/zadanie-java-napisz-metode-ktora-przyjmuje-tablice-wartosci-typu-int/

    @Test
    void test5() {
        int[] input = {1, 2, 5, 5, 4};

        Map<Integer, Integer> counter = new HashMap<>();

        for (int element : input) {
            counter.merge(element, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> values : counter.entrySet()) {
            System.out.println("key: " + values.getKey() + " value: " + values.getValue());
        }


//        Arrays.stream(numbers)
//                .boxed()
//                .collect(Collectors.groupingBy(e -> e, Collectors.summingInt(i -> 1)))
//                .forEach((k, v) -> System.out.println(k + ": " + v));
//        String input = ""
    }

    // https://rekrutacjajava.pl/zadanie-java-napisz-metode-ktora-przyjmuje-parametr-typu-string/


    @Test
    void test6() {
//        String input = "qDwhe!ehwDq";
        String input = "pammap";
        boolean isPalindrome = true;

        for (int i = 0; i < input.length() / 2; i++) {
            char letter = input.toCharArray()[i];
            char oppositeLetter = input.toCharArray()[input.length() - 1 - i];

            if (letter != oppositeLetter) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("is Palindrome: " + isPalindrome);
    }

    // https://javaconceptoftheday.com/merge-two-sorted-arrays-in-java/

    @Test
    void test7() {
//        int[] arrayA = {-7, 12, 17, 29, 41, 56, 79};
//        int[] arrayB = {-9, -3, 0, 5, 19};
        int[] arrayA = {-9, -3, 0, 5, 19};
        int[] arrayB = {-7, 12, 17, 29, 41, 56, 79};
        int[] arrayC = new int[arrayA.length + arrayB.length];

        int indexA = 0;
        int indexB = 0;
        int indexC = 0;
        while (indexC < arrayC.length) {
            Integer elementA = indexA < arrayA.length ? arrayA[indexA] : null;
            Integer elementB = indexB < arrayB.length ? arrayB[indexB] : null;

            if (elementB == null || (elementA != null && elementA <= elementB)) {
                arrayC[indexC] = elementA;
                indexA++;
            } else {
                arrayC[indexC] = elementB;
                indexB++;
            }

            indexC++;
        }

        for (int j : arrayC) {
            System.out.print(j + ", ");
        }

    }

    // https://javaconceptoftheday.com/sort-array-elements-by-frequency-in-java/

    @Test
    void test8() {
        int[] input = {7, 1, 3, 4, 7, 1, 7, 1, 4, 5, 1, 9, 3};
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int number : input) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }


        // Step 2: Posortowanie i transformacja mapy do listy `List<Map.Entry<>>`
        List<Map.Entry<Integer, Integer>> sortedEntries = frequencyMap.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .toList();

        // Step 3: Transformacja posortowanej listy do listy z właściwą kolejnością
        List<Integer> sortedNumbers = new ArrayList<>();
        sortedEntries.forEach(entry ->
                IntStream.range(0, entry.getValue().intValue())
                        .forEach(i -> sortedNumbers.add(entry.getKey())));


        System.out.println(sortedNumbers);

        for (int value : sortedNumbers) {
            System.out.print(value + ", ");
        }
//
//        Collector<ArrayList, ?, ArrayList> myCollector = Collector.of(
//                ArrayList::new,          // Supplier
//                (x, y) -> x.add(y),       // Accumulator
//                StringBuilder::append,       // Combiner
//                StringBuilder::toString      // Finisher
//        );
//
//
//        frequencyMap.entrySet().stream()
//                .sorted(Comparator.comparingInt(Map.Entry::getValue))
//                .collect(() -> new ArrayList<>(), (x, b) -> x.add(b),
//                        (left, right) -> { left.addAll(right); return left; },
//                        CH_ID)
    }


    // bubble sort

    @Test
    void test9() {
        int[] input = {7, 1, 3, 4, 7, 1, 7, 1, 4, 5, 3, 9, 0};

        for (int j = 0; j < input.length - 1; j++) {
            for (int i = 0; i < input.length - 1; i++) {
                int element1 = input[i];
                int element2 = input[i + 1];

                if (element1 > element2) {
                    input[i] = element2;
                    input[i + 1] = element1;
                }
            }
        }

        for (int i : input) {
            System.out.print(i + ", ");
        }

    }

    // Napisz funkcję w języku Java, która oblicza sumę wszystkich liczb parzystych w danym zbiorze liczb.

    @Test
    void test10() {
        test(1, 4);
    }

    int test(int from, int to) {
        if(from > to) {
            throw new RuntimeException("from is grater than to");
        }

        int fromToUse = from % 2 == 0 ? from : from + 1;

        int sum = 0;

        for (int i = fromToUse; i <= to; i = i + 2) {
            sum = sum + i;
        }


        return sum;
    }

}
