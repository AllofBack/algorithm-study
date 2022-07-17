// 조합 & 중복조합

public class Combination01 {

    int getNumOfCombination(int n, int r) {
        int pResult = 1;
        for (int i = n; i >= n - r + 1; i--) {
            pResult *= i;
        }

        int fResult = 1;
        for (int i = 1; i <= r; i++) {
            fResult *= i;
        }

        return pResult / fResult;
    }

    public static void main(String[] args) {
        //      1. 조합 nCr
        System.out.println("== 조합 ==");

        int n = 4;
        int r = 2;

        int pResult = 1;
        for (int i = n; i >= n - r + 1; i--) {
            pResult *= i;
        }

        int fResult = 1;
        for (int i = 1; i <= r; i++) {
            fResult *= i;
        }

        System.out.println(pResult / fResult);


        //      2. 중복 조합 nHr = (n+r-1)Cr
        System.out.println("== 중복 조합 ==");
        n = 2;
        r = 3;

        int hResult = new Combination01().getNumOfCombination(n + r - 1, r);
        System.out.println(hResult);

    }
}