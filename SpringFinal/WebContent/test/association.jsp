<%@page import="com.study.springfinal.domain.Emp"%>
<%@page import="com.study.springfinal.domain.Dept"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.study.springfinal.mybatis.config.MybatisConfigManager"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%!
	MybatisConfigManager manager = MybatisConfigManager.getInstance();
%>
<%
	//service 메서드 영역
	SqlSession sqlSession = manager.getSqlSession();
	
	List<Emp> list=sqlSession.selectList("Emp.selectAll");
	out.print("검색된 총사원수는"+list.size());

%>
