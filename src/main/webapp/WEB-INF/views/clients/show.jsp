<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.ForwardConst"%>

<c:set var="actCli" value="${ForwardConst.ACT_CLI.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commEdt" value="${ForwardConst.CMD_EDIT.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <h2>顧客情報 詳細ページ</h2>

        <table>
            <tbody>
                <tr>
                    <th>お客様番号</th>
                    <td><c:out value="${client.code}" /></td>
                </tr>
                <tr>
                    <th>会社名</th>
                    <td><c:out value="${client.name}" /></td>
                </tr>
                <tr>
                    <th>事業内容</th>
                    <td><c:out value="${client.content}" /></td>
                </tr>
                <tr>
                    <th>担当者名</th>
                    <td><c:out value="${client.employeeRepresentative.name}" /></td>
                </tr>
                <tr>
                    <th>月間平均売上</th>
                    <td><c:out value="${client.average_sales}" /></td>
                </tr>
                <tr>
                    <th>メモ</th>
                    <td><c:out value="${client.text}" /></td>
                </tr>
                <tr>
                    <th>登録日時</th>
                    <fmt:parseDate value="${client.createdAt}"
                        pattern="yyyy-MM-dd'T'HH:mm:ss" var="createDay" type="date" />
                    <td><fmt:formatDate value="${createDay}"
                            pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
                <tr>
                    <th>更新日時</th>
                    <fmt:parseDate value="${client.updatedAt}"
                        pattern="yyyy-MM-dd'T'HH:mm:ss" var="updateDay" type="date" />
                    <td><fmt:formatDate value="${updateDay}"
                            pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
            </tbody>
        </table>
        <p>
            <a
                href="<c:url value='?action=${actCli}&command=${commEdt}&cli_id=${client.id}' />">この顧客情報を編集する</a>
        </p>
        <p>
            <a href="<c:url value='?action=${actCli}&command=${commIdx}' />">一覧に戻る</a>
        </p>
    </c:param>
</c:import>