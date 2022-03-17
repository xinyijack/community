function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    if (!content) {
        alert("不能回复空内容！");
        return;
    }
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: 'application/json',
        data: JSON.stringify({
            "parentId":questionId,
            "content":content,
            "type":1
        }),
        success: function (response) {
            if (response.code == 200) {
                //$("#comment-section").hide();
                window.location.reload();
            }
            else {
                if(response.code == 2003){
                    let isAccepted = confirm(response.message);
                    if (isAccepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=7321ba4fcf3868bb8644&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", 1);
                    }
                }
                else {
                    alert(response.message);
                }

            }
            console.log(response);
        },
        dataType: "json"
    });
    console.log(questionId);
    console.log(content);
}