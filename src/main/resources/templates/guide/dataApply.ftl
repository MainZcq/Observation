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
                            <div class="part1" style="height: 210px;">
                                <div class="mod1">
                                    <label>左上经度：</label>
                                    <input type="text" name="RightupJ" value="" id="leftTopLng" class="input1">
								</div>
                                <div class="mod1">
                                    <label>左上纬度：</label>
                                    <input type="text" name="RightupW" value="" id="leftTopLat" class="input1">
                                </div>
                                <div class="mod1">
                                    <label>右下经度：</label>
                                    <input type="text" name="LeftdownJ" value="" id="rightBottomLng" class="input1">
								</div>
                                <div class="mod1">
                                    <label>右下纬度：</label>
                                    <input type="text" name="LeftdownW" value="" id="rightBottomLat" class="input1">
                                </div>
                                <p class="box1_p">单位：度。  实例： 左上角经度：120.111213    左上纬度：89.675340</p>
                            </div>
                            <div class="part2" style="display: none; height: 120px">
                                <div class="mod1">
                                    <label>省/市/自治区：</label>
                                    <select id="province" name="province" onchange="doProvAndCityRelation();" class="input1">　　　　　　　
                                        <option id="choosePro"value="-1">请选择省份</option>　　　　　
                                    </select>
                                    <!--<select id="cmbProvince" name="cmbProvince" class="input1"></select>-->
                                </div>
                                <div class="mod1">
                                    <label>地级市/区：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                    <!--<select id="cmbCity" name="cmbCity" class="input1"></select>-->
                                    <select id="citys" name="city" onchange="doCityAndCountyRelation();" class="input1">　　　　　　　　
                                        <option id='chooseCity' value='-1'>请选择城市</option>　　　　　　
                                    </select>
                                </div>
                                <div class="mod1">
                                    <label>县级市/县/区：</label>
                                    <!--<select id="cmbArea" name="cmbArea" class="input1"></select>-->
                                    <select id="county" name="county" onchange="doCounty();" class="input1">　　　　　　　
                                        <option id='chooseCounty' value='-1'>请选择区/县</option>　　　　　
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="box2">
                            <div class="mod1">
                                <label>分辨率≤：</label>
                                <input type="text" name="nominalResolution" value="" id="nominalResolution" class="input1">
                                <label>m</label>
                            </div>
                            <div class="mod1">
                                <label>云量≤：&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                <input type="text" name="cloudPercent" value="" id="cloudPercent" class="input1">
                                <label>%</label>
                            </div>
                            <div class="mod1">
                                <label>产品级别：</label>
                                <select id="product_level" name="level" value="1" class="input1">
                                    <option value="0" selected>零级（相对辐射校验产品）</option>
                                    <option value="3" selected>三级（相对辐射校验产品）</option>
                                    <option value="2" selected>二级（相对辐射校验产品）</option>
                                    <option value="1" selected>一级（相对辐射校验产品）</option>
                                </select>

                            </div>
                            <div class="mod1">
                                <label>采集时间：</label>
                                <input type="date" name="time" value="" id="time1" class="input1">
                                <span>至</span>
                            </div>
							<input type="date" name="time" value="" id="time2" class="input1" style="margin-left: 83px; margin-top: 10px">
                           

                        </div>

                        <div class="box3">
                            <p class="box3_p">传感器选择：</p>

                            <div class="mod1">
                                <b class="box3_b">GF1：&nbsp;&nbsp;&nbsp;&nbsp;</b>
                                <input type="checkbox" name="GF1" value="PMS1"><span>PMS1</span>
                                <input type="checkbox" name="GF1" value="PMS2"><span>PMS2</span>
                                <input type="checkbox" name="GF1" value="WFV1"><span>WFV1</span>
                                <input type="checkbox" name="GF1" value="WFV2" style="margin-left: 72px; margin-top: 10px"><span>WFV2</span>
                                <input type="checkbox" name="GF1" value="WFV3"><span>WFV3</span>
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

                          
                        </div>

                        <button type="submit" class="btn btn-success submit_btn1" id="findProduct" onclick="SendFormInqury()">产品查询</button>

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
                <div id="collapse2" class="panel-collapse collapse">
                    <div class="panel-body" style="height: 800px">


                        <form  id="form2" name="form2" action="/shoppingCart" onSubmit="return SendFormSubmit()">
                            <button type="submit" class="btn btn-success submit_btn2" id="submitOrder">加入购物车</button>
                            <!--<div class="box5">-->
                                <!--<div class="mod1">-->
                                    <!--<div id="pageDiv"></div>-->
                                <!--</div>-->
                            <!--</div>-->
							
                            <div class="box6">
                                <!--<div class="mod1">-->
                                <table class="bordered" id="result_list">
                                    <thead id="thead1">
                                    <tr class="title_hover">
                                        <th style="width: 8%">
                                            <input type="checkbox" id="select_all">
                                        </th>
                                        <!--<a href="#" onclick="$.sortTable.sort('result_list',0)"><th style="width: 15%">卫星</th></a>-->
                                        <th style="width: 15%" onclick="$.sortTable.sort('result_list',1)">卫星</th>
                                        <th style="width: 15%" onclick="$.sortTable.sort('result_list',2)">传感器</th>
                                        <th style="width: 22%" onclick="$.sortTable.sort('result_list',3)">采集时间</th>
                                        <th style="width: 20%" onclick="$.sortTable.sort('result_list',4)">分辨率(m)</th>
                                        <th style="width: 20%" onclick="$.sortTable.sort('result_list',5)">云量(%)</th>
                                    </tr>
                                    </thead>
                                    <tbody id="TbData"></tbody>
                                </table>
                                <!--</div>-->
                            </div>
                        </form>

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
    //var length;
	
	function SendFormSubmit(){
    var isChosen=false;
    var productIDList = [];
    for(var i = 0; i < record.length; i++){
        if($("#input"+ i).prop("checked")){
            isChosen=true;
            productIDList.push($("#input"+ i).val())
        }

    }


    var currentUser ="${currentUser}";
    if(currentUser == ""){//未登录
        alert("请先登录！");
        return false;
    }
    else{//已登录
        if(!isChosen){//未选择产品
            alert("请选择要加入购物车的产品！");
            return false;
        }
        else {//
            var temp = {
                'productIDList': JSON.stringify(productIDList)
            }
            $.ajax({
                url:"/product/insertIntoShoppingCart",
                type:'POST',
                data: temp,
                dataType: 'text',
                async:false,
                contentType: 'application/x-www-form-urlencoded; charset=utf-8',
                success : function(data) {
                    alert("加入购物车成功");
                },
                error : function(data) {
                    alert("加入购物车失败，请重试");
                }

            });
            return true;
        }
    }
	}

</script>
<!-- Holder.js for project development only -->
<script src="js/vendor/holder.js"></script>
<script type="text/javascript" src="js/apply.js"></script>
<script type="text/javascript">

</script>
<!-- Essential Plugins and Main JavaScript File -->
<script src="js/plugins.js"></script>
<script src="js/main.js"></script>
</body>
</html>