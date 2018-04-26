<!--DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org" xmlns="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>欢迎进入高分卫星数据管理系统</title>
</head>
<body>
<h1>欢迎进入高分卫星数据管理系统</h1>

<a href="/userList"><font color="blue">用户列表</font></a></h1>
<a href="/product/productList"><font color="blue">产品列表</font></a></h1>
<a href="/logout"><font color="blue">注销</font></a></h1>
</body>
</html-->
<!DOCTYPE html>
<html lang="en">
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>高分辨率对地观测系统江苏中心</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <!-- Main Style Sheet -->
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../css/index.css">
    <!-- Modernizr -->
    <script type="text/javascript" src="../js/vendor/modernizr-2.6.2.min.js"></script>
    <!-- Respond.js for IE 8 or less only -->
    <!--[if (lt IE 9) & (!IEMobile)]>
    <script type="text/javascript" src="../js/vendor/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<!--[if lte IE 7]>
<p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
<![endif]-->
<header role="banner">
    <div class="wrapper-top-bg">
        <a href="/">
            <div>
                <p>高分辨率对地观测系统江苏中心</p>
            </div>
        </a>
        <!-- /.utility-nav -->
    </div>
    <!-- /.container -->
    <nav role="navigation" class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="dropdown"> <a href="/">网站首页</a> </li>
                    <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">中心概况 <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="/GF_program">高分专项</a></li>
                            <li><a href="/centerIntro">中心介绍</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">新闻中心<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="/news">新闻动态</a></li>
                            <li><a href="/notice">通知公告</a></li>
                            <li><a href="/policy">政策法规</a></li>
                            <li><a href="/work">中心工作</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">数据服务<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="/userGuide">使用指南</a></li>
                            <li><a href="/sateIntro">卫星介绍</a></li>
                            <li><a href="/successCase">成功案例</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"> <a href="/dataApply">数据申请</a> </li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
        <!--/.container -->
    </nav>
</header>

