<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<label for="name">担当者名</label><br />
<c:out value="${sessionScope.login_employee.name}" />
<br /><br />

<label for="${AttributeConst.PRO_CLI.getValue()}">会社名</label><br />
<br />
<select name="cli_id">
    <c:forEach var="client" items="${clients}">
        <option value="${client.id}"<c:if test="${client.id == selected_id.id}">selected</c:if>>${client.name}</option>
    </c:forEach>
</select>
<br /><br />

<label for="${AttributeConst.PRO_OPP.getValue()}">商談タイトル</label><br />
<br />
<select name="id">
    <c:forEach var="opportunity" items="${opportunities}">
        <option value="${opportunity.id}"<c:if test="${opportunity.id == selected_id.id}">selected</c:if>>${opportunity.title}</option>
    </c:forEach>
</select>
<br /><br />

<fmt:parseDate value="${progress.progressDate}" pattern="yyyy-MM-dd" var="progressDay" type="date" />
<label for="${AttributeConst.PRO_DATE.getValue()}">日付</label><br />
<input type="date" name="${AttributeConst.PRO_DATE.getValue()}" value="<fmt:formatDate value='${progressDay}' pattern='yyyy-MM-dd' />" />
<br /><br />


<label for="${AttributeConst.PRO_ITEM.getValue()}">商談項目</label><br />
<input type="text" name="${AttributeConst.PRO_ITEM.getValue()}" value="${progress.item}" />
<br /><br />

<label for="${AttributeConst.PRO_PROSPECT.getValue()}">見込ランク</label><br />
<br />
<select name="prospect">
    <option value="A">A</option>
    <option value="B">B</option>
    <option value="C">C</option>
    <option value="D">D</option>
</select>
<br /><br />

<label for="${AttributeConst.PRO_STATUS.getValue()}">見込ランク</label><br />
<br />
<select name="status">
    <option value="引き合い">引き合い</option>
    <option value="見積提案">見積提案</option>
    <option value="商談中">商談中</option>
    <option value="受注">受注</option>
    <option value="失注">失注</option>
</select>
<br /><br />

<label for="${AttributeConst.PRO_CONTENT.getValue()}">商談内容</label><br />
<textarea name="${AttributeConst.PRO_CONTENT.getValue()}" rows="10" cols="50">${progress.content}</textarea>
<br /><br />
<input type="hidden" name="${AttributeConst.PRO_ID.getValue()}" value="${progress.id}" />
<input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
<button type="submit">投稿</button>