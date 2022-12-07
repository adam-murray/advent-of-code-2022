import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class FileImporter {
    public static List<String> readTextFileByLine(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));
    }
    public static List<Integer> getTotals(List<String> allValues){
        List<Integer> totals = new ArrayList<>();
        int total = 0;
        for (String value: allValues){
            if (value.isEmpty()){
                totals.add(total);
                total = 0;
                continue;
            }
            int intValue = Integer.parseInt(value);
            total += intValue;
        }
        return totals;
    }
    public static int getHighest(List<Integer> totals) {
        Collections.sort(totals);
        List<Integer> topThreeTotals = totals.subList(totals.size()-3, totals.size());
        int total = 0;
        for (int value: topThreeTotals){
            total += value;
        }
        return total;
    }
    public static void main(String[] args) throws IOException{
        List<String> fileContent = FileImporter.readTextFileByLine("src/files/input.txt");
        List<Integer> totals = getTotals(fileContent);
        System.out.println(totals);
        System.out.println("The highest value in the file is: " + getHighest(totals));
    }
}
