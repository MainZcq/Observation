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
    <title>我的订单</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <!-- Main Style Sheet -->
    <link rel="stylesheet" href="css/register.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/apply.css">

    <script type="text/javascript" src="js/vendor/jquery-1.10.2.min.js"></script>

    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=pSbIrSzXMLtzRz0DujjiWzSfLnDGGmHM"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>
    <link rel="stylesheet" href="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css" />
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
    <div class="order_mod1">
        <button type="button" class="btn btn-primary collapse_btn" id="c_order">当前订单</button>
        <button type="button" class="btn btn-primary collapse_btn"  id="p_order" style="margin-left: 20px">历史订单</button>
    </div>

    <div class="order_mod2">
        <div class="order_mod2_part1" >
            <table class="bordered">
                <thead>
                <tr>
                    <th style="width: 10%">订单名称</th>
                    <th style="width: 30%">商品信息</th>
                    <th style="width: 10%">订单类型</th>
                    <th style="width: 10%">审核状态</th>
                    <th style="width: 10%">处理状态</th>
                    <th style="width: 10%">订单步骤</th>
                    <th style="width: 10%">下载地址</th>
                    <th style="width: 10%">操作</th>
                </tr>
                </thead>
                <#list CurrentUserOrderList as order>
                    <tr>
                        <td style="line-height: 90px">test</td>
                        <td>
                            <div class="blank2">
                                <div class="product_info1">
                                    订单号: ${order.orderId}<br>
                                    卫星: ${order.satelliteID}<br>
                                    传感器：${order.sensorID}<br>
                                    景序列号：4507856
                                </div>
                                <div class="product_info2">
                                    产品号：${order.productId}<br>
                                    产品级别： ${order.level}级产品<br>
                                    优先级： 6级<br>
                                    订购时间：2018-02-28
                                </div>
                            </div>
                        </td>
                        <td>产品订单 </td>
                        <td>通过审核</td>
                        <td>完成</td>
                        <td>已结束 </td>
                        <td>已失效</td>
                        <td>重新订购</td>
                    </tr>
                </#list>


            </table>

        </div>
        <div class="order_mod2_part2"  style="display: none">
            <table class="bordered">
                <thead>
                <tr>
                    <th style="width: 10%">订单名称</th>
                    <th style="width: 30%">商品信息</th>
                    <th style="width: 10%">订单类型</th>
                    <th style="width: 10%">审核状态</th>
                    <th style="width: 10%">处理状态</th>
                    <th style="width: 10%">订单步骤</th>
                    <th style="width: 10%">下载地址</th>
                    <th style="width: 10%">操作</th>
                </tr>
                </thead>
                <tr>
                    <td style="line-height: 90px">test1</td>
                    <td>
                        <div class="blank2">
                            <div class="product_info1">
                                订单号: 107608994<br>
                                卫星: GF3<br>
                                传感器：SAR<br>
                                景序列号：4507856
                            </div>
                            <div class="product_info2">
                                产品号：2899361<br>
                                产品级别： 1A级产品<br>
                                优先级： 6级<br>
                                订购时间：2018-02-28
                            </div>
                        </div>
                    </td>
                    <td>产品订单 </td>
                    <td>通过审核</td>
                    <td>完成</td>
                    <td>已结束 </td>
                    <td>已失效</td>
                    <td>重新订购</td>
                </tr>
            </table>
        </div>
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



<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.10.2.min.js"><\/script>')</script>

<!-- Holder.js for project development only -->
<script src="js/vendor/holder.js"></script>
<script type="text/javascript" src="js/order.js"></script>
<!-- Essential Plugins and Main JavaScript File -->
<script src="js/plugins.js"></script>
<script src="js/main.js"></script>
</body>
</html>

