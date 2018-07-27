<html lang="zh">
<#-- Blog list page -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${articleTitle!'Full stack blog'}</title>

<#-- EditorMD -->
    <link href="/vendor/editor/css/editormd.css" rel="stylesheet">

<#-- landing-page -->
    <link rel="stylesheet" href="/vendor/landing-page/landing-page.min.css">

<#-- Custom styles-->
<#include "public/front_custom_css.ftl">

<#-- CSS -->
<#include "public/front_css.ftl">
</head>

<body>

<#assign page_index = 1>
<#-- s-nav.ftl -->
<#include "public/nav.ftl">
<#-- e-nav.ftl -->
<!-- Landing page -->
<header class="masthead text-white text-center"
        style="background-image: url('http://blackrockdigital.github.io/startbootstrap-clean-blog/img/home-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col mx-auto text-left pl-5">
                <h1>FS-Blog</h1>
                <h3>Recording technology growth bit by bit</h3>
            </div>
        </div>
    </div>
</header>
<div class="container container-fluid mt-5 mb-5">
<#--<img src="http://blackrockdigital.github.io/startbootstrap-clean-blog/img/home-bg.jpg" alt="">-->
    <div class="row">
    <#-- s left -->
        <div class="col-md-8">
            <ul class="list-unstyled">
            <#if postlist??>
                <#if (postlist?size>0)>
                    <#list postlist as post>
                        <div class="card mt-3">
                            <div class="card-body">
                                <a href="/blog/${post.id!""}" class="text-dark" target="_blank"><h4
                                        class="card-title font-weight-bold">${post.title!""}</h4>
                                </a>
                                <p class="card-text">${post.description}</p>
                                <p class="text-right text-secondary">${post.dateTime!""}</p>
                            </div>
                        </div>
                    </#list>
                <#else>
                    <div class="card border-danger mt-3 mb-3">
                        <div class="card-body text-danger">
                            <h2 class="card-title"><i class="fa fa-warning fa-1x"></i> Sorry, I didn't find anything.</h2>
                            <p class="card-text">Try other keywords?</p>
                        </div>
                    </div>
                </#if>
            </#if>
            </ul>
        </div>
    <#-- e Left -->
    <#-- s Right -->
        <div class="col-md-4 mt-3">
            <div class="card mb-3">
                <div class="card-header">
                    Search articles
                </div>
                <div class="card-body">
                    <form action="/postsearch">
                        <div class="input-group">
                            <input name="name" type="text" class="form-control" placeholder="Enter the subject you want to find...."
                                   aria-label="Enter the subject you want to find...">
                            <span class="input-group-btn">
                        <button class="btn btn-primary" type="submit">Search</button>
                    </span>
                    </form>
                </div>
            </div>
        </div>
    <#if taglist??>
        <div class="card mb-3">
            <div class="card-header">
                It's not a big deal.
            </div>
            <div class="card-body">
                <#list taglist as tag>
                    <!-- tag -->
                    <a href="/post?tagId=${tag.tagId!''}" target="_blank">
                        <button type="button" class="btn btn-outline-primary mb-3">
                        ${tag.tagName!""} <span class="badge badge-primary">${tag.articleCount!""}</span>
                        </button>
                    </a>
                </#list>
            </div>
        </div>
    </#if>
    <#-- e Right -->
    </div>
</div>
</div>


<#-- s-footer -->
<#include "public/footer.ftl">
<#-- e-footer -->

<#-- JS -->
<#include "public/front_js.ftl">
</body>
</html>
