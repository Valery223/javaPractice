import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String[] a = collect("hellaa", 3);
        for (String i : a) {
            System.out.println(i);
        }

        System.out.println(nicoCipher("iloveher","612345"));

        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] ans3 = twoProduct(arr3,10);
        System.out.println("[" + ans3[0] + ", " + ans3[1] + "]");

        int[] ans4 = isExact(720);
        System.out.println("[" + ans4[0] + ", " + ans4[1] + "]");

        System.out.println(fractions("0.19(2367)"));

        String str6 = "HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICSANDALLTHESECRETSOFTHEUNIVERSE";
        System.out.println(stringToPi(str6));

        String str7 = "(2+2)*3+2*2";
        System.out.println(polska(str7));

        isValid("abccdd");

        System.out.println(findLSC("aggtab", "gxtxamb"));

        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
    }

    public static String[] collect(String word, int n) {
        List<String> slices = new ArrayList<>();

        int index = 0;
        while (index + n <= word.length()) {
            slices.add(word.substring(index, index + n));
            index += n;
        }
        String[] sortedSlices = slices.toArray(new String[0]);
        Arrays.sort(sortedSlices);
        return sortedSlices;
    }

    ////--------------------------------------------------------------
    public static String nicoCipher(String message, String key) {

        Pair<Character, Integer>[] pairs = new Pair[key.length()];

        for(int i = 0; i < key.length();i++) {
            pairs[i] = new Pair<>(key.charAt(i), i);
        }

        Arrays.sort(pairs, Comparator.comparing(Pair::getFirst));

        int spaceAdd = message.length() % pairs.length;
        //Добавляем пробелы до нужного числа
        message += " ".repeat(pairs.length-spaceAdd);

        String ans = "";
        Pair<Character,Integer>[] pairsClone = new Pair[pairs.length];
        for(int i = 0; i < message.length(); i+= pairs.length) {
            pairsClone = pairCLone(pairs);

            for(int j = 0; j < pairs.length;j++) {
                pairsClone[findOrder(pairsClone,j)].setFirst(message.charAt(i+j));
            }
            //Arrays.sort(pairsClone, Comparator.comparing(Pair::getSecond));
            for(int j = 0; j < pairsClone.length;j++) {
                ans += "" + pairsClone[j].getFirst();
            }
        }
        return  ans;
    }
    public static int findOrder( Pair<Character, Integer>[] pairs, int order) {
        for(int i = 0; i < pairs.length;i++) {
            if(pairs[i].getSecond() == order) {
                return  i;
            }
        }
        return -1;
    }
    public static Pair[] pairCLone(Pair<Character, Integer>[] pairs) {
        Pair<Character,Integer>[] pairsClone = new Pair[pairs.length];
        for(int i = 0; i < pairs.length; i++){
            pairsClone[i] = new Pair<>(pairs[i].getFirst(),pairs[i].getSecond());
        }
        return  pairsClone;
    }
    //--------------------------------------------------------------

    public static int[] twoProduct(int[] arr, int number) {
        Integer firstNumber = null;
        Integer secondNumber = null;
        int interval = 999999;


        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if (arr[i] * arr[j] == number){
                    if (interval > j-i) {
                        firstNumber = arr[i];
                        secondNumber = arr[j];
                        interval = j-i;
                    }
                }
            }
        }
        if(firstNumber == null ) {
            return new int[0];
        }
        return new int[]{firstNumber, secondNumber};
    }

    public static int[] isExact(int number) {
        int i = 0;
        int factorial = 1;
        while(factorial < number) {
            i++;
            factorial *= i;
        }
        if(number == factorial) {
            return new int[]{factorial, i};
        }
        //else
        return new int[0];
    }

    public static String fractions(String str) {
        String regex = "(\\d+)\\.(\\d+)?\\((\\d+)\\)?";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        if (matcher.matches()) {
            int a = Integer.parseInt(matcher.group(1));
            int b = 0;
            int lenB = 0;
            int c = 0;
            int lenC = 0;
            if (matcher.group(2) != null) {
                b = Integer.parseInt(matcher.group(2));
                lenB = matcher.group(2).length();
            }
            if (matcher.group(3) != null) {
                c = Integer.parseInt(matcher.group(3));
                lenC = matcher.group(3).length();
            }

            int topDrob = a * (int)Math.pow(10,lenB) * ((int)Math.pow(10,lenC)-1) + b*((int)Math.pow(10,lenC)-1) + c;
            int botDrop = (int)Math.pow(10,lenB) * ((int)Math.pow(10,lenC)-1);
            int nod = nod(topDrob,botDrop);

            return topDrob/nod + " / " + botDrop/nod;
        }
        return  "0";
    }

    public static int nod(int x, int y) {
        while(x!=0 && y!=0){
            if (x>y) x=x%y;
            else y=y%x;
        }
        return x+y;
    }

    public static String stringToPi(String str) {
        String pi = "314159265358979";
        int i = 0;
        int indexPi = 0;
        String ans = "";

        while(i < str.length() && indexPi < pi.length()) {
            int lenCurrentPi = Integer.parseInt("" + pi.charAt(indexPi));
            for(int j = 0; j < lenCurrentPi; j++) {
                if(str.length() > i) {
                    ans +=   str.charAt(i);
                    i++;
                }
                else{
                    //Последний символ-повтор
                    ans += str.charAt(str.length()-1);
                }
            }
            ans += " ";

            indexPi++;
        }

        return ans;
    }

    public static int polska(String str) {
        String polsk = str.replace(" ", "");
        String operands = "";
        Stack<Character> operators = new Stack<>();

        int i = 0;
        while(i < str.length()) {
            char current = str.charAt(i);

            if(Character.isDigit(current)) {

                operands += current;

            } else if (isOperator(current)) {
                while(!operators.isEmpty() && checkPrioritet(operators,current)) {
                    operands += "" + operators.pop();
                }
                operators.add(current);
            } else if ('(' ==  current) {
                operators.add(current);
            } else if (')' == current) {
                while(!operators.isEmpty() && operators.peek() != '(') {
                    operands += operators.pop();
                }
                if(operators.isEmpty() || operators.peek() !='('){
                    System.out.println("error");
                    return 0;
                } else {
                    operators.pop();
                }
            }
            else{
                System.out.println("error");
                return 0;
            }

            i++;
        }

        while(!operators.isEmpty()){
            operands += "" + operators.pop();
        }

        return calculate(operands);
    }

    public static boolean isOperator(Character ch) {
        if ("+-/*".contains(ch.toString())) {
            return true;
        }
        return false;
    }
    public static boolean checkPrioritet(Stack op, char ch) {
        if (op.peek().equals('*') || op.peek().equals('/')) {
            if(ch == '+' || ch == '-'){
                return true;
            }
        }
        return false;
    }

    public static int calculate(String str) {
        Stack<Integer> stack = new Stack();
        int i = 0;
        String number = "";
        while(i < str.length()) {
            char current = str.charAt(i);
            if(Character.isDigit(current)) {
                //number += current;
                stack.add(Integer.parseInt(Character.toString(current)));
            } else {
                    int val2 = stack.pop();
                    int val1 = stack.pop();
                    int ans;
                    if(current == '+'){
                        ans = val1+val2;
                    } else if (current == '-') {
                        ans = val1-val2;
                    } else if (current== '*') {
                        ans = val1*val2;
                    } else if (current == '/') {
                        ans = val1/val2;
                    } else {
                        System.out.println("err");
                        return 0;
                    }
                    stack.add(ans);
            }

            i++;
        }
        return stack.pop();
    }

    public static void isValid(String str) {
        Map<Character, Integer> charCounts = new HashMap<>();

        for (char ch : str.toCharArray()) {

            if (charCounts.containsKey(ch)) {
                int count = charCounts.get(ch);
                charCounts.put(ch, count + 1);
            }

            else {
                charCounts.put(ch, 1);
            }
        }
        int val1 = 0;
        int val2 = 0;
        int count1 = 0;
        int count2 = 0;
        boolean flag = true;
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            if(count == val1) {
                count1++;
            } else if (count == val2) {
                count2++;
            } else if (val1 == 0) {
                val1 = count;
                count1++;
            } else if (val2 == 0) {
                val2 = count;
                count2++;
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            if(count1 == 0 || count2 == 0) flag=true;
            else if ((count1==1 || count2==1) && Math.abs(val1-val2) == 1) {
                flag=true;
            } else {
                flag = false;
            }
        }
        if (flag) {
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }

    public static String findLSC(String str1, String str2) {
        String order = "";
        for(Character ch : str2.toCharArray()) {
            order += findPosition(str1,ch);
        }
        int[] length = new int[str1.length()];
        for (int k = 0; k < order.length(); k++) {
            length[k] = 1;
            for (int i = 0; i < k; i++) {
                if(order.charAt(i) < order.charAt(k)) {
                    length[k] = Math.max(length[k],length[i]+1);
                }
            }
        }
        int maxLength = Arrays.stream(length).max().orElse(0);

        //Поиск последовательности
        char[] ch = new char[maxLength];
        ch[maxLength-1] = findBackChar(length,maxLength,'z',order);
        for(int i = maxLength-1; i > 0; i--) {
            ch[i-1] = findBackChar(length,i,ch[i],order);
        }

        String ans = "";
        for(char ch1 : ch) {
            ans += str1.charAt(Integer.parseInt(String.valueOf(ch1)));
        }
        return ans;
    }

    public static char findBackChar(int[] length, int maxLength, char ch, String str) {
        int indexMaxSub = 0;
        for(int q = 0; q < length.length ;q++) {
            if(length[q] == maxLength && ch > str.charAt(q)) {
                indexMaxSub = q;
                break;
            }
        }
        return str.charAt(indexMaxSub);
    }
    public static String findPosition(String str, char ch) {
        String ans = "";
        int index = 0;
        while(str.indexOf(ch,index) != -1) {
            ans +="" + str.indexOf(ch,index);
            index = str.indexOf(ch,index) + 1;
        }
        StringBuilder stringBuilder = new StringBuilder(ans);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static String hiddenAnagram(String sentence, String anagram) {
        sentence = sentence.toLowerCase().replaceAll("[^a-z]", "");
        anagram = anagram.toLowerCase().replaceAll("[^a-z]", "");

        char[] anagramChars = anagram.toCharArray();
        Arrays.sort(anagramChars);

        String sortedAnagram = new String(anagramChars);

        int len = sentence.length() - anagram.length() +1;
        for(int i = 0; i < len; i++) {
            String subStr = sentence.substring(i,i+anagram.length());

            char[] subStrChar = subStr.toCharArray();
            Arrays.sort(subStrChar);

            String sortedSubStr = new String(subStrChar);

            if(sortedSubStr.equals(sortedAnagram)) {
                return subStr;
            }
        }

        return "";
    }
}