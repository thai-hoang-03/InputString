package InputString;
import java.util.*;
import java.util.regex.*;


public class AnalysisString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Function 1: Display Gui And Input Data
        System.out.println("========== Analysis String program =========");
        System.out.print("Input String: ");
        String userInput = scanner.nextLine();

        // Auto next Function 2
        HashMap<String, List<Integer>> numberAnalysis = getNumber(userInput);
        HashMap<String, StringBuilder> characterAnalysis = getCharacter(userInput);

        // Function 2: Perform function and display result
        System.out.println("\n-------------Result Analysis------------");
        System.out.println("Perfect Square Numbers: " + numberAnalysis.get("perfectSquare"));
        System.out.println("Odd Numbers: " + numberAnalysis.get("oddNumbers"));
        System.out.println("Even Numbers: " + numberAnalysis.get("evenNumbers"));
        System.out.println("All Numbers: " + numberAnalysis.get("allNumbers"));
        System.out.println("Uppercase Characters: " + characterAnalysis.get("uppercase"));
        System.out.println("Lowercase Characters: " + characterAnalysis.get("lowercase"));
        System.out.println("Special Characters: " + characterAnalysis.get("specialCharacters"));
        System.out.println("All Characters: " + characterAnalysis.get("allCharacters"));

        // Exit the program
        scanner.close();
    }

    // Function 1: Analyze the number types
    public static HashMap<String, List<Integer>> getNumber(String input) {
        HashMap<String, List<Integer>> result = new HashMap<>();
        List<Integer> allNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> perfectSquare = new ArrayList<>();

        Pattern numberPattern = Pattern.compile("\\d+");
        Matcher matcher = numberPattern.matcher(input);

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            allNumbers.add(number);

            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }

            double sqrt = Math.sqrt(number);
            if (sqrt == Math.floor(sqrt)) {
                perfectSquare.add(number);
            }
        }

        result.put("allNumbers", allNumbers);
        result.put("evenNumbers", evenNumbers);
        result.put("oddNumbers", oddNumbers);
        result.put("perfectSquare", perfectSquare);

        return result;
    }

    // Function 2: Analyze the character types and special characters
    public static HashMap<String, StringBuilder> getCharacter(String input) {
        HashMap<String, StringBuilder> result = new HashMap<>();
        StringBuilder allCharacters = new StringBuilder();
        StringBuilder uppercase = new StringBuilder();
        StringBuilder lowercase = new StringBuilder();
        StringBuilder specialCharacters = new StringBuilder();

        for (char ch : input.toCharArray()) {
            allCharacters.append(ch);

            if (Character.isUpperCase(ch)) {
                uppercase.append(ch);
            } else if (Character.isLowerCase(ch)) {
                lowercase.append(ch);
            } else if (!Character.isLetterOrDigit(ch)) {
                specialCharacters.append(ch);
            }
        }

        result.put("allCharacters", allCharacters);
        result.put("uppercase", uppercase);
        result.put("lowercase", lowercase);
        result.put("specialCharacters", specialCharacters);

        return result;
    }
    
}
