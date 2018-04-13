package cn.rbcheng.rsa.test;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by rbcheng on 18-4-11.
 * Email: rbcheng@qq.com
 */
public class TestAll {

    @Test
    public void testBigInteger() {
        String s = null;
        BigInteger num = new BigInteger("-1");
        System.out.println(num.isProbablePrime(10000));
    }

    @Test
    public void testGeneratePrime() {
        for (int i = 0; i < 1; i++) {
            BigInteger prime = new BigInteger("2");
            for (int j = 0; j < 1000; j++) {

                System.out.println("big len: " + prime.bitLength());
                System.out.println("bit count: " + prime.bitCount());
                System.out.println(prime);
                prime = prime.nextProbablePrime();
            }
//            System.out.println(prime.toString());
        }

    }

}
