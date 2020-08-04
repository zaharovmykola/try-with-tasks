import java.util.*;

public class Main {
    public static Map<String, Integer> firstNonrepeatingCharacterFromTheBeginning(String str) {
        char[] ourArrrayOfCharacters = str.toCharArray();
        return seekingForRepeatingSymbol(ourArrrayOfCharacters);
    }

    public static Map<String, Integer> firstNonrepeatingCharacterFromTheEnd(String str) {
        char[] ourArrrayOfCharacters = new char[str.length()];
        int countForStringReverse = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            ourArrrayOfCharacters[i] = str.charAt(countForStringReverse);
            countForStringReverse--;
        }
        return seekingForRepeatingSymbol(ourArrrayOfCharacters);
    }

    public static Map<String, Integer> seekingForRepeatingSymbol(char[] ourArrrayOfCharacters) {
        Map<String, Integer> mapOfResults = new LinkedHashMap<>();
        char someCharacter = ' ';
        Integer numberOfElementInArray = 0;
        int countForCharSearch;
        String stringSomeCharacter;
        for (int j = 0; j < ourArrrayOfCharacters.length; j++) {
            someCharacter = ourArrrayOfCharacters[j];
            numberOfElementInArray = j;
            countForCharSearch = 0;
            for (int k = 0; k < ourArrrayOfCharacters.length; k++) {
                if (someCharacter == ourArrrayOfCharacters[k]) {
                    countForCharSearch++;
                }
            }
            if (countForCharSearch == 1) {
                stringSomeCharacter = String.valueOf(someCharacter);
                mapOfResults.put(stringSomeCharacter, numberOfElementInArray);
            }
        }
        return mapOfResults;
    }

    /////////////////////////////////Second Task
    public static String makingReverseString(String original) {
        String reverse = "";
        int length = original.length();
        for (int i = length - 1; i >= 0; i--) {
            reverse = reverse + original.charAt(i);
        }
        return reverse;
    }

    public static String[] makingArrayOfUnrepeatingCharacters(Map<String, Integer> mapOfResults) {
        Long amountOfUnrepeatingCharacters = mapOfResults.entrySet().stream().count();
        int i = 0;
        String[] arrayOfUnrepeatingCharacters = new String[Long.valueOf(amountOfUnrepeatingCharacters).intValue()];
        for (Map.Entry<String, Integer> entry : mapOfResults.entrySet()) {
            arrayOfUnrepeatingCharacters[i] = entry.getKey();
            i++;
        }
        return arrayOfUnrepeatingCharacters;
    }

    public static Integer[] makingArrayOfElementNumbersOfUnrepeatingCharacters(Map<String, Integer> mapOfResults) {
        Long amountOfUnrepeatingCharacters = mapOfResults.entrySet().stream().count();
        Integer[] arrayOfElementNumbersOfUnrepeatingCharacters = new Integer[Long.valueOf(amountOfUnrepeatingCharacters).intValue()];
        int f = 0;
        for (Map.Entry<String, Integer> entry : mapOfResults.entrySet()) {
            arrayOfElementNumbersOfUnrepeatingCharacters[f] = entry.getValue();
            f++;
        }
        return arrayOfElementNumbersOfUnrepeatingCharacters;
    }

    public static String checkPalindromeCreatorWithTwoSymbolsOnTheBeginning(String original) {
        Map<String, Integer> mapOfChatResultsForSymbolsFromBeginning = firstNonrepeatingCharacterFromTheBeginning(original);
        Long amountOfUnrepeatingCharacters = mapOfChatResultsForSymbolsFromBeginning.entrySet().stream().count();
        Integer[] arrayOfElementNumbersOfUnrepeatingCharacters = makingArrayOfElementNumbersOfUnrepeatingCharacters(mapOfChatResultsForSymbolsFromBeginning);
        String[] arrayOfUnrepeatingCharacters = makingArrayOfUnrepeatingCharacters(mapOfChatResultsForSymbolsFromBeginning);
        String nextOriginal = "";
        if (amountOfUnrepeatingCharacters == 2) {
            nextOriginal = original.replace(arrayOfUnrepeatingCharacters[0], "");
            String reverse = makingReverseString(nextOriginal);
            if (nextOriginal.equals(reverse)) {
                return arrayOfUnrepeatingCharacters[0];
            } else {
                Map<String, Integer> mapOfChatResultsForSymbolsFromTheEnd = firstNonrepeatingCharacterFromTheEnd(original);
                Long amountOfUnrepeatingCharactersSecond = mapOfChatResultsForSymbolsFromBeginning.entrySet().stream().count();
                String[] arrayOfUnrepeatingCharactersSecond = makingArrayOfUnrepeatingCharacters(mapOfChatResultsForSymbolsFromTheEnd);
                String nextOriginal2 = "";
                if (amountOfUnrepeatingCharactersSecond == 2) {
                    nextOriginal2 = original.replace(arrayOfUnrepeatingCharactersSecond[0], "");
                    String reverse2 = makingReverseString(nextOriginal2);
                    if (nextOriginal2.equals(reverse2)) {
                        return arrayOfUnrepeatingCharactersSecond[0];
                    }
                }
            }
        }
        if (amountOfUnrepeatingCharacters == 3
                && ((arrayOfElementNumbersOfUnrepeatingCharacters[0]+1) != arrayOfElementNumbersOfUnrepeatingCharacters[1]) ) {
            nextOriginal = original.replace(arrayOfUnrepeatingCharacters[0], "");
            nextOriginal = nextOriginal.replace(arrayOfUnrepeatingCharacters[1], "");
            String reverse = makingReverseString(nextOriginal);
            if (nextOriginal.equals(reverse)) {
                return arrayOfUnrepeatingCharacters[0] + arrayOfUnrepeatingCharacters[1];
            } else {
                Map<String, Integer> mapOfChatResultsForSymbolsFromTheEnd = firstNonrepeatingCharacterFromTheEnd(original);
                Long amountOfUnrepeatingCharactersSecond = mapOfChatResultsForSymbolsFromBeginning.entrySet().stream().count();
                Integer[] arrayOfElementNumbersOfUnrepeatingCharactersSecond = makingArrayOfElementNumbersOfUnrepeatingCharacters(mapOfChatResultsForSymbolsFromTheEnd);
                String[] arrayOfUnrepeatingCharactersSecond = makingArrayOfUnrepeatingCharacters(mapOfChatResultsForSymbolsFromTheEnd);
                String nextOriginal2 = "";
                if (amountOfUnrepeatingCharactersSecond == 3
                        && ((arrayOfElementNumbersOfUnrepeatingCharactersSecond[0]+1) != arrayOfElementNumbersOfUnrepeatingCharactersSecond[1])) {
                    nextOriginal2 = original.replace(arrayOfUnrepeatingCharactersSecond[0], "");
                    nextOriginal2 = nextOriginal2.replace(arrayOfUnrepeatingCharactersSecond[1], "");
                    String reverse2 = makingReverseString(nextOriginal2);
                    if (nextOriginal2.equals(reverse2)) {
                        return arrayOfUnrepeatingCharactersSecond[0] + arrayOfUnrepeatingCharactersSecond[1];
                    }
                }
            }
        }
        return "not possible";
    }

    public static String PalindromeCreator (String original){
        String reverse = makingReverseString(original);
        if (original.equals(reverse)) {
            return "palindrome";
        } else {
            return checkPalindromeCreatorWithTwoSymbolsOnTheBeginning(original);
        }
    }

    public static void main (String[]args){
        boolean functionWorking = true;
        while (functionWorking) {
            Scanner s = new Scanner(System.in);
            String someString = s.nextLine();
            if (someString.equals("Q")) {
                functionWorking = false;
                System.err.println("Program have ended");
            } else {
                if (someString.length() < 3) {
                    System.out.println("Please enter string of minimum length 3 characters");
                    continue;
                } else {
                    System.out.println(PalindromeCreator(someString));
                    System.out.println("To stop program working please enter symbol \'Q\'");
                }
            }
        }
    }
}