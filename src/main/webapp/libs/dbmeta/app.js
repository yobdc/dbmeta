/**
 * 用户新建编辑
 */
$('#user-edit-form').submit(function (event) {
    if ($('#id').val()) return;
    var password = $('#password').val();
    var password2 = $('#password2').val();
    if (!password || !password2) {
        event.preventDefault();
        if (!password) {
            $('#password-msg').text('密码不能为空');
        }
        if (!password2) {
            $('#password2-msg').text('确认密码不能为空');
        }
    }
    if (password != password2) {
        event.preventDefault();
        $('#password2-msg').text('密码不一致');
    }
});

$.busyLoadSetup({animation: "slide", background: "rgba(119, 119, 119, 0.8)"});
var loading = {
    show: function () {
        $("body").busyLoad("show", {fontawesome: "fa fa-spinner fa-spin fa-9x ", animation: "fade"});
    },
    hide: function () {
        $("body").busyLoad("hide");
    }
}
/**
 * 测试数据源连接
 */
$('#testDataSource').click(function (event) {
    event.preventDefault();
    loading.show();
    $.post($('#testDataSource').attr('url'), {
        url: $('#jdbcUrl').val()
    }, function (data) {
        loading.hide();
        if (data.success) {
            $('#jdbcUrl-msg').text('测试成功');
            $('#jdbcUrl-msg').addClass('success-msg');
            $('#jdbcUrl-msg').addClass('success-msg');
        } else{
            $('#jdbcUrl-msg').text('测试失败');
            $('#jdbcUrl-msg').addClass('error-msg');
        }
    });
});