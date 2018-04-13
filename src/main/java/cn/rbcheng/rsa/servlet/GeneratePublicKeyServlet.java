package cn.rbcheng.rsa.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

import static cn.rbcheng.rsa.servlet.Utils.*;

/**
 * Created by rbcheng on 18-4-11.
 * Email: rbcheng@qq.com
 */
public class GeneratePublicKeyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sRsaP = req.getParameter("rsa_p");
        String sRsaQ = req.getParameter("rsa_q");

        if (isNull(sRsaP) || isNull(sRsaQ)) {
            resp.getWriter().print(Integer.toString(NOT_NUMBER));
            return;
        }

        try {
            BigInteger rsaP = new BigInteger(sRsaP);
            BigInteger rsaQ = new BigInteger(sRsaQ);

            BigInteger phi = rsaP.subtract(BigInteger.ONE).multiply(rsaQ.subtract(BigInteger.ONE));

            if (phi.bitLength() == 2) {
                if (phi.compareTo(TWO) == EQUAL) {
                    resp.getWriter().print(PUBLIC_KEY_NOT_EXIST);
                } else {
                    resp.getWriter().print(TWO.toString());
                }
            } else {
                BigInteger publicKey = NEGATIVE_ONE;
                for (BigInteger t = phi.subtract(BigInteger.ONE); t.compareTo(BigInteger.ONE) == GREATER_THAN; t.subtract(BigInteger.ONE)) {
                    if (t.gcd(phi).equals(BigInteger.ONE)) {
                        publicKey = t;
                        break;
                    }
                }
                if (publicKey.compareTo(NEGATIVE_ONE) == EQUAL) {
                    resp.getWriter().print(PUBLIC_KEY_NOT_EXIST);
                } else {
                    resp.getWriter().print(publicKey.toString());
                }
            }
        } catch (NumberFormatException e) {
            resp.getWriter().print(Integer.toString(NOT_NUMBER));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
