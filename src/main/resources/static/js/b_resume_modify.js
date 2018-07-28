/ * Blog changes */
// Markdown editor
var testEditor;

$(function () {
    testEditor = editormd("test-editormd", {
        width: "100%",
        height: 640,
        syncScrolling: "single",
        path: "/vendor/editor/lib/",
        saveHTMLToTextarea: true
    });

    $("#id_btn_blog_submit").bind("click", function () {
        / * markdown formatted text */
        $("#id_input_md").val(testEditor.getMarkdown());
        / * html format content */
        $("#id_input_html").val($(".markdown-body").prop('outerHTML'));
        /* Show article Description fill in the modal box*/
        showDetailModal();
    });

    $('#id_btn_release_in_modal').bind('click', function () {
        saveDetailText();
        submitBlogAddForm();
    });
});

/**
 * Show article details to fill in the modal box
 */
function showDetailModal() {
    $('#id_modal_article_detail').modal({
        // backdrop: false
    });
}

/**
 * Save the contents filled in the modal box to the form
 */
function saveDetailText() {
    // Content description
    $('#id_input_article_description').val($('#id_input_article_description_in_modal').val());
    // Tags
    $('#id_input_article_tags').val($('#id_input_article_tags_in_modal').val());
}

/**
 * Submit an article form
 */
function submitBlogAddForm() {
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "/update_resume.f",
        data: $("#id_form_resume").serialize(),
        success: function (result) {
            if (!(result.hasError)) {
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
}