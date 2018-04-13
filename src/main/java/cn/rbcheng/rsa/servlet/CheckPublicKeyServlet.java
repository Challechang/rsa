package cn.rbcheng.rsa.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;

import static cn.rbcheng.rsa.servlet.Utils.*;

/**
 * Created by rbcheng on 18-4-11.
 * Email: rbcheng@qq.com
 */
public class CheckPublicKeyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sPublicKey = req.getParameter("rsa_e");
        String sRsaP = req.getParameter("rsa_p");
        String sRsaQ = req.getParameter("rsa_q");

        if (isNull(sPublicKey) | isNull(sRsaP) | isNull(sRsaQ)) {
            resp.getWriter().print(NOT_NUMBER);
            return;
        }

        try {
            BigInteger publicKey = new BigInteger(sPublicKey);
            BigInteger rsaP = new BigInteger(sRsaP);
            BigInteger rsaQ = new BigInteger(sRsaQ);

            BigInteger phi = rsaP.subtract(BigInteger.ONE).multiply(rsaQ.subtract(BigInteger.ONE));

            if (phi.gcd(publicKey).equals(BigInteger.ONE)) {
                resp.getWriter().print(LEGAL_PUBLIC_KEY);
            } else {
                resp.getWriter().print(ILLEGAL_PUBLIC_KEY);
            }

        } catch (NumberFormatException e) {
            resp.getWriter().print(NOT_NUMBER);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
