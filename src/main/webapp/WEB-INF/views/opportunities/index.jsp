<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.ForwardConst"%>

<c:set var="actOpp" value="${ForwardConst.ACT_OPP.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commShow" value="${ForwardConst.CMD_SHOW.getValue()}" />
<c:set var="commProShow" value="${ForwardConst.CMD_PRO_SHOW.getValue()}" />
<c:set var="commNew" value="${ForwardConst.CMD_NEW.getValue()}" />
<c:set var="commProNew" value="${ForwardConst.CMD_PRO_NEW.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>商談 一覧</h2>
        <table id="opportunity_list">
            <tbody>
                <tr>
                    <th class="opportunity_client_code">お客様番号</th>
                    <th class="opportunity_client_name">会社名</th>
                    <th class="opportunity_employee">担当者名</th>
                    <th class="opportunity_title">商談タイトル</th>
                    <th class="opportunity_action">操作</th>
                </tr>
                <c:forEach var="opportunity" items="${opportunities}"
                    varStatus="status">

                    <tr class="row${status.count % 2}">
                        <td class="opportunity_client_code"><c:out
                                value="${opportunity.client.code}" /></td>
                        <td class="opportunity_client_name"><c:out
                                value="${opportunity.client.name}" /></td>
                        <td class="opportunity_employee"><c:out
                                value="${opportunity.employee.name}" /></td>
                        <td class="opportunity_title">${opportunity.title}</td>
                        <td class="opportunity_action"><a
                            href="<c:url value='?action=${actOpp}&command=${commShow}&id=${opportunity.id}' />">詳細を見る</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${opportunities_count} 件）<br />
            <c:forEach var="i" begin="1"
                end="${((opportunities_count - 1) / maxRow) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a
                            href="<c:url value='?action=${actOpp}&command=${commIdx}&page=${i}' />"><c:out
                                value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p>
            <a href="<c:url value='?action=${actOpp}&command=${commNew}' />">新規商談の登録</a>
        </p>

        <h2>商談状況 一覧</h2>
        <table id="progress_list">
            <tbody>
                <tr>
                    <th class="progress_name">担当者</th>
                    <th class="progress_client">会社名</th>
                    <th class="progress_title">商談タイトル</th>
                    <th class="progress_date">日付</th>
                    <th class="progress_item">商談項目</th>
                    <th class="progress_prospect">見込ランク</th>
                    <th class="progress_status">商談状況</th>
                    <th class="progress_action">操作</th>
                </tr>
                <c:forEach var="progress" items="${progresses}" varStatus="status">
                    <fmt:parseDate value="${progress.progressDate}"
                        pattern="yyyy-MM-dd" var="progressDay" type="date" />


                    <tr class="row${status.count % 2}">
                        <td class="progress_name"><c:out
                                value="${progress.employee.name}" /></td>
                        <td class="progress_client"><c:out
                                value="${progress.client.name}" /></td>
                        <td class="progress_title"><c:out
                                value="${progress.opportunity.title}" /></td>
                        <td class="progress_date"><fmt:formatDate
                                value='${progressDay}' pattern='yyyy-MM-dd' /></td>
                        <td class="progress_item">${progress.item}</td>
                        <td class="progress_prospect">${progress.prospect}</td>
                        <td class="progress_status">${progress.status}</td>

                        <td class="progress_action"><a
                            href="<c:url value='?action=${actOpp}&command=${commProShow}&id=${progress.id}' />">詳細を見る</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${progresses_count} 件）<br />
            <c:forEach var="i" begin="1"
                end="${((progresses_count - 1) / maxRow) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a
                            href="<c:url value='?action=${actPro}&command=${commIdx}&page=${i}' />"><c:out
                                value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p>
            <a href="<c:url value='?action=${actOpp}&command=${commProNew}' />">新規商談状況の登録</a>
        </p>

    </c:param>
</c:import>