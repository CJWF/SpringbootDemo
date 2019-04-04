$(function(){
    console.log("初始化数据");
    $.ajax({
        url : basePath + "sys/userAction/getAllUser",
        type : 'post',
        data : json,
        dataType : 'json',
        cache : false,
        success : function(data) {
            if (data.success) {
                console.log("data = " + data);
            } else {
                if (data.msg.errCode == "-1"){
                    console.log("msg = " + data.msg.errMsg);
                }
            }
        },
        error : function(jqXHR, textStatus, errorThrown) {
            alert('访问服务器失败!!');
        }
    });
});