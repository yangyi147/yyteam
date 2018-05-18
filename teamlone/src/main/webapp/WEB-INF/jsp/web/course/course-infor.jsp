<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE>
<html>
<head>
<title>${course.courseName}详情</title>
<script src="http://vod.baofengcloud.com/html/script/bfcloud.js?v=2"></script>
<script type="text/javascript" src="/static/common/ckplayer/ckplayer.js" charset="utf-8"></script>
<script type="text/javascript" src="/js/jquery-3.0.0.js"></script>
<script type="text/javascript">
	//var isok = ${isok};
	var isok=true;
	var currentprice=${courseByID.current_price};
	function getData(){
		var status=CKobject.getObjectById('ckplayer_a1').getStatus();
		//获取插件播放视频的时间何视频的总时间
		alert(status.time+","+status.totalTime);
	}
</script>
</head>
<body>
<!-- <input type="button" value="获取" id="btn" onclick="getData()"/> -->
	<div id="aCoursesList" class="bg-fa of">
		<!-- /课程详情 开始 -->
		<section class="container">
			<section class="path-wrap txtOf hLh30">
				<a href="${ctx }" title="" class="c-999 fsize14">首页</a>
				<a href="${ctx }/front/showcoulist" title="" class="c-999 fsize14">课程列表</a>
				 <span class="c-333 fsize14">${courseByID.course_name}</span>
			</section>
			<div>
				<article class="c-v-pic-wrap">
					<section class="p-h-video-box" id="videoPlay">
						<c:choose>
							<c:when test="${courseByID.logo!=null &&courseByID.logo!=''}">
								<img src="${courseByID.logo}" alt="${courseByID.course_name}" class="dis c-v-pic" />
							</c:when>
							<c:otherwise>
								<img src="${ctx}/static/inxweb/img/default-img.gif" alt="${courseByID.course_name}" class="dis c-v-pic" />
							</c:otherwise>
						</c:choose>
	
						<a href="javascript:void(0)" onclick="vedioClick(${freeVideoId})" title="${courseByID.course_name}" class="v-play-btn">
							<em class="icon30">&nbsp;</em>
						</a>
					</section>
					<section class="p-h-video-tip">
						<img src="${ctx }/static/inxweb/img/v-loading.gif">
						<p class="hLh20"><span class="c-999">${course.logo}加载中...</span></p>
					</section>
				</article>
				<aside class="c-attr-wrap">
					<section class="ml20 mr15">
						<h2 class="hLh30 txtOf mt15">
							<span class="c-fff fsize24">${courseByID.course_name}</span>
						</h2>
						<section class="c-attr-jg">
							<span class="c-fff">价格：</span><big class="c-yellow">￥${courseByID.current_price }</big> <span class="c-ccc ml10">原价：<s>￥${courseByID.source_price }</s></span>
						</section>
						<section class="c-attr-mt c-attr-undis">
							<span class="c-fff fsize14">主讲： <c:forEach items="${teacherById }" var="tea">
									<%-- <a href="${ctx}/front/teacher/${tea.id }">${tea.name }</a>&nbsp;&nbsp;&nbsp; --%>
									${tea.name }&nbsp;&nbsp;&nbsp; 
                      			</c:forEach>
							</span>
						</section>
						<section class="c-attr-mt c-attr-time">
							<span class="c-fff fsize14">课程有效期：
											<c:if test="${courseByID.losetype==1 }">
												<fmt:formatDate pattern="yyyy/MM/dd HH:mm"  value="${courseByID.end_time}" />
											</c:if>
											<c:if test="${courseByID.losetype==2 }">
													从购买之日起${courseByID.lose_time }天
												</span>
											</c:if>
							</span>
						</section>
						<section class="c-attr-mt">
									<a href="javascript:void(0)" title="立即观看" onclick="if(isLogin()){ window.location.href='/front/courseKpoint/chapterTranslation/${courseByID.course_id}'} else{lrFun();} " class="comm-btn c-btn-3">立即观看</a>
							<span class="ml10"><tt class="c-yellow f-fM">*咨询 ${websitemap.web.phone}</tt></span>
						</section>
						<section class="c-attr-mt of ml10">
							<section class="kcShare pr fl hand vam">
								<tt>
									<em class="icon18 shareIcon"></em><span class="vam c-fff f-fM">分享</span>
								</tt>
								<div id="bdshare" class="bdsharebuttonbox"><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_douban" data-cmd="douban" title="分享到豆瓣网"></a><a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a></div>
								<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
							</section>
							<c:if test="${isFavorites==true }">
										<span class="ml10 vam sc-end"><em class="icon18 scIcon"></em><a class="c-fff vam" title="收藏" onclick="" href="javascript:void(0)">已收藏</a></span>
									</c:if>
									<c:if test="${isFavorites!=true }">
										<span class="ml10 vam"><em class="icon18 scIcon"></em><a class="c-fff vam" title="收藏" onclick="favorites(${course.courseId},this)" href="javascript:void(0)">收藏</a></span>
									</c:if>
						</section>
					</section>
				</aside>
				<aside class="thr-attr-box">
					<ol class="thr-attr-ol clearfix">
						<li><p>&nbsp;</p>
							<aside>
								<span class="c-fff f-fM">购买数</span><br>
								<h6 class="c-fff f-fM mt10">${courseByID.page_buycount }</h6>
							</aside></li>
						<li><p>&nbsp;</p>
							<aside>
								<span class="c-fff f-fM">课时数</span><br>
								<h6 class="c-fff f-fM mt10">${courseByID.lession_num }</h6>
							</aside></li>
						<li><p>&nbsp;</p>
							<aside>
								<span class="c-fff f-fM">浏览数</span><br>
								<h6 class="c-fff f-fM mt10">${courseByID.page_vlewcount }</h6>
							</aside></li>
					</ol>
				</aside>
				<div class="clear"></div>
			</div>
			<!-- /课程封面介绍 -->
			<div class="mt20 c-infor-box">
				<article class="fl col-7">
					<section class="mr30">
						<div class="i-box">
							<div>
								<section id="c-i-tabTitle" class="c-infor-tabTitle c-tab-title">
									<a name="c-i" class="current" title="课程详情" href="javascript: void(0)">课程详情</a>
									<a name="c-g" title="课程大纲" href="javascript: void(0)">课程大纲</a>
									<a name="c-c" title="课程评论" href="javascript: void(0)">课程评论</a>
								</section>
							</div>
							<article class="ml10 mr10 pt20">
								<div>
									<h6 class="c-i-content c-infor-title">
										<span>课程介绍</span>
									</h6>
									<!-- /无数据提示 开始-->
									<c:if test="${empty courseByID.context}">
										<section class="no-data-wrap">
											<em class="icon30 no-data-ico">&nbsp;</em> <span class="c-666 fsize14 ml10 vam">没有相关数据，小编正在努力整理中...</span>
										</section>
									</c:if>
									<!-- /无数据提示 结束-->
									<c:if test="${not empty courseByID.context}">
										<div class="course-txt-body-wrap">
											<section class="course-txt-body">
												<p>${courseByID.context}</p>
											</section>
											<section class="ctb-btn"><a href="javascript: void(0)" class="comm-btn c-btn-6" title="查看更多">查看更多∨</a></section>
										</div>
									</c:if>
								</div>
								<!-- /课程介绍 -->
								<div class="mt50">
									<h6 class="c-g-content c-infor-title">
										<span>课程大纲</span>
									</h6>
									<section class="mt20">
										<div class="lh-menu-wrap">
											<menu id="lh-menu" class="lh-menu mt10 mr10">
												<ul>
													<c:set var="folderIndex" value="1"/>
													<c:forEach items="${courseKpoint }" var="parentKpoint" varStatus="index">
														<c:if test="${parentKpoint.kpoint_type==0 }"><!-- 文件目录 -->
															<li class="lh-menu-stair">
																<a href="javascript: void(0)" title="${parentKpoint.name }" 
																	<c:if test="${index.first==true}">class="current-1"</c:if>
																>
																	<span class="fr"><em class="icon14 m-tree-icon">&nbsp;</em></span><em class="lh-menu-i-1 icon24 mr5"><font>${folderIndex }</font></em>${parentKpoint.name }</a>
																<ol class="lh-menu-ol"  
																	<c:if test="${index.first==true}">style="display: block;"</c:if>
																	<c:if test="${index.first==false}">style="display: none;"</c:if>
																>
																	<c:forEach items="${courseKpoint}" var="sonKpoint"> 
                                                                        <c:if test="${sonKpoint.pId==parentKpoint.id }">
																		<li class="lh-menu-second ml30"><a href="javascript:void(0)" <%-- onclick="playVideo('${sonKpoint.videoUrl }',this)" --%> onclick="if(1==1){ window.location.href='/front/courseKpoint/chapterTranslation/${courseByID.course_id}?ckid=${sonKpoint.id}'} else{lrFun();} " title="">
																				<span class="fr"> 
																					<c:if test="${sonKpoint.is_free==1 }">
																						<tt class="free-icon vam mr10">免费试听</tt>
																					</c:if>
																					<c:if test="${!empty sonKpoint.play_time}">
																						<em class="lh-p-icon icon14 ml5">&nbsp;</em>
																						${sonKpoint.play_time}
																					</c:if>
																				</span><em class="lh-menu-i-2 icon14 mr5">&nbsp;</em>${sonKpoint.name }
																			</a>
																		</li>
																		</c:if>
 																  </c:forEach> 
																</ol>
															</li>
															<c:set var="folderIndex" value="${folderIndex+1 }"/>
														</c:if>
														<c:if test="${sonKpoint.kpoint_type==1 }"><!-- 视频 -->
															<li class="lh-menu-stair">
																<ul class="lh-menu-ol no-parent-node">
																	<li class="lh-menu-second"><a title="" <%-- onclick="playVideo('${parentKpoint.videoUrl }',this)" --%> onclick="getPlayerHtml(${sonKpoint.id },${sonKpoint.is_free },this)" href="javascript:void(0)">
																			<span class="fr"> 
																				<c:if test="${sonKpoint.is_free==1 }">
																					<tt class="free-icon vam mr10">免费试听</tt>
																				</c:if>
																				<c:if test="${!empty sonKpoint.play_time}">
																					<em class="lh-p-icon icon14 ml5">&nbsp;</em>
																					${sonKpoint.play_time}
																				</c:if>
																				</span><em class="lh-menu-i-2 icon14 mr5">&nbsp;</em>${sonKpoint.name }</a>
																	</li>
																</ul>
															</li>
														</c:if>
													</c:forEach>
												</ul>
											</menu>
										</div>
									</section>
								</div>
								<!-- /课程大纲 -->
								<div class="mt50 commentHtml"></div>
								<!-- /课程评论 -->
							</article>
						</div>
					</section>
				</article>
				<aside class="fl col-3">
					<div class="i-box">
						<div>
							<section class="c-infor-tabTitle c-tab-title">
								<a title="" href="javascript:void(0)">主讲讲师</a>
							</section>
							<section class="stud-act-list">
								<c:forEach items="${teacherById }" var="tea">
									<ul style="height: auto;">
										<li>
											<div class="u-face">
												<a href="${ctx }/front/teacher/${tea.id }">
													<c:choose>
														<c:when test="${not empty tea.pic_path }">
															<img src="<%=staticImage%>${tea.pic_path }" width="50" height="50" alt="">
														</c:when>
														<c:otherwise>
															<img src="${ctx }/static/inxweb/img/avatar-boy.gif" width="50" height="50" alt="">
														</c:otherwise>
													</c:choose>
												</a>
											</div>
											<section class="hLh30 txtOf">
												<a class="c-333 fsize16 fl" href="${ctx }/front/teacher/${tea.id }">${tea.name }</a>
											</section>
											<section class="hLh20 txtOf">
												<span class="c-999">${tea.education }</span>
											</section>
										</li>
									</ul>
									<%-- <div class="c-teacher-txt-show">
										<p>${tea.career }</p>
									</div> --%>
								</c:forEach>
							</section>
						</div>
					</div>
					<div class="i-box mt20">
						<div  id="courseLearnedUserDiv">
							<section class="c-infor-tabTitle c-tab-title">
								<a title="" href="javascript:void(0)">学过此课的人（0）</a>
							</section>
							<section class="no-data-wrap"><em class="icon30 no-data-ico">&nbsp;</em><span class="c-666 fsize14 ml10 vam">还没有人学过此课程，快去学习吧...</span></section>
						</div>
					</div>
					<div class="i-box mt20">
						<div>
							<section class="c-infor-tabTitle c-tab-title">
								<a title="" href="javascript:void(0)">猜你想学</a>
							</section>
							<c:if test="${empty sunjectNextAllCourse}">
								<section class="no-data-wrap">
									<em class="icon30 no-data-ico">&nbsp;</em> <span class="c-666 fsize14 ml10 vam">没有相关数据，小编正在整理中...</span>
								</section>
							</c:if>
							<c:if test="${not empty sunjectNextAllCourse}">
								<section class="course-r-list">
									<ol>
										<c:forEach items="${sunjectNextAllCourse}" var="interfixCourse">
											<li>
												<aside class="course-r-pic">
													<a href="${ctx }/front/couinfo/${interfixCourse.course_id}" title="">
														<c:choose>
															<c:when test="${interfixCourse.logo!=null && interfixCourse.logo!=''}">
																<img alt="" src="${interfixCourse.logo}" />
															</c:when>
															<c:otherwise>
																<img alt="" src="${ctx }/static/inxweb/img/default-img.gif" />
															</c:otherwise>
														</c:choose>
													</a>
												</aside>
												<section class="hLh20 txtOf">
													<a href="${ctx }/front/couinfo/${interfixCourse.course_id}" class="c-333 fsize16">${interfixCourse.course_name}</a>
												</section>
												<section class="hLh20 mt5 txtOf">
													<span class="c-999">讲师： <c:if test="${interfixCourse.teacher!=null && interfixCourse.teacher.size()>0}">
															<c:forEach items="${interfixCourse.teacher}" var="teacher">
																	${teacher.name}&nbsp;&nbsp;
																</c:forEach>
														</c:if>
													</span>
												</section>
												<section class="hLh20 txtOf">
													<span class="c-master">${interfixCourse.page_buycount }人</span>
												</section>
											</li>
										</c:forEach>

									</ol>
								</section>
							</c:if>
						</div>
					</div>
				</aside>
				<div class="clear"></div>
			</div>
		</section>
		<!-- /课程详情 结束 -->
	</div>
	<%-- <script type="text/javascript" src="${ctx}/static/common/jquery-1.11.1.min.js"></script> --%>
	<script type="text/javascript" src="/static/inxweb/front/courseInfo.js"></script>
	<script type="text/javascript" src="/static/inxweb/comment/comments.js"></script>
	<script type="text/javascript" src="/static/inxweb/js/commons.js"></script>

	<script>
		//评论课程id
		var others_id  = '${courseByID.course_id}';
		//课程有效期到期时间
		var loseTimeTime = '${courseByID.end_times}';
		//有效期类型，0：到期时间，1：按天数
		var loseType="${courseByID.losetype}";
		//评论类型,类型2为课程
		var type = 2;
		
		$(function() {
			shareShow(); //课程分享
			treeMenu(); //课程树
			replyFun(); //回复展开
			cTabFun($("#c-i-tabTitle>a")); //滚动定位
			queryComment();//评论
			 //学过此课程的用户
		    getCourseLearnedUser("${courseByID.course_id}");
		  	//课程详情收起展开
		    ctbodyFun();
		  	//课程封面图适配尺寸
		    cvPic();
		});
		//课程详情收起展开
		var ctbodyFun = function() {
			var ctb = $(".course-txt-body"),
				ctBtn = $(".ctb-btn>a");
			if (ctb.height() < 88) {
				ctBtn.parent().hide();
				return false;
			} else {
				ctb.css({"height" : "88px"});
				ctBtn.parent().show();
				ctBtn.toggle(function() {
					ctBtn.text("收起更多∧");
					ctb.stop().animate({"height" : "100%"}, 500);
				}, function() {
					ctBtn.text("查看更多∨");
					ctb.css({"height" : "88px"});
				});
			};
		};
		//课程封面图适配尺寸
		var cvPic = function() {
			$(".c-v-pic-wrap").css("height" , $(".c-v-pic").height());
		}
		window.onresize = function() {cvPic();};
	
	</script>
	<script type="text/javascript">
	$(function () {
		getCourseLearnedUser(others_id);
	})
	</script>
</body>
</html>