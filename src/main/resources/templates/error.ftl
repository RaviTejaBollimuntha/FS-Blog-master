<html lang="zh">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Wrong.</title>

<#--Custom styles -->
<#include "public/front_custom_css.ftl">

<#-- CSS -->
<#include "public/front_css.ftl">
</head>

<body>

<#-- s-nav.ftl -->
<#include "public/nav.ftl">
<#-- e-nav.ftl -->


<section class="py-3">
    <div class="container">
    <#--<p class="text-center">${(msg)!"Servers need to calm down."}</p>-->
    <#--<p class="text-center">Error code：${(code)!"Unknown error"}</p>-->
        <img  class="-align-center" src="/img/404.png" alt="" style="width:80%;">
        <h2 class="m-3 text-center">${(msg)!"Servers need to calm down."}</h2>
        <h3 class="text-center">Error code：${(code)!"Unknown error"}</h3>
    </div>
</section>

<#-- s-footer -->
<#--<#include "public/footer.ftl">-->
<#-- e-footer -->

<#-- JS -->
<#include "public/front_js.ftl">

</body>
</html>
