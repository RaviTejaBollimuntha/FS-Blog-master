<#-- s Navigation (top,left)-->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">

<#-- s Navigation left -->
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.html">Full-Stack System background management</a>
    </div>
<#-- e Navigation left->

<#-- s Navigation right -->
    <ul class="nav navbar-top-links navbar-right">
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <#--<li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>-->
                <#--</li>-->
                <li><a href="/admin/admin_user_pwd_modify"><i class="fa fa-gear fa-fw"></i> Change Password</a>
                </li>
                <li class="divider"></li>
                <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Log off</a>
                </li>
            </ul>
            <!-- /.dropdown-user -->
        </li>
        <!-- /.dropdown -->
    </ul>
<#-- e Navigation right-->

<#-- s Sidebar -->
    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Blog management<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="/admin/blogadd"> Blog post</a>
                        </li>
                        <li>
                            <a href="/admin/blogmanage"> Blog bulk management</a>
                        </li>
                    </ul>
                    <!-nav.ftl.nav-second-level -->
                </li>
                <li>
                    <a href="/admin/resume_modify"><i class="fa fa-table fa-fw"></i> Resume management</a>
                </li>
                <li>
                    <a href="/admin/admin_user_manage"><i class="fa fa-edit fa-fw"></i> User management</a>
                </li>
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
<#-- e Sidebar -->
</nav>
<#-- e Navigation (top,left)-->