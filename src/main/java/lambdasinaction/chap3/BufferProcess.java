package lambdasinaction.chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferProcess {


    private static String process(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }

    public static void main(String[] args) {
        try {
            String result1 = process((BufferedReader br) -> br.readLine());
            System.out.println(result1);

            String result2 = process((BufferedReader br) -> br.readLine() + br.readLine());
            System.out.println(result2);

            String result3 = process((BufferedReader br) -> {
                String line = "";
                do {
                    line = line + br.readLine();
                } while (br.readLine() != null);
                return line;
            });
            System.out.println(result3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
