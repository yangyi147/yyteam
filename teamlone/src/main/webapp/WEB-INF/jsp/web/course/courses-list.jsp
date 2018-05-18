<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>课程列表</title>
<script type="text/javascript" src="/static/inxweb/front/course.js"></script>
</head> 
<body> 
	<div id="aCoursesList" class="bg-fa of">
		<!-- /课程列表 开始 -->
		<section class="container">

			<section class="c-sort-box">
				<section class="c-s-dl">
					<dl>
						<dt>
							<span class="c-999 fsize14">方向</span>
						</dt>
						<dd class="c-s-dl-li">
							<ul class="clearfix">
								<li ><a onclick="allCourse(0)" title="全部" >全部</a></li> 
								<c:forEach items="${allSubjict}" var="subject">
								<c:if test="${subject.pId==0}">
									<li class="current"><a onclick="allCourse(${subject.id})" title="${subject.name}" href="javascript:void(0)" style="color: black;">${subject.name}</a></li>
									</c:if>
								</c:forEach>
							</ul>
							<aside class="c-s-more">
								<a href="javascript: void(0)" title="" class="fsize14 c-master" style="color: black;">[展开]</a> 
							</aside>
						</dd>
					</dl>
					<dl>
						<dt>
							<span class="c-999 fsize14">分类</span>
						</dt>
						<dd class="c-s-dl-li">
							<ul class="clearfix">
								<li ><a onclick="allCoursebyFid(0)" title="全部" >全部</a></li>
								<c:forEach items="${allSubjectByChild}" var="subject">
									<li class="current"><a  href="javascript: void(0)" onclick="allCoursebyFid(${subject.id})" title="${subject.name}"  style="color: black;" >${subject.name}</a></li>
								</c:forEach>
							</ul>
							<aside class="c-s-more">
								<a href="javascript: void(0)" title="" class="fsize14 c-master" style="color: black;" >[展开]</a> 
							</aside>
						</dd>
					</dl>
					<c:if test="${sonSubjectList!=null&&sonSubjectList.size()>0 }">
                      	<dl>
							<dt>
								<span class="c-999 fsize14"></span>
							</dt>
							<dd class="c-s-dl-li">
								<ul class="clearfix">
									<c:forEach items="${sonSubjectList}" var="subject">
										<li <c:if test="${queryCourse.subjectId==subject.subjectId}">class="current"</c:if>><a onclick="submitForm(1,${subject.subjectId})" title="${subject.subjectName}" href="javascript:void(0)">${subject.subjectName}</a></li>
									</c:forEach>
								</ul>
								<aside class="c-s-more">
									<a href="javascript: void(0)" title="" class="fsize14 c-master">[展开]</a>
								</aside>
							</dd>
						</dl>
                    </c:if>
					<dl>
						<dt>
							<span class="c-999 fsize14">按讲师</span>
						</dt>
						<dd class="c-s-dl-li">
							<ul class="clearfix">
								<li class="current"><a onclick="teacher(0)" title="全部" href="javascript:void(0)" style="color: black;">全部</a></li>
								<c:forEach items="${allTeacherBySubjectId}" var="teacher">
									<li class="current"><a  href="javascript: void(0)" title="${teacher.name}" onclick="teacher(${teacher.id})" style="color: black;" >${teacher.name}</a></li>
								</c:forEach>
							</ul>
							<aside class="c-s-more">
								<a href="javascript: void(0)" title="" class="fsize14 c-master" style="color: black;">[展开]</a>
							</aside>
						</dd>
					</dl>
					<div class="clear"></div>
				</section>
				<div class="js-wrap">
					<section class="fr">
						<span class="c-ccc"> <tt class="c-master f-fM">${page.currentPage}</tt>/<tt class="c-666 f-fM">${page.totalPageSize}</tt>
						</span>
					</section>
					<section class="fl">
						<ol class="js-tap clearfix">
							<li <c:if test="${queryCourse.order=='FOLLOW'}">class="current bg-orange"</c:if>><a title="关注度" onclick="submitForm(3,'FOLLOW')" href="javascript:void(0)">关注度</a></li>
							<li <c:if test="${queryCourse.order=='NEW'}">class="current bg-orange"</c:if>><a title="最新" onclick="submitForm(3,'NEW')" href="javascript:void(0)">最新</a></li>
							<li <c:if test="${queryCourse.order=='ASCENDING'||queryCourse.order=='DESCENDING'}">class="current bg-orange"</c:if>><a title="价格" onclick="submitForm(4,'<c:if test="${not empty queryCourse.order}">${queryCourse.order }</c:if><c:if test="${empty queryCourse.order}">ONE</c:if>')" href="javascript:void(0)">价格<span><c:if test="${queryCourse.order=='ASCENDING' }">↑</c:if><c:if test="${queryCourse.order=='DESCENDING' }">↓</c:if></span></a></li>
						</ol>
					</section>
				</div>
				<div class="mt40">
					<c:if test="${empty allCourse}">
						<!-- /无数据提示 开始-->
						<section class="no-data-wrap">
							<em class="icon30 no-data-ico">&nbsp;</em> <span class="c-666 fsize14 ml10 vam">没有相关数据，小编正在努力整理中...</span>
						</section>
						<!-- /无数据提示 结束-->
					</c:if>
					<c:if test="${not empty allCourse}">
						<article class="comm-course-list">
							<ul class="of">
							
							
								<c:forEach items="${allCourse}" var="course" varStatus="index">
									<li>
										<div class="cc-l-wrap">
											<section class="course-img">
												<c:choose>
													<c:when test="${not empty course.logo }">
														<img xSrc="${course.logo}" src="${ctx }/static/inxweb/img/default-img.gif" class="img-responsive" alt="">
													</c:when>
													<c:otherwise>
														<img xSrc="/static/inxweb/img/default-img.gif" src="${ctx }/static/inxweb/img/default-img.gif" class="img-responsive" alt="">
													</c:otherwise>
												</c:choose>
												<div class="cc-mask">
													<a href="/front/courseKpoint/videoDetails/${course.course_id}" title="" class="comm-btn c-btn-1">开始学习</a>
												</div>
											</section>
											<h3 class="hLh30 txtOf mt10">
												<a href="${ctx}/front/couinfo/${course.course_id}" title="${course.course_name}" class="course-title fsize18 c-333">${course.course_name}</a>
											</h3>
											<section class="mt10 hLh20 of">
												<c:if test="${course.current_price=='0.00' }">
													<span class="fr jgTag bg-green"><tt class="c-fff fsize12 f-fA">免费</tt></span>
												</c:if>
												<c:if test="${course.current_price!='0.00' }">
													<span class="fr jgTag bg-orange"><tt class="c-fff fsize14 f-fG">￥${course.current_price }</tt></span>
												</c:if>
												<span class="fl jgAttr c-ccc f-fA"> <tt class="c-999 f-fA">${course.page_buycount }人学习</tt> | <tt class="c-999 f-fA">${course.page_vlewcount }浏览</tt>
												</span>
											</section>
										</div>
									</li>
								</c:forEach>
								
								
							</ul>
							<div class="clear"></div>
						</article>
					</c:if>
				</div>
				<!-- 公共分页 开始 -->
				<jsp:include page="/WEB-INF/jsp/common/front_page.jsp" />
				<!-- 公共分页 结束 -->
				
			</section>
		</section>
		<!-- /课程列表 结束 -->
	</div>
	<script>
	   var  sid='${sid }';
	   var tid='${teacher.id}';
	   var sfid='${sfid }';
		$(function() {
			cSortFun(); //分类更多按钮交互效果
			scrollLoad(); //响应滚动加载课程图片
		});
		//sort suMore
		var cSortFun = function() {
		    $(".c-s-dl>dl .c-s-more>a").each(function() {
		        var _this = $(this),
		            _uList = _this.parent().siblings("ul"),
		            _uLw = _uList.height();
		        if (_uLw <= "40") {
		            _this.hide();
		        } else {
		            _uList.css("height","40px");
		            _this.click(function() {
		                if(_this.html() == "[展开]") {
		                    _uList.css("height","auto");
		                    _this.text("[收起]");
		                } else {
		                    _uList.css("height" , "40px");
		                    _this.text("[展开]");
		                }
		            })
		        }
		    });
		}
		function allCourse(sid) {
			    window.location.href="/front/courseKpoint/listCourse?sid="+sid+"&sfid="+sfid+"&tid="+tid;	
		}
		function allCoursebyFid(sfid) {
			    window.location.href="/front/courseKpoint/listCourse?sid="+sid+"&sfid="+sfid+"&tid="+tid;	
		}
		function teacher(tid) {
			    window.location.href="/front/courseKpoint/listCourse?sid="+sid+"&sfid="+sfid+"&tid="+tid;	
			}
	</script>
</body>
<style>
a{
color: black;
}
</style>
</html>