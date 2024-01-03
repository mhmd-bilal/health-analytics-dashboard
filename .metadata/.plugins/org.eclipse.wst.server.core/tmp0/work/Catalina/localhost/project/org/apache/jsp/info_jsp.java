/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.12
 * Generated at: 2023-12-07 18:12:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import project.SleepCalculator;
import project.CaloriesCalculator;
import project.IllnessCalculator;

public final class info_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("project.SleepCalculator");
    _jspx_imports_classes.add("project.CaloriesCalculator");
    _jspx_imports_classes.add("project.IllnessCalculator");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("  \r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("      <html>\r\n");
      out.write("\r\n");
      out.write("      <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <title>Your Health Dashboard</title>\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Montserrat\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles2.css\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">	\r\n");
      out.write("        <script>\r\n");
      out.write("          // Use fetch to trigger the SleepAnalyticsServlet on page load\r\n");
      out.write("          function fetchSleepAnalytics() {\r\n");
      out.write("            fetch('SleepAnalyticsServlet')\r\n");
      out.write("              .then(response => response.text())\r\n");
      out.write("              .then(data => {\r\n");
      out.write("                // Optional: You can add logic to update the UI based on the response from the servlet\r\n");
      out.write("                console.log(data);\r\n");
      out.write("              })\r\n");
      out.write("              .catch(error => {\r\n");
      out.write("                console.error('Error:', error);\r\n");
      out.write("              });\r\n");
      out.write("          }          \r\n");
      out.write("          function submitForm() {\r\n");
      out.write("            var inputValue = document.getElementById(\"inputValue\").value;\r\n");
      out.write("\r\n");
      out.write("            fetch('SaveToDatabaseServlet', {\r\n");
      out.write("              method: 'POST',\r\n");
      out.write("              headers: {\r\n");
      out.write("                'Content-Type': 'application/x-www-form-urlencoded',\r\n");
      out.write("              },\r\n");
      out.write("              body: 'inputValue=' + encodeURIComponent(inputValue),\r\n");
      out.write("            })\r\n");
      out.write("              .then(response => response.json())\r\n");
      out.write("              .then(data => {\r\n");
      out.write("                alert(data.message);\r\n");
      out.write("                if (data.recordAdded) {\r\n");
      out.write("                  alert('Record added successfully!');\r\n");
      out.write("                }\r\n");
      out.write("              })\r\n");
      out.write("              .catch(error => {\r\n");
      out.write("                console.error('Error:', error);\r\n");
      out.write("              });\r\n");
      out.write("          }\r\n");
      out.write("\r\n");
      out.write("          function redirectToAddRecordPage() {\r\n");
      out.write("            window.location.href = 'addrecord.jsp';\r\n");
      out.write("          }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("      </head>\r\n");
      out.write("      <body style=\"overflow:hidden\">\r\n");
      out.write("      <div class=\"sidenav\">\r\n");
      out.write("    <a href=\"#\" style=\"padding-bottom: 100px;padding-left: 10px;\"><img style=\"width: 95%;filter: brightness(1);\" src=\"logo.png\"></a>\r\n");
      out.write("    <a href=\"index2.jsp\"><img src=\"dashboard.png\"></a>\r\n");
      out.write("    <a href=\"add.jsp\"><img src=\"add.png\"></a>\r\n");
      out.write("    <a href=\"anal.jsp\"><img src=\"anal.png\"></a>\r\n");
      out.write("    <a class=\"active\" href=\"info.jsp\"><img src=\"info.png\"></a>\r\n");
      out.write("  </div>\r\n");
      out.write("        <div style=\"font-spacing:1px;margin-top:100px;height: fit-content;\" class=\"main\">\r\n");
      out.write("              <img src=\"infograhic.png\" class=\"infograhic\" height=\"400px\" ></p>  \r\n");
      out.write("        \r\n");
      out.write("                  <h2 style=\"font-weight: bolder;\">Welcome to Vita+ - Your Personal Health Companion!</h2>\r\n");
      out.write("<p style=\"font-weight: bold;font-style:italic;font-size: 20px;;\"><img src=\"help.png\" style=\"margin-bottom:-5px;height:25px;filter: invert(100%)\"> What is Vita+</p>\r\n");
      out.write("Vita+ isn't just an app; it's your 24/7 health companion, always ready to assist you on your wellness journey. Let's dive into the incredible features that make Vita+ the must-have app for a healthier, happier you!\r\n");
      out.write("\r\n");
      out.write("<p style=\"font-weight: bold;font-style:italic;font-size: 20px;\"><img src=\"health.png\" style=\"margin-bottom:-5px;height:25px;filter: invert(100%)\"> Health Tracking for Holistic Well-being!</p>\r\n");
      out.write("<p>Say goodbye to groggy mornings and hello to refreshing wake-ups! Vita+ intelligently tracks your sleep patterns, offering insights to help you optimize your bedtime routine. Eating well is a form of self-respect, and Vita+ is here to guide you with our Calorie Counter, keeping tabs on your nutrition and helping you make informed choices. Life happens, and so do occasional sniffles. Vita+ monitors your health history, making it easier to spot patterns and track your wellness journey. Get back on your feet faster than ever because a good day starts with a good night's sleep and a well-fed body is a happy body!</p>\r\n");
      out.write("\r\n");
      out.write("<p style=\"font-weight: bold;font-style:italic;font-size: 20px;\"><img src=\"hmeter.png\" style=\"margin-bottom:-5px;height:25px;filter: invert(100%)\"> Health Meter - Your Personal Wellness Scoreboard!</p>\r\n");
      out.write("Combine the power of good sleep, balanced nutrition, and timely health insights into your very own Health Meter. It's not just a number; it's a reflection of your commitment to a healthier lifestyle!\r\n");
      out.write("\r\n");
      out.write("<p style=\"font-weight: bold;font-style:italic;font-size: 20px;\"><img src=\"us.png\" style=\"margin-bottom:-5px;height:25px;filter: invert(100%)\"> Why Vita+?</p>\r\n");
      out.write("Vita+ isn't just an app; it's a lifestyle upgrade. We believe that small, consistent steps lead to significant transformations. Vita+ is here to empower you to make those steps with confidence, knowledge, and a touch of fun!\r\n");
      out.write("\r\n");
      out.write("<p style=\"font-weight: bold;font-style:italic;font-size: 20px;\">Your Journey to Better Health Starts Here!\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("  <div class=\"main\" style=\"text-align: center;margin-top: 5px;\">\r\n");
      out.write("    <h2 style=\"font-weight: 400;\">Team Members</h2>\r\n");
      out.write("    <div class=\"choose\">\r\n");
      out.write("        <div class=\"choose-card\" style=\"height: 80%;\">\r\n");
      out.write("        <a class=\"choose-btn\" href=\"https://www.linkedin.com/in/rithisnaha/\" ><img src=\"1.png\" style=\"margin-top:-20px;border-radius:50%\"></a>\r\n");
      out.write("    </div>\r\n");
      out.write("        <div class=\"choose-card\" style=\"height: 80%;\">\r\n");
      out.write("        <a class=\"choose-btn\" href=\"https://www.linkedin.com/in/mohammed-bilal-3640991a7/\"><img src=\"2.png\" style=\"border-radius:50%\"></a>\r\n");
      out.write("    </div>\r\n");
      out.write("        <div class=\"choose-card\" style=\"height: 80%;\">\r\n");
      out.write("        <a class=\"choose-btn\" href=\"https://www.linkedin.com/in/lalith-kumaresan-50a994272/\")\"><img src=\"3.png\" style=\"border-radius:50%\"></a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("      </body>\r\n");
      out.write("\r\n");
      out.write("      </html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}