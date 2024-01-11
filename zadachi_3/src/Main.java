import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        System.out.println("  o o \n o o o \n  o o ");
        //1
        String str1 = "Hello team, can I help you?";
        System.out.println(z1(str1));

        //2
        String str2 = "HHello112 team, can I help you? No, you less";
        System.out.println(z2(str2));

        //3
        z3(1, 2, 2, 1, 1);

        //4
        z4(123);

        //5
        int[] arr5 = {2, 5, 2};
        System.out.println(z5(arr5));

        //6
        String[][] arrStr = {{"Orange","Shop1","Shop2","Shop3"},{"Mango","Shop1"},{"Banana","Shop1","Shop3"},{"Apple","Shop1","Shop2","Shope3"}};
        z6(arrStr);

        //7
        String str7 = "qwe ewq qwe ewq qwe ewq qwe ewq qwe ewq qwe ewq qwe ewq qwe";
        if(z7(str7)){
            System.out.println("Можно");
        }
        else{
            System.out.println("Нельзя");
        }

        //8
        int[] arr8 = {1,2,1,4};
        if(z8(arr8)){
            System.out.println("Волна");
        }
        else{
            System.out.println("Не волна");
        }

        //9
        String str9 = "Actions speak louder than words";
        z9(str9);

        //10
        int[][] arr10 = {{1,2,3},{4,5,6},{7,8,9}};
        for(int[] i : arr10){
            for(int j: i){
                System.out.print(j + " ");
            }
            System.out.println("");
        }
        System.out.println("-----");
        z10(arr10);
        for(int[] i : arr10){
            for(int j: i){
                System.out.print(j + " ");
            }
            System.out.println("");
        }

    }


    //1
    public static String z1(String str) {
        String regex = "[AEIOUaeiou]"; //
        String replemant = "*";
        return str.replaceAll(regex, replemant);
    }

    //2
    public static String z2(String str) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            char currentChar = str.charAt(i);
            if (i < str.length() - 1 && currentChar == str.charAt(i + 1)) {
                result.append("Double").append(Character.toUpperCase(currentChar));
                i += 2;
            } else {
                result.append(currentChar);
                i++;
            }
        }
        return result.toString();
    }

    //3
    public static boolean z3(int a, int b, int c, int d, int e) {
        int[] nums1 = {a, b, c};
        int[] nums2 = {d, e};
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        if (nums1[1] <= nums2[1] && nums1[0] <= nums2[0]) {
            return true;
        } else {
            return false;
        }


    }

    //4
    public static boolean z4(int n) {
        String s = String.valueOf(n);

        int sum = 0;
        //сумма цифр
        for (int i = 0; i < s.length(); i++) {
            char digitChar = s.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            sum += digit;
        }

        if (sum % 2 == n % 2) {
            return true;
        } else {
            return false;
        }
    }

    //5
    public static int z5(int[] arr) {
        int amount = 0;
        double a = arr[0];
        double b = arr[1];
        double c = arr[2];
        double full_d = Math.pow(b, 2) - 4 * a * c;

        if (full_d < 0) {
            return 0;
        }
        double d = Math.pow(full_d, 0.5);
        //Проверка на целость дискрименанта
        if (d % 1 == 0) {
            if (d == 0) {
                if (b % (2 * a) == 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
            else {
                if ((-1 * b - d) % (2 * a) == 0) {
                    amount++;
                }
                if ((-1 * b + d) % (2 * a) == 0) {
                    amount++;
                }
            }

        }
        return amount;

    }

    //6
    public static ArrayList<String> z6(String[][] arrStr){
        int max_len = 0;
        for(int i = 0; i < arrStr.length;i++){
            if(arrStr[i].length > max_len){
                max_len = arrStr[i].length;
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < arrStr.length; i++){
            if(arrStr[i].length == max_len){
                list.add(arrStr[i][0]);
            }
        }
        return list;
    }

    //7
    public static boolean z7(String str){
        String[] words = str.split("\\s+");
        String[] remainingWords = new String[words.length - 1];
        String currentWord;

        for(int i = 0; i < words.length; i++){
            currentWord = words[i];
            //Делаем срез без word[i]
            System.arraycopy(words,0,remainingWords,0,i);
            System.arraycopy(words,i+1,remainingWords,i,remainingWords.length-i);
            if (findChain(currentWord, remainingWords)){
                return true;
            }
        }
        //Если прошел все варианты и не нашел подходящего
        return false;

    }
    public static boolean findChain(String currentWord, String[] remainingWords) {
        if(remainingWords.length == 0){
            return true;
        }

        //Находим последнюю букву
        char lastChar = currentWord.charAt(currentWord.length()-1);
        String nextWord;
        String[] nextRemainingWords = new String[remainingWords.length - 1];
        //Рекурсия
        for (int i = 0; i < remainingWords.length; i++) {
            if(remainingWords[i].charAt(0) == lastChar){
                nextWord = remainingWords[i];
                //Делаем срез без newxtWord
                System.arraycopy(remainingWords,0,nextRemainingWords,0,i);
                System.arraycopy(remainingWords,i+1,nextRemainingWords,i,nextRemainingWords.length-i);
                if (findChain(nextWord, nextRemainingWords)){
                    return true;
                }
            }
        }
        return false;
    }


    //8
    public static boolean z8(int[] arr){
        if(arr.length <= 1){
            return true;
        }
        boolean check1 = arr[0]>arr[1];
        boolean check2;
        for(int i = 1; i < arr.length - 1; i++){
            check2 = arr[i] > arr[i+1];
            //XOR
            if (!(check1 ^ check2)){
                return false;
            }
            check1 = check2;
        }
        return true;
    }

    //9
    public static void z9(String str){
        Map<Character, Integer> vowel = new HashMap<>();
        vowel.put('a', 0);
        vowel.put('e', 0);
        vowel.put('i', 0);
        vowel.put('o', 0);
        vowel.put('u', 0);
        for(char ch : str.toCharArray()){
            if(vowel.containsKey(ch)){
                vowel.put(ch,vowel.get(ch)+1);
            }
        }
        int max_value = 0;
        char max_key = '-';
        for (Map.Entry<Character, Integer> entry : vowel.entrySet()) {
            if(entry.getValue() > max_value){
                max_key = entry.getKey();
                max_value = entry.getValue();
            }
        }
        System.out.println("Max value = " + max_value + " for key = " + max_key);

    }

    //10
    public static void z10(int arr[][]){
        int sum;
        for(int j = 0; j < arr[0].length; j++){
            sum = 0;
            for(int i = 0; i < arr.length; i++){
                if(i != j){
                    sum += arr[i][j];
                }
            }
            arr[j][j] = sum / (arr.length-1);
        }
    }
}



