import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day01 {
    List<String> frequencies = new ArrayList<>();

    public Day01() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("data.txt"));
        while (scan.hasNext()) {
            frequencies.add(scan.next());
        }
    }

    public int part1() {
        int resultingFrequency = 0;

        for (String frequency : frequencies) {
            switch (frequency.charAt(0)) {
                case '+' -> resultingFrequency += Integer.parseInt(frequency.substring(1));
                case '-' -> resultingFrequency -= Integer.parseInt(frequency.substring(1));
            }
        }
        return resultingFrequency;
    }

    public int part2() {
        Set<Integer> resultingFrequencies = new HashSet<>();
        int duplicateFrequency = 0, resultingFrequency = 0;

        while (duplicateFrequency == 0) {
            for (String frequency : frequencies) {
                switch (frequency.charAt(0)) {
                    case '+' -> resultingFrequency += Integer.parseInt(frequency.substring(1));
                    case '-' -> resultingFrequency -= Integer.parseInt(frequency.substring(1));
                }
                if (!resultingFrequencies.add(resultingFrequency)) {
                    duplicateFrequency = resultingFrequency;
                    break;
                }
            }
        }
        return duplicateFrequency;
    }
}
