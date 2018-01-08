package com.mycomp.array;

public class MultiplyNumbers {

	//Given very large two numbers in string, write a program to multiply them and return result as string.
    public static void main(String[] args) {
        String first = "654154154151454545415415454";
        String second = "63516561563156316545145146514654";

        String answer = multiply(first, second);
        System.out.println(first + " X " + second + " = " + answer);
    }

    private static String multiply(String first, String second) {
        if (second.length() > first.length()) {
            String temp = first;
            first = second;
            second = temp;
        }
        int za = -1;
        String answer = "";
        for (int j = second.length()-1; j>=0; j--) {
            int multiplier = Character.getNumericValue(second.charAt(j));
            int carry = 0;

            StringBuilder rowans = getZeroAppendedRowAnsAccumulator(za);
            za++;
            for (int i = first.length()-1; i>=0; i--) {
                int digit = Character.getNumericValue(first.charAt(i));
                int fullAns = (digit * multiplier) + carry;
                int ans = fullAns%10;
                carry = fullAns/10;
                rowans.insert(0, ans);
            }
            if (carry > 0)
                rowans.insert(0, carry);

            answer = addToAnswer(answer, rowans.toString());
        }
        return answer;
    }

    private static String addToAnswer(String first, String second) {
        if (first.length() < second.length()) {
            String temp = first;
            first = second;
            second = temp;
        }
        int append = first.length() - second.length();
        second = getSecondWithZerosPrefixed(second, append);

        char[] f = first.toCharArray();
        char[] s = second.toCharArray();

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length - 1; i >=0 ; i--) {
            int ans = Character.getNumericValue(f[i]) + Character.getNumericValue(s[i]) + carry;
            sb.insert(0, ans%10);
            carry = ans/10;
        }

        if (carry > 0){
            sb.insert(0, carry);
        }
        return sb.toString();
    }

    private static String getSecondWithZerosPrefixed(String second, int count) {
        StringBuilder sb = new StringBuilder(second);
        while (count > 0) {
            sb.insert(0, "0");
            count--;
        }
        return sb.toString();
    }

    private static StringBuilder getZeroAppendedRowAnsAccumulator(int za) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= za; i++) {
            sb.append(0);
        }
        return sb;
    }
}
