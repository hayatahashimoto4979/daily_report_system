<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="constants.AttributeConst" %>

<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<label for="${AttributeConst.OPP_CLIENT.getValue()}">お客様番号</label><br />
<br />
<select name="cli_id">
    <c:forEach var="client" items="${clients}">
        <option value="${client.id}"<c:if test="${client.id == selected_id.id}">selected</c:if>>${client.code}</option>
    </c:forEach>
</select>
<br /><br />

<label for="name">担当者名</label><br />
<c:out value="${sessionScope.login_employee.name}" />
<br /><br />

<label for="${AttributeConst.OPP_TITLE.getValue()}">商談タイトル</label><br />
<input type="text" name="${AttributeConst.OPP_TITLE.getValue()}" value="${opportunity.title}" />
<br /><br />


<input type="hidden" name="${AttributeConst.OPP_ID.getValue()}" value="${opportunity.id}" />
<input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
<button type="submit">投稿</button>