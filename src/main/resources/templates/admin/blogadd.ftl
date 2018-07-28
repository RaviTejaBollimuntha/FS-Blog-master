<!DOCTYPE html>
<html lang="zh">
<#-- Blogging. -->
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Full-Stack System background management</title>

    <!-- Bootstrap Core CSS -->
    <link href="../vendor/admin/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor/admin/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/admin/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="../vendor/admin/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/admin/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- EditorMD -->
    <link rel="stylesheet" href="../vendor/editor/css/editormd.css"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Custom styles -->
    <link rel="stylesheet" href="/css/public.css">
</head>

<body>

<div id="wrapper">
<#-- s Navigation -->
<#include "public/nav.ftl">
<#-- e Navigation -->

<#-- s Page content -->
    <div id="page-wrapper">
    <#-- s Page content -->
        <form>
        <#-- s Hide fields -->
            <input name="mdMaterial" id="id_input_md" type="hidden">
            <input name="htmlMaterial" id="id_input_html" type="hidden">
            <input name="description" id="id_input_article_description" type="hidden">
            <input name="rawTags" id="id_input_article_tags" type="hidden">
        <#-- e Hide fields -->
        <#-- s Titles, labels, etc. -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="input-group">
                        <div class="row">
                            <div class="col-md-12"></div>
                        </div>
                    <#-- Article title -->
                        <input name="title" type="text" class="form-control" placeholder="Title">
                        <div class="row">
                            <div class="col-md-12"></div>
                        </div>
                        <span class="input-group-btn">
                        <button id="id_btn_blog_submit" class="btn btn-primary" type="button">Submission</button>
                    </span>
                    </div>
                </div>
            </div>
        <#-- e Title -->
        </form>
        <div class="row">
            <div class="col-sm-12">
                <div id="test-editormd">
                <#-- Article content -->
                    <textarea style="display:none;"></textarea>
                </div>
            </div>
        </div>
    <#-- e Page content -->
    </div>
<#-- e Page content -->

</div>

<#-- s Article Description fill modal box -->
<div class="modal fade" tabindex="-1" role="dialog" id="id_modal_article_detail">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">Article details</h4>
            </div>
            <div class="modal-body">
            <#-- s Modal content -->
                <div class="form-group">
                    <label for="id_input_article_description_in_modal">Description of the content of the article</label>
                    <textarea type="text" class="form-control" id="id_input_article_description_in_modal" placeholder="Description"></textarea>
                </div>
                <div class="form-group">
                    <label for="id_input_article_tags_in_modal">Add tags to articles (separated by commas)</label>
                    <input type="text" class="form-control" id="id_input_article_tags_in_modal" placeholder="Tags">
                </div>
            <#-- e Modal content-->
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary" id="id_btn_release_in_modal">Confirm release</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<#-- e Article Description fill modal box -->

<!-- jQuery -->
<script src="../vendor/admin/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../vendor/admin/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../vendor/admin/metisMenu/metisMenu.min.js"></script>

<!-- Morris Charts JavaScript -->
<script src="../vendor/admin/raphael/raphael.min.js"></script>
<script src="../vendor/admin/morrisjs/morris.min.js"></script>
<script src="../data/morris-data.js"></script>

<!-- Custom Theme JavaScript -->
<script src="../dist/admin/js/sb-admin-2.js"></script>
<script src="../vendor/editor/editormd.min.js"></script>

<#-- Custom js -->
<script src="../js/b_blogadd.js"></script>
<script src="../js/public.js"></script>
</body>

</html>
