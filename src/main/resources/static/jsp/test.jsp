<%@page inport="entity.user" %>
<%@page inport="dao.userdao" %>
<%@page inport="java.util.ArrayList" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
response.setContentType("html/text");
response.setCharacterEncoding("utf-8");
//获取用户密码
request.setCharacterEncoding("utf-8");
//前端传过来的数据
String name=request.getParameter("name");
String id=request.getParameter("pass");
out.clear();
entity.user a=new entity.user();
dao.userdao b=new dao.userdao();
b.getalluserinfo();

 %>
 