package lambdasinaction.chap5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Java中用于处理文件等I/O操作的NIO API(非阻塞 I/O)已更新，以便利用Stream API。
 * java.nio.file.Files中的很多静态方法都会返回一个流。
 * 例如，一个很有用的方法是 Files.lines，它会返回一个由指定文件中的各行构成的字符串流。
 * 使用你迄今所学的内容， 你可以用这个方法看看一个文件中有多少各不相同的词
 */
public class FileStreamExp {
    public static void main(String[] args) {
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("stream.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            System.out.println("uniqueWords is " + uniqueWords);

//            lines.flatMap(line -> Arrays.stream(line.split(" ")))
//                    .distinct()
//                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
