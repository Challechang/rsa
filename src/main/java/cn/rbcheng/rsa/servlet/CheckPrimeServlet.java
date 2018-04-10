package cn.rbcheng.rsa.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by rbcheng on 18-4-10.
 * Email: rbcheng@qq.com
 */
public class CheckPrimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sNum = req.getParameter("num");

        if (sNum == null) {
            System.err.println("sNum is Null.");
        } else {
            System.out.println("sNum: " + sNum);
        }

        BigInteger num = new BigInteger(sNum);

        System.out.println("num: " + num.toString());
        resp.getWriter().print("num: " + num.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
