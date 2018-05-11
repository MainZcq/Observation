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
    <title>购物车</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <!-- Main Style Sheet -->
    <link rel="stylesheet" href="css/register.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/apply.css">

    <script type="text/javascript" src="js/vendor/jquery-1.10.2.min.js"></script>
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

    <form id="form3" name="form3" action="/orderInfo" onSubmit="return SendFormCart()">
        <div class="shopping_cart_mod1">
            <div class="blank3">
                <div class="btn1">

                    <button type="submit" class="btn btn-success collapse_btn" id="generate_order">生成订单</button>

                </div>
                <div class="btn2">
                    <!--<form class="btn2" id="form4" name="form4" onSubmit="return SendFormCart2()">-->
                    <button type="submit" class="btn btn-danger collapse_btn btn2" id="delete_product"
                            style="margin-left: 20px" onclick="SendFormCart2()">删除
                    </button>
                    <!--</form>-->
                </div>
            </div>
        </div>

        <div class="shopping_cart_mod2">
            <table class="bordered" id="shop_cart">
                <thead>
                <tr>
                    <th style="width: 5%">
                        <input type="checkbox" id="select_all2">
                    </th>
                    <th style="width: 15%">产品号</th>
                    <th style="width: 15%">卫星</th>
                    <th style="width: 15%">传感器</th>
                    <th style="width: 15%">景序列号</th>
                    <th style="width: 15%">产品级别</th>
                    <th style="width: 20%">采集时间</th>
                </tr>
                </thead>
                <tbody id="TbData"></tbody>
            </table>
        </div>

    </form>


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
<script type="text/javascript" src="js/shopping_cart.js"></script>

<!-- Essential Plugins and Main JavaScript File -->
<script src="js/plugins.js"></script>
<script src="js/main.js"></script>
</body>
</html>

