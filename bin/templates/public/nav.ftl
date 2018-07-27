<!-- Navigation -->
<nav class="navbar navbar-expand-xl navbar-dark bg-dark fixed-top">
    <div class="container-fluid">
    <#-- Logo Location -->
        <img class="mr-3" alt="Logo"
             src="/img/logo.png" style="max-width: 30px">
        <a class="navbar-brand" href="#">
            FS-Blog
        </a>
    <#-- Responsive navigation drop-down button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
        <#-- s Left side navigation -->
            <ul class="nav navbar-nav">
                <li class="nav-item">
                    <a class="nav-link"><#-- 占位 --></a>
                </li>
                <li class="nav-item <#if page_index?? && page_index == 0>active</#if>">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item <#if page_index?? && page_index == 1>active</#if>">
                    <a class="nav-link" href="/post">Blog</a>
                </li>
                <li class="nav-item <#if page_index?? && page_index == 2>active</#if>">
                    <a class="nav-link" href="/resume">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
            </ul>
        <#-- e Left side navigation-->
        <#-- s Right navigation -->
            <ul class="nav navbar-nav ml-auto">
            <#if Session ["session_current_user"]??>
                <li class="nav-item">
                <#-- User picture position -->
                    <img class="img-circle"
                         src="/img/logo.png"
                         alt="Avatar"
                         style="max-width: 30px;"/>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                       aria-haspopup="true" aria-expanded="false">${Session ["session_current_user"].username!'Login'}<span
                            class="caret"></span></a>
                    <div class="dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" href="#">My file</a>
                        <a class="dropdown-item" href="#">Message</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/usersignout.c">Log off</a>
                    </div>
                </li>
            <#else>
                <li class="nav-item">
                    <a class="nav-link" href="/userregister">Registration</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/userlogin">Login</a>
                </li>
            </#if>
            </ul>
        <#-- e Right navigation -->
        </div>
    </div>
</nav>