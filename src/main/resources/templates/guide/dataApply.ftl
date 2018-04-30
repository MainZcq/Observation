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
    <title>数据申请</title>
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
                    <a href="/login"><i class="icon fa fa-user fa-lg"></i> <span id = "loginText">登录</span></a>
                    &nbsp;&nbsp;
                    <a href="/shoppingCart"><i class="icon fa fa-shopping-cart fa-lg"></i> <span>购物车</span></a>
                </div>
            </div>
        </div>

    </div>
</header>
<main role="main">
    <div id="baiduMap" class="map_style">
        <!--地图-->
    </div>

    <div class="blank">
        <div class="lookup">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title"  style="text-align: center">
                        <a data-toggle="collapse" href="#collapse1">查询条件</a>
                    </h4>
                </div>
                <div id="collapse1" class="panel-collapse collapse in">
                    <div class="panel-body" style="height: 800px">


                        <button type="button" class="btn btn-primary collapse_btn" id="findbyJW">按经纬度查询</button>
                        <button type="button" class="btn btn-primary collapse_btn"  id="findbyD">按行政区查询</button>

                        <div class="box1">
                            <div class="part1">
                                <div class="mod1">
                                    <label>左上经度：</label>
                                    <input type="text" name="leftTopLng" value="" id="leftTopLng" class="input1">
                                    <label>左上纬度：</label>
                                    <input type="text" name="leftTopLat" value="" id="leftTopLat" class="input1">
                                </div>
                                <div class="mod1">
                                    <label>右下经度：</label>
                                    <input type="text" name="rightBottomLng" value="" id="rightBottomLng" class="input1">
                                    <label>右下纬度：</label>
                                    <input type="text" name="rightBottomLat" value="" id="rightBottomLat" class="input1">
                                </div>
                                <p class="box1_p">单位：度。  实例： 左上角经度：120.111    左上纬度：89.675</p>
                            </div>
                            <div class="part2" style="display: none">
                                <div class="mod1">
                                    <label>省/市/自治区：</label>
                                    <select id="cmbProvince" name="cmbProvince" class="input2"></select>
                                </div>
                                <div class="mod1">
                                    <label>地级市/区：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                    <select id="cmbCity" name="cmbCity" class="input2"></select>
                                </div>
                                <div class="mod1">
                                    <label>县级市/县/区：</label>
                                    <select id="cmbArea" name="cmbArea" class="input2"></select>
                                </div>
                            </div>
                        </div>

                        <div class="box2">
                            <div class="mod1">
                                <label>分辨率≤：</label>
                                <input type="text" name="nominalResolution" value="" id="nominalResolution" class="input2">
                                <label>m</label>
                            </div>
                            <div class="mod1">
                                <label>云量≤：&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                <input type="text" name="cloudPercent" value="" id="cloudPercent" class="input2">
                                <label>%</label>
                            </div>
                            <div class="mod1">
                                <label>产品级别：</label>
                                <select id="product_level" name="level" value="1" class="input2">
                                    <option value="0" selected>零级（相对辐射校验产品）</option>
                                    <option value="3" selected>三级（相对辐射校验产品）</option>
                                    <option value="2" selected>二级（相对辐射校验产品）</option>
                                    <option value="1" selected>一级（相对辐射校验产品）</option>
                                </select>

                            </div>
                            <div class="mod1">
                                <label>采集时间：</label>
                                <input type="date" name="time" value="" id="time1" class="input3">
                                <span>至</span>
                                <input type="date" name="time" value="" id="time2" class="input3">
                            </div>

                        </div>

                        <div class="box3">
                            <p class="box3_p">传感器选择：</p>
                            <div class="mod1">
                                <b class="box3_b">Aqua：&nbsp;&nbsp;</b>
                                <input type="checkbox" name="Aqua" id="MODIS" value="MODIS"><span>MODIS</span>
                            </div>
                            <div class="mod1">
                                <b class="box3_b">GF1：&nbsp;&nbsp;&nbsp;&nbsp;</b>
                                <input type="checkbox" name="GF1" value="PMS1"><span>PMS1</span>
                                <input type="checkbox" name="GF1" value="PMS2"><span>PMS2</span>
                                <input type="checkbox" name="GF1" value="WFV1"><span>WFV1</span>
                                <input type="checkbox" name="GF1" value="WFV2"><span>WFV2</span>
                                <input type="checkbox" name="GF1" value="WFV3"
                                       style="margin-left: 72px; margin-top: 10px"><span>WFV3</span>
                                <input type="checkbox" name="GF1" value="WFV4"><span>WFV4</span>
                            </div>

                            <div class="mod1">
                                <b class="box3_b">GF2：&nbsp;&nbsp;&nbsp;&nbsp;</b>
                                <input type="checkbox" name="GF2" value="PMS1" ><span>PMS1</span>
                                <input type="checkbox" name="GF2" value="PMS2" ><span>PMS2</span>
                            </div>

                            <div class="mod1">
                                <b class="box3_b">GF3：&nbsp;&nbsp;&nbsp;&nbsp;</b>
                                <input type="checkbox" name="GF3" value="SAR" ><span>SAR</span>
                            </div>

                            <div class="mod1">
                                <b class="box3_b">GF4：&nbsp;&nbsp;&nbsp;&nbsp;</b>
                                <input type="checkbox" name="GF4" value="IRS" ><span>IRS</span>
                                <input type="checkbox" name="GF4" value="PMI" ><span>PMI</span>
                                <input type="checkbox" name="GF4" value="PMS" ><span>PMS</span>
                            </div>

                            <div class="mod1">
                                <b class="box3_b">HJ1A：&nbsp;&nbsp;</b>
                                <input type="checkbox" name="HJ1A" value="CCD1" ><span>CCD1</span>
                                <input type="checkbox" name="HJ1A" value="CCD2" ><span>CCD2</span>
                                <input type="checkbox" name="HJ1A" value="HSI" ><span>HSI</span>
                            </div>

                            <div class="mod1">
                                <b class="box3_b">HJ1B：&nbsp;&nbsp;</b>
                                <input type="checkbox" name="HJ1B" value="CCD1" ><span>CCD1</span>
                                <input type="checkbox" name="HJ1B" value="CCD2" ><span>CCD2</span>
                                <input type="checkbox" name="HJ1B" value="IRS" ><span>IRS</span>
                            </div>

                            <div class="mod1">
                                <b class="box3_b">Terra：&nbsp;&nbsp;</b>
                                <input type="checkbox" name="Terra" value="MODIS" ><span>MODIS</span>
                            </div>

                            <div class="mod1">
                                <b class="box3_b">ZY3：&nbsp;&nbsp;&nbsp;&nbsp;</b>
                                <input type="checkbox" name="ZY3" value="MUX" ><span>MUX</span>
                                <input type="checkbox" name="ZY3" value="NAD" ><span>NAD</span>
                                <input type="checkbox" name="ZY3" value="TLC" ><span>TLC</span>
                            </div>

                        </div>

                        <button type="submit" class="btn btn-success submit_btn" id="findProduct" onclick="search()">产品查询</button>

                    </div>
                </div>
            </div>
        </div>

        <div class="product_list">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title"  style="text-align: center">
                        <a data-toggle="collapse" href="#collapse2">产品列表</a>
                    </h4>
                </div>
                <div id="collapse2" class="panel-collapse collapse in">
                    <div class="panel-body" style="height: 800px">

                        <div class="box4">
                            <div class="mod1">
                                <label>排序方式：</label>

                                <select id="result_sort" class="input2">
                                    <option value="satellite" selected>卫星</option>
                                    <option value="collect_time">采集时间</option>
                                </select>
                            </div>
                        </div>

                        <!--<div class="box5">-->
                        <!--<div class="mod1">-->
                        <!--<div id="pageDiv"></div>-->
                        <!--</div>-->
                        <!--</div>-->

                        <div class="box6">
                            <!--<div class="mod1">-->
                            <table class="bordered">
                                <thead>
                                <tr>
                                    <th style="width: 10%">
                                        <input type="checkbox" name="select_all" value="select_all" id="select_all">
                                    </th>
                                    <th style="width: 15%">卫星</th>
                                    <th style="width: 15%">传感器</th>
                                    <th  style="width: 25%">采集时间</th>
                                    <th style="width: 20%">分辨率(m)</th>
                                    <th style="width: 15%">云量(%)</th>
                                </tr>
                                </thead>
                                <tbody id="TbData"></tbody>
                            </table>
                            <!--</div>-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--<div style="height: 300px; margin-top: 100px;">-->
    <!--<select id="cmbProvince" name="cmbProvince"></select>-->
    <!--<select id="cmbCity" name="cmbCity"></select>-->
    <!--<select id="cmbArea" name="cmbArea"></select>-->
    <!--</div>-->


