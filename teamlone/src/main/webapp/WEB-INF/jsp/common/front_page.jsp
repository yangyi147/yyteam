<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%> 
<script type="text/javascript" src="${ctx}/static/common/web/js/page.js"></script>
<c:if test="${th != null && th.pages>0}">
	<div class="paging"> 
		<a href="javascript:goPage(1);" title="">首</a>
		<c:choose>
			<c:when test="${th.isFirstPage}">
				<a id="backpage" class="undisable" href="javascript:void(0)" title="">&lt;</a>
			</c:when>
			<c:otherwise>
				<a id="backpage" href="javascript:goPage(${th.pageNum-1 });" title="">&lt;</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${th.isLastPage}">
				<a id="nextpage"href="javascript:void(0)" title="" class="undisable">&gt;</a>
			</c:when>
			<c:otherwise>
				<a id="nextpage" href="javascript:goPage(${th.pageNum+1});" title="">&gt;</a>
			</c:otherwise>
		</c:choose>
		<a href="javascript:goPage(${th.total});" title="">末</a>
		<div class="clear"></div>
	</div>


</c:if>
<script type="text/javascript">
    var totalPageSize =${th.total};
    var currentPage =
    ${th.pageNum-1}<1 ? 1 :${th.pageNum};
    var totalPage = ${th.pages};
    showPageNumber();
</script>