$(function () {
    $("#id_btn_submit").bind("click", function () {
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "/admin/admin_user_pwd_modify.f",
            data: $('#id_form').serialize(),
            success: function (result) {
                if (!(result.hasError)) {
                    msg("Modified successfully");
                    // Return to blog batch Management page
                    c_location("/admin/blogmanage");
                } else {
                    msg("Modification failed");
                }
            },
            error: function () {
                msg("Failed.");
            }
        });
    });
});