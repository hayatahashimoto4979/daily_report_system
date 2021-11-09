<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="constants.AttributeConst"%>
<%@ page import="constants.ForwardConst"%>

<c:set var="action" value="${ForwardConst.ACT_CLI.getValue()}" />
<c:set var="action" value="${ForwardConst.CMD_INDEX.getValue()}" />

<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" />
            <br />
        </c:forEach>
    </div>
</c:if>
<label for="${AttributeConst.CLI_CODE.getValue()}">お客様番号</label>
<br />
<input type="text" name="${AttributeConst.CLI_CODE.getValue()}"
    value="${client.code}" />
<br />
<br />

<label for="${AttributeConst.CLI_NAME.getValue()}">会社名</label>
<br />
<input type="text" name="${AttributeConst.CLI_NAME.getValue()}"
    value="${client.name}" />
<br />
<br />

<label for="${AttributeConst.CLI_CONTENT.getValue()}">事業内容</label>
<br />
<input type="text" name="${AttributeConst.CLI_CONTENT.getValue()}"
    value="${client.content}" />
<br />
<br />

<label for="${AttributeConst.CLI_EMPLOYEE.getValue()}">担当者名</label>
<br />
<select name="id">
    <c:forEach var="employee" items="${employees}">
        <option value="${employee.id}"<c:if test="${employee.id == selected_id.id}">selected</c:if>>${employee.name}</option>
    </c:forEach>
</select>
<br />
<br />


<label for="${AttributeConst.CLI_AVE_SALE.getValue()}">月間平均売上</label>
<br />
<input type="text" name="${AttributeConst.CLI_AVE_SALE.getValue()}"
    value="${client.average_sales}" />
<br />
<br />

<label for="${AttributeConst.CLI_TEXT.getValue()}">メモ</label>
<br />
<input type="text" name="${AttributeConst.CLI_TEXT.getValue()}"
    value="${client.text}" />
<br />
<br />

<input type="hidden" name="${AttributeConst.CLI_ID.getValue()}"
    value="${client.id}" />
<input type="hidden" name="${AttributeConst.TOKEN.getValue()}"
    value="${_token}" />
<button type="submit">投稿</button>