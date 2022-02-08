import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day02 {
    List<String> IDs = new ArrayList<>();

    public Day02() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("data.txt"));
        while (scan.hasNext()) {
            IDs.add(scan.nextLine());
        }
    }

    private boolean containsDouble(String ID) {
        for (int i = 0; i < ID.length(); i++) {
            int count = 0;
            for (int j = 0; j < ID.length(); j++) {
                if (ID.charAt(j) == ID.charAt(i)) {
                    count++;
                }
            }
            if (count == 2) {
                return true;
            }
        }
        return false;
    }

    private boolean containsTriple(String ID) {
        for (int i = 0; i < ID.length(); i++) {
            int count = 0;
            for (int j = 0; j < ID.length(); j++) {
                if (ID.charAt(j) == ID.charAt(i)) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    public int part1() {
        int doubles = 0, triples = 0;
        for (String ID : IDs) {
            if (containsDouble(ID)) {
                doubles++;
            }
            if (containsTriple(ID)) {
                triples++;
            }
        }
        return doubles * triples;
    }

    public String part2() {
        StringBuilder common = new StringBuilder();

        for (int i = 0; i < IDs.size() - 1; i++) {
            for (int j = i + 1; j < IDs.size(); j++) {
                int count = 0, index = 0;
                for (int k = 0; k < IDs.get(i).length(); k++) {
                    if (IDs.get(i).charAt(k) != IDs.get(j).charAt(k)) {
                        count++;
                        index = k;
                    }
                }
                if (count == 1) {
                    for (int k = 0; k < IDs.get(i).length(); k++) {
                        if (k == index) {
                            continue;
                        }
                        common.append(IDs.get(i).charAt(k));
                    }
                }
            }
        }
        return common.toString();
    }
}
