
public class Main {
    public static void main(String[] args) {
        board(1);
        System.out.println("Ввели 5");
        System.out.println(z1(5));

        board(2);
        System.out.println("Ввели (15,2)");
        System.out.print(z2(15,2));

        board(3);
        System.out.println("Ввели (4,3,5)");
        System.out.print(z3(4,3,5));

        board(4);
        System.out.println("Ввели (3,3,5)");
        z4(3,3,5);

        board(5);
        System.out.println("Ввели (6,3)");
        System.out.print(z5(6,3));

        board(6);
        System.out.println("Ввели (45,1.8,1.9)");
        System.out.print(z6(45.1f,1.8f,1.9f));

        board(7);
        System.out.println("Ввели (5)");
        System.out.print(z7(5));

        board(8);
        System.out.println("Ввели (12,9)");
        System.out.print(z8(12,9));

        board(9);
        System.out.println("Ввели (15,2)");
        System.out.print(z9(15,2));

        board(10);
        System.out.println("Ввели (123,58)");
        System.out.print(z10(123,58));

    }

    public static void board(int n)
    {
        System.out.println("\n-----------------");
        System.out.println("Задание №" + n);
    }


    //1.	Создайте функцию, которая принимает целое число галлонов и преобразует его в литры.
    public static float z1(int g){
        return 3.785f*g;
    }

    //2. Калории, простое умножение
    public static int z2(int m, int i)
    {
        return m*i;
    }

    //3. Товары 3 типоы, сумма
    public static int z3(int a, int b, int c)
    {
        return a*20+b*50+c*100;
    }

    //4. треугольник
    public static void z4(int x,int y,int z)
    {
        if((x+y <= z) || (x+z <=y) || (y+z <= x)){
            System.out.println("невозможен");
        }
        else if((x==y) && (y==z)){
            System.out.println("равносторонний");
        }
        else if((x==y) || (x==z) || (y==z)){
            System.out.println("равнобедренний");
        }
        else{
            System.out.println("разносторонний");
        }
    }

    //5. сравнение
    public static int z5(int a, int b)
    {
        return a > b ? a : b;
    }

    //6. Такнь
    public static int z6(float n, float w, float h){
        return (int) (n/(w*h));
    }

    //7. Факториал
    public static long z7(int n)
    {
        long fact=1;
        for(int i = 1; i<=n; i++)
        {
            fact *=i;
        }
        return fact;
    }

    //8.НОД
    public static int z8(int a, int b)
    {
        int q = 1;
        for(int i = 2; i<=b; i++)
        {
            if(a%i == 0 && b%i == 0) {

                q = i;
            }
        }
        return q;
    }

    //9. Умножение
    public static float z9(int a, int b)
    {
        return a*b*0.72f;
    }

    //10. парты.
    public static int z10(int a, int b)
    {
        int c = a - 2*b;
        if (c<= 0){
            return 0;
        }
        else{
            return c/2 + c%2;
        }
    }

}