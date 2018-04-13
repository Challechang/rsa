package cn.rbcheng.rsa.servlet;

import java.math.BigInteger;

/**
 * Created by rbcheng on 18-4-11.
 * Email: rbcheng@qq.com
 */
public class Utils {

    public static final short NOT_NUMBER = -1;
    public static final short TEXT_EMPTY = -3;
    public static final short NOT_PRIME = 0;
    public static final short IS_PRIME = 1;
    public static final int CERTAINTY = 64;
    public static final int PRIME_BIT_LENGTH = 128;
    public static final short LEGAL_PUBLIC_KEY = 1;
    public static final short ILLEGAL_PUBLIC_KEY = 0;
    public static final String PUBLIC_KEY_NOT_EXIST = "-2";
    public static final BigInteger TWO = new BigInteger("2");
    public static final BigInteger NEGATIVE_ONE = new BigInteger("-1");
    public static final int EQUAL = 0;
    public static final int GREATER_THAN = 1;

    public static <T> boolean isNull(T o) {
        if (o == null) {
//            System.err.println(o.getClass().getSimpleName() + " is Null.");
            return true;
        } else {
            return false;
        }
    }
}
