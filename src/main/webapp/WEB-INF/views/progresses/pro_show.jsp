<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.ForwardConst" %>

<c:set var="actOpp" value="${ForwardConst.ACT_OPP.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commProEdt" value="${ForwardConst.CMD_PRO_EDIT.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">

        <h2>商談状況 詳細ページ</h2>

        <table>
            <tbody>
                <tr>
                    <th>担当者名</th>
                    <td><c:out value="${progress.employee.name}" /></td>
                </tr>
                <tr>
                    <th>会社名</th>
                    <td><c:out value="${progress.client.name}" /></td>
                </tr>
                <tr>
                    <th>商談タイトル</th>
                    <td><c:out value="${progress.opportunity.title}" /></td>
                </tr>
                <tr>
                    <th>日付</th>
                    <fmt:parseDate value="${progress.progressDate}" pattern="yyyy-MM-dd" var="progressDay" type="date" />
                    <td><fmt:formatDate value='${progressDay}' pattern='yyyy-MM-dd' /></td>
                </tr>
                <tr>
                    <th>商談項目</th>
                    <td><c:out value="${progress.item}" /></td>
                </tr>
                <tr>
                    <th>見込ランク</th>
                    <td><c:out value="${progress.prospect}" /></td>
                </tr>
                <tr>
                    <th>商談状況</th>
                    <td><c:out value="${progress.status}" /></td>
                </tr>
                <tr>
                    <th>商談内容</th>
                    <td><pre><c:out value="${progress.content}" /></pre></td>
                </tr>
            </tbody>
        </table>

        <c:if test="${sessionScope.login_employee.id == progress.employee.id}">
            <p>
                <a href="<c:url value='?action=${actOpp}&command=${commProEdt}&id=${progress.id}' />">この商談状況を編集する</a>
            </p>
        </c:if>

        <p>
            <a href="<c:url value='?action=${actOpp}&command=${commIdx}' />">一覧に戻る</a>
        </p>
    </c:param>
</c:import>