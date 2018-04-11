package cn.rbcheng.rsa.servlet;

/**
 * Created by rbcheng on 18-4-11.
 * Email: rbcheng@qq.com
 */
public class Utils {

    public static final short NOT_NUMBER = -1;
    public static final short NOT_PRIME = 0;
    public static final short IS_PRIME = 1;
    public static final int CERTAINTY = 64;
    public static final short LEGAL_PUBLIC_KEY = 1;
    public static final short ILLEGAL_PUBLIC_KEY = 0;

    public static <T> boolean isNull(T o) {
        if (o == null) {
            System.err.println(o.getClass().getSimpleName() + " is Null.");
            return true;
        } else {
            return false;
        }
    }
}
