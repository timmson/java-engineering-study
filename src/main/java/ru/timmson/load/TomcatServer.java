package ru.timmson.load;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class TomcatServer {

    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("temp");
        tomcat.setPort(8080);

        String contextPath = "/";
        String docBase = new File("src/main/webapp").getAbsolutePath();

        Context context = tomcat.addContext(contextPath, docBase);

        String servletName = "MyServlet";
        String urlPattern = "/";

        DoSomething doSomething = new DoSomething();
        tomcat.addServlet(contextPath, servletName, new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
                System.out.println(Thread.currentThread().getName() + "<--");
                ServletOutputStream out = resp.getOutputStream();
                doSomething.doSomething();
                out.write("ok".getBytes());
                out.flush();
                out.close();
                System.out.println(Thread.currentThread().getName() + "-->");
            }
        });
        context.addServletMapping(urlPattern, servletName);

        tomcat.start();
        tomcat.getServer().await();

    }


}
