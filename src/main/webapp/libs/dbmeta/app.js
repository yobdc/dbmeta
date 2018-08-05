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
            $('#jdbcUrl-msg').removeClass('error-msg');
            $('#jdbcUrl-msg').addClass('success-msg');
        } else {
            $('#jdbcUrl-msg').text(data.msg);
            $('#jdbcUrl-msg').removeClass('success-msg');
            $('#jdbcUrl-msg').addClass('error-msg');
        }
    });
});

/**
 * 删除数据源
 */
function delDbModal(itemId) {
    var itemName = $('#dbItemName' + itemId).text()
    $('#dbItemName').text(itemName);
    $('#dbItemName').attr('dbid', itemId);
    $('#delDbModal').modal();
    $('#confirmDel').click(function (event) {
        $.post($('#dbItemName').attr('prefix') + '/admin/database/remove/' + itemId, {}, function (data) {
            if (data.success) {
                $('#delDbModal').modal('hide');
                location.reload();
            }
        });
    });
};


/**
 * 删除表
 */
function delTableModal(itemId) {
    var itemName = $('#tableItemName' + itemId).text()
    $('#tableItemName').text(itemName);
    $('#tableItemName').attr('tableid', itemId);
    $('#delTableModal').modal();
    $('#confirmDel').click(function (event) {
        $.post($('#tableItemName').attr('prefix') + '/admin/table/remove/' + itemId, {}, function (data) {
            if (data.success) {
                $('#delTableModal').modal('hide');
                location.reload();
            } else {
                $('#delTableModal').modal('hide');
                $.notify({message: data.msg}, {type: 'danger'});
            }
        });
    });
};


/**
 * 删除列
 */
function delColumnModal(itemId) {
    var itemName = $('#columnItemName' + itemId).text()
    $('#columnItemName').text(itemName);
    $('#columnItemName').attr('tableid', itemId);
    $('#delColumnModal').modal();
    $('#confirmDel').click(function (event) {
        $.post($('#columnItemName').attr('prefix') + '/admin/column/remove/' + itemId, {}, function (data) {
            if (data.success) {
                $('#delColumnModal').modal('hide');
                location.reload();
            } else {
                $('#delColumnModal').modal('hide');
                $.notify({message: data.msg}, {type: 'danger'});
            }
        });
    });
};