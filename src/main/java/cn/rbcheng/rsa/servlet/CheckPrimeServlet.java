package cn.rbcheng.rsa.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;

import static cn.rbcheng.rsa.servlet.Utils.*;

/**
 * Created by rbcheng on 18-4-10.
 * Email: rbcheng@qq.com
 */
public class CheckPrimeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sNum = req.getParameter("num");

        if (isNull(sNum)) {
            resp.getWriter().print(NOT_NUMBER);
            return;
        }

        try {
            BigInteger num = new BigInteger(sNum);

            if (num.isProbablePrime(CERTAINTY)) {
                // num is Prime
                resp.getWriter().print(IS_PRIME);
            } else {
                resp.getWriter().print(NOT_PRIME);
            }

        } catch (NumberFormatException e) {
            // sNum is Not a Number
            resp.getWriter().print(NOT_NUMBER);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
