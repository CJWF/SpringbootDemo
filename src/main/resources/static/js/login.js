function submitForm() {
    var userName = document.loginForm.elements["userName"];
    var userPass = document.loginForm.elements["userPass"];


    if (userName.value.length <= 0) {
        $("#errMsg").css("display","block");
        $("#errMsg").text("请输入用户名");
        userName.focus();
        return false;
    }
    if (userPass.value.length <= 0) {
        $("#errMsg").css("display","block");
        $("#errMsg").text("请输入密码");
        userPass.focus();
        return false;
    }
    var json = new Object();
    json.userName = userName.value;
    json.userPass = userPass.value;
    var jsonStr = JSON.stringify(json);
    console.log(jsonStr);
    $.ajax({
        url : basePath + "loginAction/toLogin",
        type : 'post',
        data : json,
        dataType : 'json',
        cache : false,
        success : function(data) {
            if (data.success) {
                window.location.href=basePath + "index/getView";
            } else {
                if (data.msg.errCode == "-1"){
                    $("#errMsg").css("display","block");
                    $("#errMsg").text(data.msg.errMsg);
                }
            }
        },
        error : function(jqXHR, textStatus, errorThrown) {
            alert('访问服务器失败!!');
        }
    });
}