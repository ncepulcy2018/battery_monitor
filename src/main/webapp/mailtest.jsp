<%--
  Created by IntelliJ IDEA.
  User: cculi
  Date: 2018/5/6
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function goSendEmail(){
            parent.layer.confirm('您确定要发送邮件吗？', {
                btn: ['确定','取消'], //按钮
                shade: false //不显示遮罩
            }, function(){
                $.ajax({
                    type: "POST",
                    title: '推送邮箱',
                    url: ctx+ '/sendEmail.action?',
                    data: {CONTENT:CONTENT,TITLE:TITLE,CONTENT:CONTENT},
                    dataType:'json',
                    //beforeSend: validateData,
                    cache: false,
                    success: function(data){
                        if("ok" == data.result){
                            $("#msg").tips({
                                side:3,
                                msg:'发送成功！',
                                bg:'#68B500',
                                time:5
                            });
                        }else{
                            $("#msg").tips({
                                side:3,
                                msg:'发送失败!',
                                bg:'#68B500',
                                time:5
                            });
                        }

                    }
                });
            }, function(){
                parent.layer.msg("已取消", {icon: 1});
                return false;
            });
        }
    </script>
</head>
<body>
    <button class="btn btn-success btn-primary" onclick="${pageContext.request.contextPath }/sendEmail.action">
        <i class="fa fa-envelope-o"></i> 电子邮箱推送
    </button>
    <h1 href="${pageContext.request.contextPath }/sendEmail.action">yiers</h1>
    <h1><a href="${pageContext.request.contextPath }/sendEmail.action">yiers</a></h1>
</body>
</html>
