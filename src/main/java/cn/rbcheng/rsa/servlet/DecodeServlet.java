package cn.rbcheng.rsa.servlet;

import cn.rbcheng.rsa.RSAImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;

import static cn.rbcheng.rsa.servlet.Utils.NOT_NUMBER;
import static cn.rbcheng.rsa.servlet.Utils.TEXT_EMPTY;
import static cn.rbcheng.rsa.servlet.Utils.isNull;

public class DecodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sPublicKey = req.getParameter("rsa_e");
        String sRsaP = req.getParameter("rsa_p");
        String sRsaQ = req.getParameter("rsa_q");
        String sRsaCiphertext = req.getParameter("rsa_ciphertext");

        if (isNull(sPublicKey) | isNull(sRsaP) | isNull(sRsaQ)) {
            resp.getWriter().print(Integer.toString(NOT_NUMBER));
            return;
        }

        if (isNull(sRsaCiphertext) || sRsaCiphertext.isEmpty()) {
            resp.getWriter().print(Integer.toString(TEXT_EMPTY));
            return;
        }

        try {
            BigInteger publicKey = new BigInteger(sPublicKey);
            BigInteger rsaP = new BigInteger(sRsaP);
            BigInteger rsaQ = new BigInteger(sRsaQ);

            RSAImpl rsa = new RSAImpl(rsaP, rsaQ, publicKey);
            String plaintext = rsa.decrypt(sRsaCiphertext);
            String respText = "Plaintext: " + plaintext;
            resp.getWriter().print(respText);
        } catch (NumberFormatException e) {
            resp.getWriter().print(Integer.toString(NOT_NUMBER));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
