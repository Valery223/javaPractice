import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //1.
        String s = "Devid";
        z1(s.toLowerCase());

        //2
        String s2 = "Valery Teslenko";
        z2(s2);

        //3
        int[] arr = {1,2,3,4,5};
        System.out.println(z3(arr));

        //4
        int[] arr2 = {1,2,3,4,5};
        z4(arr2);

        //5
        int[] arr3 = {1,2,3,4,5};
        z5(arr3);
        for(int i = 0; i < arr3.length;i++)
        {
            System.out.print(arr3[i] + " ");
        }

        //6
        String s3 = "Goroh";
        System.out.println('\n' + z6(s3));

        //7
        int n = 5;
        System.out.println(z7(n));

        //8
        System.out.println(z8(40));

        //9
        String transcript = "Это help тест.";
        if (z9(transcript, "help")) {
            System.out.println("Вызов сотрудника");
        } else {
            System.out.println("Продолжайте ожидание");
        }

        //10
        String str1 = "Valo";
        String str2 = "Alov";
        System.out.println(z10(str1,str2));
    }



    //1. Повтор слов
    public static void z1(String s)
    {
        //lower
        char[] chars = s.toCharArray();
        HashSet<Character> hs = new HashSet<>();

        for(char c : chars)
        {
            if(hs.contains(c))
            {
                System.out.println("True");
                return;
            }
            hs.add(c);
        }

        System.out.println("False");
        return;
    }


    //2. FIO
    public static void z2(String fullName) {
        String[] names = fullName.split(" ");
        char[] a = new char[2];
        a[0] = names[0].charAt(0);
        a[1] = names[1].charAt(0);
        System.out.println(a[0] + "." + a[1] + ".");
    }


    //3.
    public static int z3(int[] array)
    {
        int sumEven = 0; // сумма четных чисел
        int sumOdd = 0; // сумма нечетных чисел

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                // четное число
                sumEven += array[i];
            } else {
                // нечетное число
                sumOdd += array[i];
            }
        }

        return sumEven - sumOdd;
    }

    //4
    public static void z4(int[] array){
        int sum = 0; // сумма всех элементов
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        double average = (double) sum / array.length; // среднее арифметическое

        for (int i = 0; i < array.length; i++) {
            if (Double.compare(array[i], average) == 0) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
        return;
    }

    //5
    public static int[] z5(int[] array)
    {
        for(int i =0; i <array.length; i++)
        {
            array[i] *= i;
        }
        return array;
    }

    //6
    public static String z6(String str)
    {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--)
        {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }


    //7 Tribonach
    public static int z7(int n)
    {
        if (n == 0 || n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }

        int[] trip = new int[n + 1];
        trip[0] = 0;
        trip[1] = 0;
        trip[2] = 1;

        for (int i = 3; i <= n; i++) {
            trip[i] = trip[i - 1] + trip[i - 2] + trip[i - 3];
        }

        return trip[n];
    }


    //8
    public static String z8(int length) {
        Random random = new Random();
        StringBuilder quasiHash = new StringBuilder();

        while (quasiHash.length() < length) {
            quasiHash.append(Integer.toHexString(random.nextInt(16)));
        }

        return quasiHash.toString();
    }


    //9
    public static boolean z9(String f, String word) {
        String[] words = f.split("\\s+");

        for (String w : words) {
            if (w.equalsIgnoreCase(word)) {
                return true;
            }
        }

        return false;
    }

    //10
    public static boolean z10(String str1, String str2) {
        //Удаляем пробелы и приводим строки к нижнему регистру
        String s1 = str1.replaceAll("\\s", "").toLowerCase();
        String s2 = str2.replaceAll("\\s", "").toLowerCase();

        if (s1.length() != s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        char[] c2 = s2.toCharArray();
        Arrays.sort(c2);

        return Arrays.equals(c1, c2);
    }
}

