<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.ForwardConst"%>


<c:set var="actOpp" value="${ForwardConst.ACT_OPP.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commEdt" value="${ForwardConst.CMD_EDIT.getValue()}" />
<c:set var="commShow" value="${ForwardConst.CMD_SHOW.getValue()}" />
<c:set var="commNew" value="${ForwardConst.CMD_NEW.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">

        <h2>商談 詳細ページ</h2>

        <table>
            <tbody>
                <tr>
                    <th>お客様番号</th>
                    <td><c:out value="${opportunity.client.code}" /></td>
                </tr>
                <tr>
                    <th>会社名</th>
                    <td><c:out value="${opportunity.client.name}" /></td>
                </tr>
                <tr>
                    <th>担当者名</th>
                    <td><c:out value="${opportunity.employee.name}" /></td>
                </tr>
                <tr>
                    <th>商談タイトル</th>
                    <td><c:out value="${opportunity.title}" /></td>
                </tr>
                <tr>
                    <th>登録日時</th>
                    <fmt:parseDate value="${opportunity.createdAt}"
                        pattern="yyyy-MM-dd'T'HH:mm:ss" var="createDay" type="date" />
                    <td><fmt:formatDate value="${createDay}"
                            pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
                <tr>
                    <th>更新日時</th>
                    <fmt:parseDate value="${opportunity.updatedAt}"
                        pattern="yyyy-MM-dd'T'HH:mm:ss" var="updateDay" type="date" />
                    <td><fmt:formatDate value="${updateDay}"
                            pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
            </tbody>
        </table>


        <p>
            <a
                href="<c:url value='?action=${actOpp}&command=${commEdt}&id=${opportunity.id}' />">この日報を編集する</a>
        </p>


        <p>
            <a href="<c:url value='?action=${actOpp}&command=${commIdx}' />">一覧に戻る</a>
        </p>


    </c:param>
</c:import>