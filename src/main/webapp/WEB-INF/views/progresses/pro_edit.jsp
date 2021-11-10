<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="constants.ForwardConst" %>

<c:set var="actPro" value="${ForwardConst.ACT_OPP.getValue()}" />
<c:set var="commProUpd" value="${ForwardConst.CMD_PRO_UPDATE.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">

        <h2>日報 編集ページ</h2>
        <form method="POST" action="<c:url value='?action=${actPro}&command=${commProUpd}' />">
            <c:import url="pro_form.jsp" />
        </form>

        <p>
            <a href="<c:url value='?action=Opportunity&command=index' />">一覧に戻る</a>
        </p>
    </c:param>
</c:import>