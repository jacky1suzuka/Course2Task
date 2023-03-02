import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        List<String> words = Arrays.asList(text.split(" "));
        System.out.println("Количество слов в тексте: " + words.size() + "\nTOP 10: ");
        words.stream()
                .collect(Collectors.toMap(key -> key, val -> 1, Integer::sum))
                .entrySet().stream()
                .sorted((e1, e2) -> {
                    int val = e1.getValue().compareTo(e2.getValue()) * -1;
                    if (val == 0) {
                        val = e1.getKey().compareTo(e2.getKey());
                    }
                    return val;
                })
                .limit(10)
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }
}