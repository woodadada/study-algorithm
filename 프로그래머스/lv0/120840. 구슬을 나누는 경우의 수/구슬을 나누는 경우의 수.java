import java.math.BigInteger;
class Solution {
    public BigInteger solution(int balls, int share) {
        BigInteger n = BigInteger.ONE, m = BigInteger.ONE;

        int num1 = balls - share + 1;
        int num2 = share;

        for (long i = num1; i <= balls; i++) {
            n = n.multiply(BigInteger.valueOf(i));
        }

        for (long i = 2L; i <= num2; i++) {
            m = m.multiply(BigInteger.valueOf(i));
        }

        System.out.println("n = " + n);
        System.out.println("m = " + m);
        return n.divide(m);
    }
}