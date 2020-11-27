$(function () {
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
            },
            error: function () {
                $("#add").modal('hide');
            }
        });
    });

    $("#updateInfo").click(function () {
        var id = $("#edit").prev().val();
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
            }
        });

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
            },
            error: function () {
                $("#update").modal('hide');
            }
        });
    });

    $("#deleteInfo").click(function () {
        var id = $("#remove").prev().val();
        console.log(id);
        $.ajax({
            type: "delete",
            url: "/person/remove",
            data: {id: id},
            success: function () {
                $("#delete").modal('hide');
            },
            error: function () {
                $("#delete").modal('hide');
            }
        });
    });
});