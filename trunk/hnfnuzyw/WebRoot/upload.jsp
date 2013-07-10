    <%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
            <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

        <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
        <html>
        <head>
        <base href="<%=basePath%>">

        <title>My JSP 'Default.jsp' starting page</title>

        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">

        <link rel="stylesheet" type="text/css"
        href="App/Lib/Uploadify/uploadify.css">

        <script src="App/Lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script>
        <script src="App/Lib/Uploadify/jquery.uploadify.js" type="text/javascript"></script>
        <script src="App/Lib/Uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="App/Lib/Uploadify/swfobject.js"></script>
        <script type="text/javascript"><!--
        $(function() {
        $("#file_upload").uploadify({
        debug:true,
        auto:true,//是否自动上传
        height: 30,
        buttonText:'上传文件',
        cancelImage:'App/Lib/Uploadify/uploadify-cancel.png',
        swf : 'App/Lib/Uploadify/uploadify.swf',
        // expressInstall:'App/Lib/Uploadify/expressInstall.swf',
        uploader : '<%=path%>/upload/fileUpload.action', //后台处理上传文件的action
        width : 120 ,
        multi : false,//是否允许多个文件上传
        queueID : 'uploadfileQueue',
        fileObjName : 'fileName', //与后台Action中file属性一样
        formData : { //附带值
        'userid' : '111',
        'username' : 'tom',
        'rnd' : '111'
        },
        successTimeout : 99999,//上传超时时间
        overrideEvents : [ 'onDialogClose' ],
        // fileTypeDesc : '上传文件支持的文件格式:jpg,jpge,gif,png',
        // fileTypeExts : '*.*',//*.jpg;*.jpge;*.gif;*.png
        queueSizeLimit : 3,//
        // simUploadLimit:1,//一次可以上传1个文件
        fileSizeLimit : '20MB',//上传文件最大值
        //返回一个错误，选择文件的时候触发
        onSelectError : function(file, errorCode, errorMsg) {
        switch (errorCode) {
        case -100:
        alert("上传的文件数量已经超出系统限制的"
        + $('#file_upload').uploadify(
        'settings',
        'queueSizeLimit') + "个文件！");
        break;
        case -110:
        alert("文件 ["
        + file.name
        + "] 大小超出系统限制的"
        + $('#file_upload')
        .uploadify('settings',
        'fileSizeLimit')
        + "大小！");
        break;
        case -120:
        alert("文件 [" + file.name + "] 大小异常！");
        break;
        case -130:
        alert("文件 [" + file.name + "] 类型不正确！");
        break;
        }
        },
        //每次更新上载的文件的进展
        onUploadProgress : function(file, bytesUploaded,
        bytesTotal, totalBytesUploaded,
        totalBytesTotal) {
        //alert(bytesUploaded);
        //有时候上传进度什么想自己个性化控制，可以利用这个方法
        //使用方法见官方说明
        },
        //检测FLASH失败调用
        onFallback : function() {
        alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
        },
        //上传到服务器，服务器返回相应信息到data里
        onUploadSuccess : function(file, data, response) {
       /* var fileNameAndPath = data.split(",");
        var phtml = "__tag_143$33_<a href='#' onlick=downLoad('"
        + fileNameAndPath[1]
        + "')>"
        + fileNameAndPath[0]
        + "__tag_143$112_<img alt='删除' src='js/uploadify/uploadify-cancel.png' onclick=delFile(this)>__tag_143$192_";
        if ($("#uploadfileQueue p").length == 0) {
        $("#uploadfileQueue").html(phtml);
        } else {
        $("#uploadfileQueue p:last").after(phtml);
        }*/
        alert(data+"上传成功");
        },
        onSelect : function(file) {
        alert(file.name);
        },
        removeCompleted : true,//上传的文件进度条是否消失
        requeueErrors : false,
        removeTimeout : 2,//进度条消失的时间，默认为3
        progressData : "percentage",//显示上传的百分比
        onUploadError : function(file, errorCode, errorMsg,
        errorString, swfuploadifyQueue) {
        $("#dialog-message").html(errorString);
        },
        onError : function(event, queueID, fileObj) {
        alert("文件:" + fileObj.name + " 上传失败");
        }
        });
        });
        //删除文件
        function delFile(obj) {
        $(obj).parent().remove
        }
        --></script>

        </head>
        <body>

        <input type="file" id="file_upload" name="fileName">

        <div id="uploadfileQueue" style="width: 400px;">

        </div>

        </body>
        </html>
