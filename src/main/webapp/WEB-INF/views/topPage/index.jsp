<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.ForwardConst"%>
<%@ page import="constants.AttributeConst"%>

<c:set var="actEmp" value="${ForwardConst.ACT_EMP.getValue()}" />
<c:set var="actRep" value="${ForwardConst.ACT_REP.getValue()}" />
<c:set var="actCli" value="${ForwardConst.ACT_CLI.getValue()}" />
<c:set var="actOpp" value="${ForwardConst.ACT_OPP.getValue()}" />

<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />

<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>日報管理システムへようこそ</h2>
        <ul id="menu">
            <c:if
                test="${sessionScope.login_employee.adminFlag == AttributeConst.ROLE_ADMIN.getIntegerValue()}">
                <li><a
                    href="<c:url value='?action=${actEmp}&command=${commIdx}' />">・従業員管理</a></li>

            </c:if>
            <li><a
                href="<c:url value='?action=${actCli}&command=${commIdx}' />">・顧客管理</a></li>
            <li><a
                href="<c:url value='?action=${actRep}&command=${commIdx}' />">・日報管理</a></li>
            <li><a
                href="<c:url value='?action=${actOpp}&command=${commIdx}' />">・商談管理</a></li>

        </ul>
    </c:param>
</c:import>