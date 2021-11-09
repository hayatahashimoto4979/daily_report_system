<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.ForwardConst"%>

<c:set var="actCli" value="${ForwardConst.ACT_CLI.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commShow" value="${ForwardConst.CMD_SHOW.getValue()}" />
<c:set var="commNew" value="${ForwardConst.CMD_NEW.getValue()}" />


<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>顧客 一覧</h2>
        <table id="client_list">
            <tbody>
                <tr>
                    <th class="client_code">お客様番号</th>
                    <th class="client_name">会社名</th>
                    <th class="client_content">事業内容</th>
                    <th class="client_employeeRepresentative">担当者</th>
                    <th class="client_ave_sale">月下売上平均</th>
                    <th class="client_action">詳細</th>

                </tr>
                <c:forEach var="client" items="${clients}" varStatus="status">

                    <tr class="row${status.count % 2}">
                        <td class="client_code"><c:out value="${client.code}"></c:out></td>
                        <td class="client_name"><c:out value="${client.name}"></c:out></td>
                        <td class="client_content"><c:out value="${client.content}"></c:out></td>
                        <td class="client_employeeRepresentative"><c:out value="${client.employeeRepresentative.name}" /></td>
                        <td class="client_ave_sale"><c:out value="${client.average_sales}"></c:out></td>
                        <td class="client_action"><a href="<c:url value='?action=${actCli}&command=${commShow}&cli_id=${client.id}' />">詳細を見る</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${clients_count} 件）<br />
            <c:forEach var="i" begin="1"
                end="${((cients_count - 1) / maxRow) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a
                            href="<c:url value='?action=${actCli}&command=${commIdx}&page=${i}' />"><c:out
                                value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p>
            <a href="<c:url value='?action=${actCli}&command=${commNew}' />">新規顧客の登録</a>
        </p>
    </c:param>
</c:import>