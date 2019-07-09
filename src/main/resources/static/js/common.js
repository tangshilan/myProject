//格式化文件在datagrid中的显示
function formatFile(value, row, index){
    if(value !=null && value != ''){
        var urls = value.split(",");
        var resultStr ='';
        for(var i in urls){
            if(urls[i] !=null && urls[i] != ''){
                resultStr +="<a href='file/download?fileName="+urls[i]+"'>"+urls[i].substring(urls[i].lastIndexOf("/")+1)+"</a></br></br>";
            }
        }
        return resultStr;
    }else{
        return "无";
    }
}

//加载文件上传插件
function initOrderAddFileUpload(){
    $("#orderAddFileUploader").uploadFile({
        url:"file/upload",
        maxFileCount: 5,                //上传文件个数（多个时修改此处
        returnType: 'json',              //服务返回数据
        allowedTypes: 'doc,docx,excel,sql,txt,ppt,pdf',  //允许上传的文件式
        showDone: false,                     //是否显示"Done"(完成)按钮
        showDelete: true,                  //是否显示"Delete"(删除)按钮
        deleteCallback: function(data,pd)
        {
            //文件删除时的回调方法。
            //如：以下ajax方法为调用服务器端删除方法删除服务器端的文件
            var fileUrl = data.url;
            $.ajax({
                cache: false,
                url: "file/delete",
                dataType: "json",
                data: {fileName:data.url},
                success: function(data)
                {
                    if(data.data=="success"){
                        pd.statusbar.hide();        //删除成功后隐藏进度条等
                        $('#image').val('');
                        var urls = $('#orderAddForm [name=file]').val().split(",");  //将删除的文件url从urls中移除
                        var deletedUrls = [];
                        for(var i in urls){
                            if(urls[i] != fileUrl){
                                deletedUrls.push(urls[i]);
                            }
                        }
                        deletedUrls = deletedUrls.join(",");
                        $('#orderAddForm [name=file]').val(deletedUrls);
                    }else{
                        console.log(data.message);  //打印服务器返回的错误信息
                    }
                }
            });
        },
        onSuccess: function(files,data,xhr,pd)
        {
            //上传成功后的回调方法。本例中是将返回的文件名保到一个hidden类开的input中，以便后期数据处理
            if(data&&data.error==0){
                $.messager.alert('提示','上传完成!');
                if( $('#orderAddForm [name=file]').val() != null && $('#orderAddForm [name=file]').val() != ''){
                    /* alert($('#orderAddForm [name=file]').val()); */
                    $('#orderAddForm [name=file]').val($('#orderAddForm [name=file]').val()+","+data.url);
                }else{
                    $('#orderAddForm [name=file]').val(data.url);
                }
            }
        }
    });
}

//加载文件上传插件
function initOrderEditFileUpload(){
    $("#orderEditFileUploader").uploadFile({
        url:"file/upload",
        maxFileCount: 5,                //上传文件个数（多个时修改此处
        returnType: 'json',              //服务返回数据
        allowedTypes: 'doc,docx,excel,sql,txt,ppt,pdf',  //允许上传的文件式
        showDone: false,                     //是否显示"Done"(完成)按钮
        showDelete: true,                  //是否显示"Delete"(删除)按钮
        deleteCallback: function(data,pd)
        {
            //文件删除时的回调方法。
            //如：以下ajax方法为调用服务器端删除方法删除服务器端的文件
            var fileUrl = data.url;
            $.ajax({
                cache: false,
                url: "file/delete",
                dataType: "json",
                data: {fileName:data.url},
                success: function(data)
                {
                    if(data.data=="success"){
                        pd.statusbar.hide();        //删除成功后隐藏进度条等
                        $('#image').val('');
                        var urls = $('#orderEditForm [name=file]').val().split(",");  //将删除的文件url从urls中移除
                        var deletedUrls = [];
                        for(var i in urls){
                            if(urls[i] != fileUrl){
                                deletedUrls.push(urls[i]);
                            }
                        }
                        deletedUrls = deletedUrls.join(",");
                        $('#orderEditForm [name=file]').val(deletedUrls);
                    }else{
                        console.log(data.message);  //打印服务器返回的错误信息
                    }
                }
            });
        },
        onSuccess: function(files,data,xhr,pd)
        {
            //上传成功后的回调方法。本例中是将返回的文件名保到一个hidden类开的input中，以便后期数据处理
            if(data&&data.error==0){
                $.messager.alert('提示','上传完成!');
                if( $('#orderEditForm [name=file]').val() != null && $('#orderEditForm [name=file]').val() != ''){
                    /*alert($('#orderEditForm [name=file]').val()); */
                    $('#orderEditForm [name=file]').val($('#orderEditForm [name=file]').val()+","+data.url);
                }else{
                    $('#orderEditForm [name=file]').val(data.url);
                }
            }
        }
    });
}

//删除文件并删除文件在页面的显示
function removeFile(i){
    var fileName = $('#file'+i).attr("href");
    $.ajax({
        cache: false,
        url: "file/delete",
        dataType: "json",
        data: {fileName:fileName},
        success: function(data)
        {
            if(data.data=="success"){
                $('#img'+i);
                $('#file'+i).remove();		//删除成功后在页面上删除该文件的显示
                $('#delFile'+i).remove();
                var urls = $('#orderEditFile').val().split(",");  //将删除的文件url从urls中移除
                var deletedUrls = [];
                tempDelFileName = fileName.substring(0,fileName.lastIndexOf("/"));
                delFileName = tempDelFileName.substring(tempDelFileName.lastIndexOf("/"))+fileName.substring(fileName.lastIndexOf("/"));
                for(var k in urls){
                    if(urls[k] != delFileName){
                        deletedUrls.push(urls[k]);
                    }
                }
                deletedUrls = deletedUrls.join(",");
                $('#orderEditFile').val(deletedUrls);
            }else{
                console.log(data.message);  //打印服务器返回的错误信息
            }
        }
    });
}

//加载上传过的文件
function initUploadedFile(){
    var _ele = $("#orderEditFileUploader");
    _ele.after('\
			<table class="file">\
			</table>');
    var files = $('#orderEditFile').val().split(",");
    for(var i in files){
        if(files[i] !=null && files[i] != ''){
            _ele.siblings(".file").append("<tr><td><a id='file"+i+"' href='file/download?fileName="+files[i]+"'>" +
                "<span style='font-size: 16px;font-family: Microsoft YaHei;'>"
                + files[i].substring(files[i].lastIndexOf("/")+1) + "</span></td><td></a> "
                +"<a id='delFile"+i+"' href='javascript:removeFile("+i+");'>"
                +"<span style='font-size: 16px;font-family: Microsoft YaHei;;margin-left: 30px'>"+"删除</span></a></td></tr>");
        }
    }
}