<main role="main">
    <div class="container">
        <div class="row">

            <section class="col-md-6">
                <div id="homepage-feature" class="carousel slide" style="background-color: #ebebeb">
                    <ol class="carousel-indicators">
                        <li data-target="#homepage-feature" data-slide-to="0" class="active"></li>
                        <li data-target="#homepage-feature" data-slide-to="1"></li>
                        <li data-target="#homepage-feature" data-slide-to="2"></li>
                        <!--<li data-target="#homepage-feature" data-slide-to="3"></li>-->
                    </ol>
                    <!-- Wrapper for slides -->
                    <div class="carousel-inner">
                        <div class="item active">
                            <img src="../img/slide_pic1.png" alt="Holder Image">
                            <div class="carousel-caption">
                                <p>“高分辨率对地观测系统江苏数据与应用中心”揭牌暨卫星数据应用合作协议签约仪式在东南大学举行</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="../img/slide_pic2.png" alt="Holder Image">
                            <div class="carousel-caption">
                                <p>“高分辨率对地观测系统江苏数据与应用中心”揭牌暨卫星数据应用合作协议签约仪式在东南大学举行</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="../img/slide_pic3.png" alt="Holder Image">
                            <div class="carousel-caption">
                                <p>“高分辨率对地观测系统江苏数据与应用中心”揭牌暨卫星数据应用合作协议签约仪式在东南大学举行</p>
                            </div>
                        </div>
                    </div>
                    <!-- /.carousel-inner -->
                    <!-- Carousel Controls -->
                    <a class="left carousel-control" href="#homepage-feature" data-slide="prev"> <span class="icon fa fa-chevron-left"></span> </a> <a class="right carousel-control" href="#homepage-feature" data-slide="next"> <span class="icon fa fa-chevron-right"></span> </a> </div>
                <!-- /#homepage-feature.carousel -->
            </section>
            <section class="col-md-6">
                <div class="module-title"><h4 style="height: 40px; line-height: 40px; color: #fff">&nbsp;&nbsp;&nbsp;新闻动态&nbsp;/&nbsp;News</h4></div>
                <ul class="content-list">
                    <li class="list"><a href="/newsDetail" style="text-decoration: none" class="list-li">多星联合监测多星联合监测长江2017年第1号洪水灾害</a> <span style="float: right">2017-07-04</span></li>
                    <li class="list"><a href="/newsDetail" style="text-decoration: none" class="list-li">多星联合监测多星联合监测长江2017年第1号洪水灾害</a> <span style="float: right">2017-07-04</span></li>
                    <li class="list"><a href="/newsDetail" style="text-decoration: none" class="list-li">多星联合监测多星联合监测长江2017年第1号洪水灾害</a> <span style="float: right">2017-07-04</span></li>
                    <li class="list"><a href="/newsDetail" style="text-decoration: none" class="list-li">多星联合监测多星联合监测长江2017年第1号洪水灾害</a> <span style="float: right">2017-07-04</span></li>
                    <li class="list"><a href="/newsDetail" style="text-decoration: none" class="list-li">多星联合监测多星联合监测长江2017年第1号洪水灾害</a> <span style="float: right">2017-07-04</span></li>
                    <li class="list"><a href="/newsDetail" style="text-decoration: none" class="list-li">多星联合监测多星联合监测长江2017年第1号洪水灾害</a> <span style="float: right">2017-07-04</span></li>
                    <li class="list"><a href="/newsDetail" style="text-decoration: none" class="list-li">多星联合监测多星联合监测长江2017年第1号洪水灾害</a> <span style="float: right">2017-07-04</span></li>
                </ul>
                <p><a class="btn btn-primary pull-right" href="/news">更多<span class="icon fa fa-arrow-circle-right"></span></a></p>

            </section>
        </div>
        <br>
        <div>
            <div class="module-title"><h4 style="height: 40px; line-height: 40px; color: #fff">&nbsp;&nbsp;&nbsp;成功案例&nbsp;/&nbsp;Case</h4></div>
            <div class="row">
                <!-- S scrollable -->
                <div class="col-md-3">
                    <p ><a href="/caseDetail"><img src="../img/case_01_210x150.png" alt="" width="210" height="150" /></a></p>
                    <h4 ><a href="/caseDetail"  style="text-decoration: none" class="list-li">行业遥感应用</a></h4>
                </div>
                <div class="col-md-3">
                    <p ><a href="/caseDetail"><img src="../img/case_02_210x150.png" alt="" width="210" height="150" /></a></p>
                    <h4 ><a href="/caseDetail" style="text-decoration: none" class="list-li">区域遥感应用</a></h4>
                </div>
                <div class="col-md-3">
                    <p ><a href="/caseDetail"><img src="../img/case_03_210x150.png" alt="" width="210" height="150" /></a></p>
                    <h4 ><a href="/caseDetail" style="text-decoration: none" class="list-li">应急灾害应用</a></h4>
                </div>
                <div class="col-md-3">
                    <p class=""><a href="/caseDetail"><img src="../img/case_04_210x150.png" alt="" width="210" height="150" /></a></p>
                    <h4 ><a href="/caseDetail" style="text-decoration: none" class="list-li">水华遥感监测应用</a></h4>
                </div>
            </div>
            <!-- E scrollable-->
            <p><a class="btn btn-primary pull-right" href="/case">更多<span class="icon fa fa-arrow-circle-right"></span></a></p>
        </div>
        <br><br>
        <div class="row">
            <section class="col-md-4">
                <div class="module-title"><h4 style="height: 40px; line-height: 40px; color: #fff">&nbsp;&nbsp;&nbsp;通知公告&nbsp;/&nbsp;Notice</h4></div>
                <ul class="content-list">
                    <li class="list"><a href="/noticeDetail" style="text-decoration: none" class="list-li">关于高分四号卫星数据正式分发和分发服务系统改版的通知</a> <span style="float: right">2018-01-08</span></li>
                    <li class="list"><a href="/noticeDetail" style="text-decoration: none" class="list-li">关于高分四号卫星数据正式分发和分发服务系统改版的通知</a> <span style="float: right">2018-01-08</span></li>
                    <li class="list"><a href="/noticeDetail" style="text-decoration: none" class="list-li">关于高分四号卫星数据正式分发和分发服务系统改版的通知</a> <span style="float: right">2018-01-08</span></li>
                    <li class="list"><a href="/noticeDetail" style="text-decoration: none" class="list-li">关于高分四号卫星数据正式分发和分发服务系统改版的通知</a> <span style="float: right">2018-01-08</span></li>
                </ul>
                <p><a class="btn btn-primary pull-right" href="news.html">更多<span class="icon fa fa-arrow-circle-right"></span></a></p>
            </section>
            <section class="col-md-4">
                <div class="module-title"><h4 style="height: 40px; line-height: 40px; color: #fff">&nbsp;&nbsp;&nbsp;政策法规&nbsp;/&nbsp;Policy</h4></div>
                <ul class="content-list">
                    <li class="list"><a href="/policyDetail" style="text-decoration: none" class="list-li">国家民用空间基础设施中长期发展规划（2015-2025年）</a> <span style="float: right">2018-01-23</span></li>
                    <li class="list"><a href="/policyDetail" style="text-decoration: none" class="list-li">国家民用空间基础设施中长期发展规划（2015-2025年）</a> <span style="float: right">2018-01-23</span></li>
                    <li class="list"><a href="/policyDetail" style="text-decoration: none" class="list-li">国家民用空间基础设施中长期发展规划（2015-2025年）</a> <span style="float: right">2018-01-23</span></li>
                    <li class="list"><a href="/policyDetail" style="text-decoration: none" class="list-li">国家民用空间基础设施中长期发展规划（2015-2025年）</a> <span style="float: right">2018-01-23</span></li>
                </ul>
                <p><a class="btn btn-primary pull-right" href="/news">更多<span class="icon fa fa-arrow-circle-right"></span></a></p>
            </section>
            <section class="col-md-4">
                <div class="module-title"><h4 style="height: 40px; line-height: 40px; color: #fff">&nbsp;&nbsp;&nbsp;中心工作&nbsp;/&nbsp;Work</h4></div>
                <ul class="content-list">
                    <li class="list"><a href="/workDetail" style="text-decoration: none" class="list-li">“高分辨率对地观测系统江苏数据与应用中心”揭牌仪式在东南大学举行</a> <span style="float: right">2017-09-30</span></li>
                    <li class="list"><a href="/workDetail" style="text-decoration: none" class="list-li">“高分辨率对地观测系统江苏数据与应用中心”揭牌仪式在东南大学举行</a> <span style="float: right">2017-09-30</span></li>
                    <li class="list"><a href="/workDetail" style="text-decoration: none" class="list-li">“高分辨率对地观测系统江苏数据与应用中心”揭牌仪式在东南大学举行</a> <span style="float: right">2017-09-30</span></li>
                    <li class="list"><a href="/workDetail" style="text-decoration: none" class="list-li">“高分辨率对地观测系统江苏数据与应用中心”揭牌仪式在东南大学举行</a> <span style="float: right">2017-09-30</span></li>
                </ul>
                <p><a class="btn btn-primary pull-right" href="/news">更多<span class="icon fa fa-arrow-circle-right"></span></a></p>
            </section>
        </div>
    </div>
    <!-- /.container -->
</main>

<footer role="contentinfo">
    <div style="margin-left: 130px">
        <p> 版权所有©高分辨率对地观测系统江苏数据与应用中心 </p>
        <span style="float: right; margin-right: 200px; margin-top: -10px"><a href="#">关于我们</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">联系我们</a></span>
        <p> 地址：江苏省南京市玄武区四牌楼2号 </p>
    </div>
    <!-- /.container -->
</footer>
<script src="../js/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../js/vendor/jquery-1.10.2.min.js"><\/script>')</script>

<!-- Holder.js for project development only -->
<script src="../js/vendor/holder.js"></script>

<!-- Essential Plugins and Main JavaScript File -->
<script src="../js/plugins.js"></script>
<script src="../js/main.js"></script>
</body>
</html>