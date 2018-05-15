package calculations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private static double minimum = 5;

    private static double result = 0;

    private static List<Dystrybuanta> dystrybuanty;

    public static double parse(double x) throws IOException {

        try (BufferedReader tmp = new BufferedReader( new FileReader("D:/file.txt"))) {
            while (true) {
                String line = tmp.readLine();

                if (line == null) {
                    break;
                }

                parseResult(line, x);
            }
        }

        return result;
    }

    private static void parseResult(String line, double x) {
        String[] parts = line.split(";");

        double czas = 0;

        if (parts.length == 2) {

            czas = Double.parseDouble(parts[0]);

            if(Math.abs(czas - x) < minimum){
                minimum = Math.abs(czas - x);
                result = Double.parseDouble(parts[1]);
            }
        }
    }

    public static List<Dystrybuanta> load(){
        dystrybuanty = new ArrayList<>();
        try (BufferedReader tmp = new BufferedReader( new FileReader("D:/file.txt"))) {
            while (true) {
                String line = tmp.readLine();

                if (line == null) {
                    break;
                }

                String[] parts = line.split(";");
                Dystrybuanta d = new Dystrybuanta();

                if (parts.length == 2) {

                    d.setX(Double.parseDouble(parts[0]));
                    d.setProbability(Double.parseDouble(parts[1]));
                    dystrybuanty.add(d);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dystrybuanty;
    }


}
