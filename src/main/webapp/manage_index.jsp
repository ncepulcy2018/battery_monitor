<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>NCEPU</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/styles/rum.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/data/jquery.dataTables.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/echarts/css/echarts.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery-1.10.2.min.js.bak"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/commons.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/data/jquery.dataTables.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/menu.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/echarts/dist/echarts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/setup.js"></script>

<script type="text/javascript">
	var context_path = "${pageContext.request.contextPath}";
	$(function() {
//	    初始化菜单
		init_menu();		
	})
</script>
<style type="text/css">
	.submenu{display:none;}
	/*//position:absolute;top:40px;left:-9px;}*/
</style>
</head>


<body>
	<div class="bodyq">
		<div class="header">
			<div class="logo">
				<a href="" target="_blank"><img src="${pageContext.request.contextPath}/static/images/timg.jpg" height="30" align="middle" style="margin-left: 10px"></a>
			</div>
			<%--菜单显示内容   根据js动态加载--%>
			<div class="mainmenu">
				<ul id="navigation">
					
				</ul>
			</div>
			<div class="mini_nav">
				<div class="mini_nav_fl">
					<div id="topAlert" onmouseover="this.className='alert02'" onmouseout="this.className='alert01'" class="alert01" title="告警">
						<div class="prompt" style="display: none;"></div>
					</div>
					<div onmouseover="this.className='information02'" onmouseout="this.className='information01'" class="information01" title="帮助" onclick="help()"></div>
				</div>
				<div class="mini_nav_fl">
					<div id="mailAlert" onmouseover="this.className='alert02'" onmouseout="this.className='alert01'" class="alert01" title="发送邮件" onclick="sendEmail()">
						<a href="/sendEmail.action">邮件发送</a>
					</div>
					<div onmouseover="this.className='information02'" onmouseout="this.className='information01'" class="information01" title="帮助" onclick="help()"></div>
				</div>
				<div class="jump_button">
					<div class="button">
						<span class="user_name">${sessionScope['org.springframework.web.servlet.support.SessionFlashMapManager.FLASH_MAPS'][0]['user']}</span><br/>
						<div class="submenu" style="background-color: #9fc2dd;text-align: center">
							<a style="text-align: left"></a><br/>
                            <a style="text-align: left">信息资料</a><br/>
							<a href="index.jsp" style="text-align: center">退出登录</a>
						</div>
					</div>
				</div>

			</div>
		</div>
		
		<div class="content_sidebar content_sidebar_background">
			<div id="sidebar" class="sidebar">
				<div id="arrow_div" class="sidebar_arrow sidebar_arrow_left" mini="${mini}"></div>
				<ul id="smenu">
					
				</ul>
			</div>
			<div class="meumToolTip tooltip2" style="margin:20px; float:left;display: none;position: absolute; z-index: 1100">
				<div class="icon_arrow"></div>
				<div id="tooltipContent" style="float:left;">正常</div>
			</div>
			
			<div id="conright" class="conright">
				<div id="main" class="main" style="width:1000px;height:600px;margin:0 auto;"></div><%----%>
			</div>
		</div>
	</div>
<script>
	$(function(){
        showsubmenu(".jump_button");
    });
    function showsubmenu(_this){
        $(_this).each(function(){
            var $this = $(this);
            var theMenu = $this.find(".submenu");
            var tarHeight = theMenu.height();
            theMenu.css({height:0});
            $this.hover(
                function(){
                    $(this).addClass("mj_hover_menu");
                    theMenu.stop().show().animate({height:tarHeight},400);
                },
                function(){
                    $(this).removeClass("mj_hover_menu");
                    theMenu.stop().animate({height:0},400,function(){
                        $(this).css({display:"none"});
                    });
                }
            );
        });
    }
</script>
</body>

</html>