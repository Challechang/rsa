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
        BigInteger num = new BigInteger("5700734181645378434561188374130529072194886062117");
        System.out.println(num.isProbablePrime(10000));
    }

    @Test
    public void testGeneratePrime() {
        for (int i = 0; i < 1000; i++) {
            BigInteger prime = new BigInteger(5, 16, new Random());

            System.out.println(prime.toString());
        }

    }

}
