package com.company;

public class Operations {
    public static int FindMax(int min, int max) {
        int maxim = Function(min);
        int y;
        for (int i = min; i <= max; i++) {
            y = Function(i);
            if (maxim < y) {
                maxim = y;
            }
        }
        return maxim;
    }

    public static String PrintPoints(int min, int max) {
        String points = "x               f(x)\n";
        for (int i = min; i < max; i++) {
            points += (i + "              " + Function(i) + "\n");
        }
        return points;
    }

    public static int Function(int x) {
        return x * x * x * 2 + 3 * x * x - 10;
    }

    public static double Function(double x) {
        return x * x * x * 2 + 3 * x * x - 10;
    }


    //Find Root
    /// <returns>Абсолютное значение числа</returns>
    static double Abs(double x) {
        return (x < 0) ? -x : x;
    }

    /// <returns>-1 если число отрицательное, 1 - если положительное</returns>
    static int Sign(double x) {
        return (x < 0) ? -1 : 1;
    }

    static double BisectionMethod(int min, int max) {
        double precision = 1e-10;
        double a = min, b = max;
        while (true) {
            var t = (a + b) / 2;

            if (Sign(Function(t)) == Sign(Function(a))) {
                a = t;
            } else {
                b = t;
            }
            if (Function(t) == 0.0 || Abs(b - a) < Abs(precision)) {
                return t;
            }
        }
    }

}
