package ru.timmson.load.servlet;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class ServerInstance {

    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("temp");
        tomcat.setPort(8080);

        String contextPath = "/";
        String docBase = new File("src/main/webapp").getAbsolutePath();

        Context context = tomcat.addContext(contextPath, docBase);

        String servletName = "MyServlet";
        String urlPattern = "/";

        tomcat.addServlet(contextPath, servletName, new MyServlet());
        context.addServletMappingDecoded(urlPattern, servletName);

        tomcat.start();
        tomcat.getServer().await();

    }


}
