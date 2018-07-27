<html lang="zh">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${article.title!'Full stack blog'}</title>

<#-- EditorMD -->
    <link href="/vendor/editor/css/editormd.css" rel="stylesheet">

<#--Custom styles -->
<#include "public/front_custom_css.ftl">

<#-- CSS -->
<#include "public/front_css.ftl">
</head>

<body>

<#-- s-nav.ftl -->
<#include "public/nav.ftl">
<#-- e-nav.ftl -->

<div class="container container-fluid cus_content">
<#-- Blog title -->
    <div class="row mt-md-5"></div>
    <div class="row mt-md-5">
    <#-- Blog content -->
        <div class="col-md-8 offset-md-2">
            <h3 class="p-3 font-weight-bold">${article.title!'Title'}</h3>
            <div class="row pl-3 pr-3">
                <div class="col-md-6"></div>
                <div class="col-md-6 text-md-right">
                    <p class="small text-secondary">${article.dateTime!""}</p>
                </div>
            </div>
        ${article.htmlMaterial!'Article content'}
        </div>
    </div>
    <div class="row mb-md-5"></div>
</div>


<#-- s-footer -->
<#include "public/footer.ftl">
<#-- e-footer -->

<#-- JS -->
<#include "public/front_js.ftl">
</body>
</html>
