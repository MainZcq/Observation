<!DOCTYPE html>

<html lang="en">
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>确认订单信息</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <!-- Main Style Sheet -->
    <link rel="stylesheet" href="css/register.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/apply.css">

    <script type="text/javascript" src="js/vendor/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="js/register.js"></script>
    <!-- Modernizr -->
    <script src="js/vendor/modernizr-2.6.2.min.js"></script>
    <!-- Respond.js for IE 8 or less only -->
    <!--[if (lt IE 9) & (!IEMobile)]>
    <script src="js/vendor/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<header>
    <div class="header_style">
        <div class="container">
            <div class="row">
                <a href="/">
                    <div class="col-md-4 nav-left">
                        <p>高分数据服务系统</p>
                    </div>
                </a>
                <div class="col-md-6 nav-mid">
                    <ul class="nav nav-pills">
                        <li><a href="/dataApply">数据查询</a> </li>
                        <li><a href="/order">订单管理</a> </li>
                    </ul>

                </div>
                <div class="col-md-2 nav-right">
                    <a href="/login"><i class="icon fa fa-user fa-lg"></i> <span>登录</span></a>
                    &nbsp;&nbsp;
                    <a href="/shoppingCart"><i class="icon fa fa-shopping-cart fa-lg"></i> <span>购物车</span></a>
                </div>
            </div>
        </div>

    </div>
</header>
<main role="main">
    <div class="order_info_mod1">
        <!--<div class="form_div">-->
        <h2 style="margin-bottom: 30px;margin-left:65px">订单详情</h2>
        <!--</div>-->
        <table class="bordered" id="order_info">
            <thead>
            <tr>
                <th style="width: 15%">产品号</th>
                <th style="width: 15%">卫星</th>
                <th style="width: 15%">传感器</th>
                <th style="width: 15%">景序列号</th>
                <th style="width: 15%">产品级别</th>
                <th style="width: 25%">采集时间</th>
            </tr>
            </thead>
        </table>
    </div>

    <div class="order_info_mod2">
        <form  id="form4" name="form4" action="order.html" onSubmit="return SendFormOrder()">
            <div class="form_div">
                <h3>填写订单信息</h3>
            </div>

            <ul class="ul_style">
                <li>
                    <span>订单名称：</span>
                    <input type="text" name="order_name" value="" id="order_name" style="width: 450px">
                </li>
                <li>
                    <span>订单描述：</span>
                    <textarea id="order_intro" rows="4" cols="61" style="resize:none"></textarea>
                </li>
                <li>
                    <button type="submit" class="btn btn-success collapse_btn" id="confirm_order">确认订单</button>
                </li>
            </ul>
        </form>
    </div>






</main>

<footer>
    <div class="footer_style" style="bottom: 0px; position: fixed">
        <div class="foot_text">
            <p> 版权所有margin-left: 130px©高分辨率对地观测系统江苏数据与应用中心 </p>
            <!--<span><a href="#">关于我们</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">联系我们</a></span>-->

            <p> 地址：江苏省南京市玄武区四牌楼2号 </p>
        </div>
    </div>
</footer>

<script type="text/javascript">

</script>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.10.2.min.js"><\/script>')</script>

<!-- Holder.js for project development only -->
<script src="js/vendor/holder.js"></script>
<script type="text/javascript" src="js/order_info.js"></script>

<!-- Essential Plugins and Main JavaScript File -->
<script src="js/plugins.js"></script>
<script src="js/main.js"></script>
</body>
</html>