</main>

<footer>
    <div class="footer_style">
        <div class="foot_text">
            <p> 版权所有margin-left: 130px©高分辨率对地观测系统江苏数据与应用中心 </p>
            <!--<span><a href="#">关于我们</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">联系我们</a></span>-->

            <p> 地址：江苏省南京市玄武区四牌楼2号 </p>
        </div>
    </div>
</footer>

<script src="js/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.10.2.min.js"><\/script>')</script>
<script type="text/javascript">
    $(window).load(function(){
        var currentUser ="${currentUser}";
        if(currentUser == ""){
            $("#loginText").text("登录");
            $("#loginText").show();
        }

        else{
            $("#loginText").text(currentUser);
            $("#loginText").show();
        }

    });
    function search() {

        var leftTopLng = $("#leftTopLng").val();
        var leftTopLat = $("#leftTopLat").val();
        var rightBottomLng = $("#rightBottomLng").val();
        var rightBottomLat = $("#rightBottomLat").val();
        var nominalResolution=$("#nominalResolution").val();
        var cloudPercent=$("#cloudPercent").val();
        var level=$("#product_level").val();

        var time1=$("#time1").val();
        var time2=$("#time2").val();
        var chk_value1 =[];//定义一个数组
        $('input[name="GF1"]:checked').each(function(){//遍历每一个名字为GF1的复选框，其中选中的执行函数
            chk_value1.push($(this).val());//将选中的值添加到数组chk_value中
        });

        var chk_value2 =[];//定义一个数组
        $('input[name="GF2"]:checked').each(function(){//遍历每一个名字为GF1的复选框，其中选中的执行函数
            chk_value2.push($(this).val());//将选中的值添加到数组chk_value中
        });


        var chk_value3 =[];//定义一个数组
        $('input[name="GF3"]:checked').each(function(){//遍历每一个名字为GF1的复选框，其中选中的执行函数
            chk_value3.push($(this).val());//将选中的值添加到数组chk_value中
        });


        var chk_value4 =[];//定义一个数组
        $('input[name="GF4"]:checked').each(function(){//遍历每一个名字为GF1的复选框，其中选中的执行函数
            chk_value4.push($(this).val());//将选中的值添加到数组chk_value中
        });


        var chk_value5 =[];//定义一个数组
        $('input[name="HJ1A"]:checked').each(function(){//遍历每一个名字为GF1的复选框，其中选中的执行函数
            chk_value5.push($(this).val());//将选中的值添加到数组chk_value中
        });


        var chk_value6 =[];//定义一个数组
        $('input[name="HJ1B"]:checked').each(function(){//遍历每一个名字为GF1的复选框，其中选中的执行函数
            chk_value6.push($(this).val());//将选中的值添加到数组chk_value中
        });


        var chk_value7 =[];//定义一个数组
        $('input[name="Terra"]:checked').each(function(){//遍历每一个名字为GF1的复选框，其中选中的执行函数
            chk_value7.push($(this).val());//将选中的值添加到数组chk_value中
        });


        var chk_value8 =[];//定义一个数组
        $('input[name="ZY3"]:checked').each(function(){//遍历每一个名字为GF1的复选框，其中选中的执行函数
            chk_value8.push($(this).val());//将选中的值添加到数组chk_value中
        });


        var chk_value9 =[];//定义一个数组
        $('input[name="Aqua"]:checked').each(function(){//遍历每一个名字为GF1的复选框，其中选中的执行函数
            chk_value9.push($(this).val());//将选中的值添加到数组chk_value中
        });

        var sensor={
            'GF1':chk_value1,
            'GF2':chk_value2,
            'GF3':chk_value3,
            'GF4':chk_value4,
            'HJ1A':chk_value5,
            'HJ1B':chk_value6,
            'Terra':chk_value7,
            'ZY3':chk_value8,
            'Aqua':chk_value9,
        }

        var temp = {
            'leftTopLng':leftTopLng,
            'leftTopLat':leftTopLat,
            'rightBottomLng':rightBottomLng,
            'rightBottomLat':rightBottomLat,
            'nominalResolution':nominalResolution,
            'cloudPercent':cloudPercent,
            'level':level,
            'produceTime':time1+";"+time2,
            'satelliteID': "GF3",
            'sensorID': JSON.stringify(sensor),
        };




        $.ajax({
            url:"/product/search",
            type:'POST',
            data: temp,
            dataType: 'JSON',
            contentType: 'application/x-www-form-urlencoded; charset=utf-8',
            success : function(data) {
                alert(data[0].productID);
                var html="";
                for(var i= 0;i < data.length;i++) {
                    html += "<tr>",
                    html +="<td>" +
                      "<input type=\"checkbox\" name=\"select\" value=\"select\"  class=\"select_choose\">"
                    +"</td>";
                    html += "</td>",
                    html += "<td>" + data[i].satelliteID + "</td>";
                    html += "<td>" + data[i].sensorID + "</td>";
                    html += "<td>" + data[i].produceTime + "</td>";
                    html += "<td>" + data[i].nominalResolution + "</td>";
                    html += "<td>" + data[i].cloudPercent + "</td>";
                    html += "</td>"
                }
                $("#TbData").html(html);
            },
            error : function(data) {
                alert("查询错误");

            }

        });

    }

</script>
<!-- Holder.js for project development only -->
<script src="js/vendor/holder.js"></script>
<script type="text/javascript" src="js/apply.js"></script>
<script type="text/javascript">
    addressInit('cmbProvince', 'cmbCity', 'cmbArea');
</script>
<!-- Essential Plugins and Main JavaScript File -->
<script src="js/plugins.js"></script>
<script src="js/main.js"></script>
</body>
</html>