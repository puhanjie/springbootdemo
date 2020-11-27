$(function () {
    //给每个修改按钮绑定事件
    for (var i = 0; i < $(".updBtn").length; i++) {
        $($(".updBtn")[i]).click(function () {
            var id = $(this).prev().val();
            var url = "/person/" + id;

            $.ajax({
                type: "get",
                url: url,
                dataType: 'json',
                success: function (data) {
                    $("#upPersonId").val(data.id);
                    $("#upUsername").val(data.username);
                    $("#upEmail").val(data.email);
                    $("#upGender").val(data.gender);
                    $("#upDeptId").val(data.deptId);
                },
                error: function () {
                    $("#update").modal('hide');
                    window.location.reload();
                }
            });
        });
    }

    //给每个删除按钮绑定事件
    for (var i = 0; i < $(".delBtn").length; i++) {
        $($(".delBtn")[i]).click(function () {
            var id = $(this).prev().val();
            $("#dePersonId").val(id);
        });
    }

    //给确认新增按钮绑定事件，执行新增操作
    $("#addInfo").click(function () {
        var person = new Object();
        person.username = $("#username").val();
        person.email = $("#email").val();
        person.gender = $("#gender").val();
        person.deptId = $("#deptId").val();

        $.ajax({
            type: "post",
            url: "/person/add",
            data: person,
            success: function () {
                $("#add").modal('hide');
                window.location.reload();
            },
            error: function () {
                $("#add").modal('hide');
                window.location.reload();
            }
        });
    });

    //给确认更新按钮绑定事件，执行修改操作
    $("#updateInfo").click(function () {
        var person = new Object();

        person.id = $("#upPersonId").val();
        person.username = $("#upUsername").val();
        person.email = $("#upEmail").val();
        person.gender = $("#upGender").val();
        person.deptId = $("#upDeptId").val();

        $.ajax({
            type: "put",
            url: "/person/edit",
            data: person,
            success: function () {
                $("#update").modal('hide');
                window.location.reload();
            },
            error: function () {
                $("#update").modal('hide');
                window.location.reload();
            }
        });
    });

    //给确认删除按钮绑定事件，执行删除操作
    $("#deleteInfo").click(function () {
        var id = $("#dePersonId").val();
        console.log(id);
        $.ajax({
            type: "delete",
            url: "/person/remove",
            data: {id: id},
            success: function () {
                $("#delete").modal('hide');
                window.location.reload();
            },
            error: function () {
                $("#delete").modal('hide');
                window.location.reload();
            }
        });
    });

});