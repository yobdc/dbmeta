/**
 * 用户新建编辑
 */
$('#user-edit-form').submit(function (event) {
    if($('#id').val()) return;
    var password = $('#password').val();
    var password2 = $('#password2').val();
    if (!password || !password2) {
        event.preventDefault();
        if(!password){
            $('#password-msg').text('密码不能为空');
        }
        if(!password2){
            $('#password2-msg').text('确认密码不能为空');
        }
    }
    if (password != password2) {
        event.preventDefault();
        $('#password2-msg').text('密码不一致');
    }
});