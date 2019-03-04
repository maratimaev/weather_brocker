<%@ page import="com.caucho.hessian.client.HessianProxyFactory" %>
<%@ page import="ru.bellintegrator.MathService" %>
<%
    HessianProxyFactory factory = new HessianProxyFactory();

// http://localhost:8080/resin-doc/protocols/tutorial/hessian-service/hessian/math

    String url = ("http://localhost:8080/db_service/hessian/math");

//    String url = ("http://" +
//            request.getServerName() + ":" + request.getServerPort() +
//            request.getContextPath() + "/hessian/math");

    MathService math = (MathService) factory.create(MathService.class, url);

    out.println("3 + 2 = " + math.add(3, 2));
%>