package tests;

public class Tesla {

    public static int solution(int[] A) {
        int length = A.length;
        boolean[] flag = new boolean[length + 1];

        for (int i = 0; i < length; i++) {
            if (A[i] > 0 && A[i] <= length) {
                flag[A[i]] = true;
            }
        }
        for (int i = 1; i <= length; i++)
            if (!flag[i])
                return i;
        return length + 1;
    }

    public static void main(String[] args) {

        int A[] = {1, 3, 6, 4, 1, 2};
        System.out.println(solution(A));
    }
}

