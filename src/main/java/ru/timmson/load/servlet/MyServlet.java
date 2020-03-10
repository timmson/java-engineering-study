package ru.timmson.load.servlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/**"}
)
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Request has received");
        ServletOutputStream out = resp.getOutputStream();
        out.write("ok".getBytes());
        out.flush();
        out.close();
        System.out.println("Response has received");
    }
}
