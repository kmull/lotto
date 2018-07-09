package pl.muller.lotto.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class MainClass {

    Logger log = LoggerFactory.getLogger(MainClass.class);

    public static void main(String[] args) throws FileNotFoundException {
//        MainClass mainClass = new MainClass();
//        mainClass.saveFile("to jest plik 2");
        int[] tab = new int[49];


        File file = new File("wyniki_2018.txt");
        Scanner in = new Scanner(file);

        while (in.hasNext()) {
            int tmp = in.nextInt();
            tab[tmp - 1] += 1;
        }
//        for (int i = 1; i <= 49; i++) {
//            System.out.println("nr." + i + " --- " + tab[i - 1]);
//        }

        Map<Integer, Integer> integerMap = new TreeMap<>();

        for (int i = 0; i < 49; i++) {
//            System.out.println("nr." + (i + 1));
            integerMap.put((i + 1), tab[i]);
            System.out.println(integerMap.values());
        }
        System.out.println();

        for (Map.Entry<Integer, Integer> entry : integerMap.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }


    }


    private void saveFile(String word) {
        PrintWriter zapis = null;
        try {
            zapis = new PrintWriter("wyniki_2018.txt");
        } catch (FileNotFoundException e) {
            log.info("FileNotFoundException");
        }
        zapis.println(word);
        zapis.close();
    }
}

//        for(int x:tab){
//                System.out.print(x+" ");
//                }

//        IntStream.rangeClosed(1, 49)
//                .forEach(x -> tab[x - 1] = x);