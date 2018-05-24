
//order.html//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

$(function () {
    $("#current_order").treetable({ expandable: true });
    $("#previous_order").treetable({ expandable: true });
})

$(function(){
    //点击当前订单
    $("#c_order").click(function(){
        $(".order_mod2_part2").hide();
        $(".order_mod2_part1").show();
    });
    //点击历史订单
    $("#p_order").click(function(){
        $(".order_mod2_part1").hide();
        $(".order_mod2_part2").show();
    });
});





var transferOrderID;//前台传递给后台的该OrderID,以便获取该订单的所有产品的参数信息
var orderName=[];//订单名称，前台接收后台传递的当前订单名称数组
var orderID=[];//订单号，前台接收后台传递的当前订单号数组

var satellite=[];//卫星
var sensor=[];//传感器
var sceneID=[];//景序列号

var productID=[];//产品号
var productLevel=[];//产品级别
var priority=[];//优先级
var orderTime=[];//订购时间

var checkStatus=[];//审核状态
var proceedStatus=[];//处理状态
var orderStep=[];//订单步骤
var downloadAddr=[];//下载地址
// $(window).load(function() {
//
//     alert("test");
// });
$(window).load(function(){

    var productIDList = "test";
    var temp = {
        'orderName':Request[0],
        'orderIntro':Request[1]
    }
    $.ajax({
        url:"/orderList",
        type:'POST',
        data: temp,
        dataType: 'json',
        contentType: 'application/x-www-form-urlencoded; charset=utf-8',
        success : function(data) {
            var myDate = new Date();
            var year = myDate.getFullYear();
            var formatedMonth = ("0" + (myDate.getMonth() + 1)).slice(-2);
            var date = myDate.getDate();

            var orderDate = year+"-"+formatedMonth+"-"+date;


            if (data.length == 0)
                alert("当前没有订单")
            else{
                var j = 0;

                for (var i = 0; i < data.length; i++) {

                    var temp = data[i].orderName;
                    var com = data[i].orderName;
                    //orderName.push(data[i].orderName);

                    orderName2.push(data[i].orderName);
                    //清空数组
                    orderID.length=0;
                    satellite.length=0;
                    sensor.length=0;
                    sceneID.length=0;
                    productID.length=0;
                    productLevel.length=0;
                    priority.length=0;
                    orderTime.length=0;
                    checkStatus.length=0;
                    proceedStatus.length=0;
                    orderStep.length=0;
                    downloadAddr.length=0;

                    orderID2.length=0;
                    satellite2.length=0;
                    sensor2.length=0;
                    sceneID2.length=0;
                    productID2.length=0;
                    productLevel2.length=0;
                    priority2.length=0;
                    orderTime2.length=0;
                    checkStatus2.length=0;
                    proceedStatus2.length=0;
                    orderStep2.length=0;
                    downloadAddr2.length=0;



                    while(com == temp){

                        if(data[i].orderName == Request[0] && data[i].orderIntro == Request[1] && orderDate == data[i].orderTime){
                            orderName.push(data[i].orderName);
                            orderName2.pop();
                            orderID.push(data[i].orderId);
                            satellite.push(data[i].satelliteID);
                            sensor.push(data[i].sensorID);
                            sceneID.push(data[i].sceneID);
                            productID.push(data[i].productID);
                            productLevel.push(data[i].level);
                            priority.push("6级");
                            orderTime.push(data[i].orderTime);
                            checkStatus.push("通过审核");
                            proceedStatus.push("完成");
                            orderStep.push("已结束");
                            downloadAddr.push(data[i].address);//downloadAddr.push(data[i].address);
                            i++;
                            if(i == data.length)
                                break;
                            com = data[i].orderName;
                        }else{
                            orderID2.push(data[i].orderId);
                            satellite2.push(data[i].satelliteID);
                            sensor2.push(data[i].sensorID);
                            sceneID2.push(data[i].sceneID);
                            productID2.push(data[i].productID);
                            productLevel2.push(data[i].level);
                            priority2.push("6级");
                            orderTime2.push(data[i].orderTime);
                            checkStatus2.push("通过审核");
                            proceedStatus2.push("完成");
                            orderStep2.push("已结束");
                            downloadAddr2.push(data[i].address);//downloadAddr.push(data[i].address);
                            i++;
                            if(i == data.length){
                                break;
                            }
                            com = data[i].orderName;
                        }


                    }
                    if(j < orderName2.length)
                        insertPrevious(j);
                    j++;
                    i--;
                }

                insertCurrent(0);
        }
        },
        error : function(data) {
            alert("查询失败 请刷新重试");
        }

    });


});
// 测试：
// orderName.push("TestOrder1");
// orderID.push("107608991");
// satellite.push("GF1");
// sensor.push("SAR");
// sceneID.push("4507856");
// productID.push("2899361");
// productLevel.push("1A级产品");
// priority.push("6级");
// orderTime.push("2018-02-28 ");
// checkStatus.push("通过审核");
// proceedStatus.push("完成");
// orderStep.push("已结束");
// downloadAddr.push("PMI 地址1");
//
// orderName.push("Order2");
// orderID.push("107608992");
// satellite.push("GF2");
// sensor.push("SAR");
// sceneID.push("4507856");
// productID.push("2899362");
// productLevel.push("1A级产品");
// priority.push("6级");
// orderTime.push("2018-02-28 ");
// checkStatus.push("通过审核");
// proceedStatus.push("完成");
// orderStep.push("已结束");
// downloadAddr.push("PMI 地址1");
//
// orderName.push("Order-2018.3.8");
// orderID.push("107608993");

//显示当前订单查询结果
function insertCurrent(index) {
    if(orderName.length==0)
        return;
    $("#current_order").append("<tbody id='tbodyC"+ index + "'></tbody>");
    $("#tbodyC"+ index).append("<tr id='trC"+ index + "' data-tt-id='"+ index + "'></tr>");//data-tt-id="1"
    $("#trC"+ index).append("<td>" + orderName[index] + "</td>");
    $("#trC"+ index).append("<td></td>");
    $("#trC"+ index).append("<td></td>");
    $("#trC"+ index).append("<td></td>");
    $("#trC"+ index).append("<td></td>");
    $("#trC"+ index).append("<td></td>");

    var x;
    for(var i = 0; i < productID.length; i++){
        x=i+1;
        $("#tbodyC"+ index).append("<tr id='trC"+ index + "-" + i + "' data-tt-parent-id='"+ index + "' data-tt-id='"+ index + "-" + i + "'></tr>");
        $("#trC"+ index + "-" + i).append("<td style='line-height: 90px'>【" + x + "】</td>");
        $("#trC"+ index + "-" + i).append("<td id='tdC1"+ index + "-" + i + "'></td>");
        $("#tdC1"+ index + "-" + i).append("<div id='divC1"+ index + "-" + i + "' class='blank2'></div>");
        $("#divC1"+ index + "-" + i).append("<div id='divC2"+ index + "-" + i + "' class='product_info1'></div>");
        $("#divC2"+ index + "-" + i).append("<div>订单号：" + orderID[i] + "</div>");
        $("#divC2"+ index + "-" + i).append("<div>卫星：" + satellite[i] + "</div>");
        $("#divC2"+ index + "-" + i).append("<div>传感器：" + sensor[i] + "</div>");
        $("#divC2"+ index + "-" + i).append("<div>景序列号：" + sceneID[i] + "</div>");

        $("#divC1"+ index + "-" + i).append("<div id='divC3"+ index + "-" + i + "' class='product_info2'></div>");
        $("#divC3"+ index + "-" + i).append("<div>产品号：" + productID[i] + "</div>");
        $("#divC3"+ index + "-" + i).append("<div>产品级别：" + productLevel[i] + "</div>");
        $("#divC3"+ index + "-" + i).append("<div>优先级：" + priority[i] + "</div>");
        $("#divC3"+ index + "-" + i).append("<div>订购时间：" + orderTime[i] + "</div>");

        $("#trC"+ index + "-" + i).append("<td>" + checkStatus[i] + "</td>");
        $("#trC"+ index + "-" + i).append("<td>" + proceedStatus[i] + "</td>");
        $("#trC"+ index + "-" + i).append("<td>" + orderStep[i] + "</td>");
        $("#trC"+ index + "-" + i).append("<td><a href='ftp://192.168.1.106/"+downloadAddr[i]+ "'>" + "下载地址" + "</a></td>");
    }
}

// for(var i = 0; i < orderID.length; i++){
//     insertCurrent(i);//显示当前订单查询结果
//
//     //这里将订单号为orderID[i]的所有产品信息存入各个数组中
//     transferOrderID=orderID[i];
//     //以下将该订单的对应产品的orderID……downloadAddr信息录入相应数组
//
// }

var transferOrderID2;//前台传递给后台的该OrderID,以便获取该订单的所有产品的参数信息
var orderName2=[];//订单名称，前台接收后台传递的当前订单名称数组

var orderID2=[];//订单号，前台接收后台传递的当前订单号数组
var satellite2=[];
var sensor2=[];
var sceneID2=[];

var productID2=[];
var productLevel2=[];
var priority2=[];
var orderTime2=[];

var checkStatus2=[];
var proceedStatus2=[];
var orderStep2=[];
var downloadAddr2=[];

// 测试：
// orderName2.push("TestOrder3");
// orderID2.push("107608994");
//
// satellite2.push("GF3");
// sensor2.push("SAR");
// sceneID2.push("4507856");
// productID2.push("2899361");
// productLevel2.push("1A级产品");
// priority2.push("6级");
// orderTime2.push("2018-02-28 ");
// checkStatus2.push("通过审核");
// proceedStatus2.push("完成");
// orderStep2.push("已结束");
// downloadAddr2.push("PMI 地址1");

//显示历史订单查询结果
function insertPrevious(index) {
    if(orderName2.length==0)
        return;
    $("#previous_order").append("<tbody id='tbodyP"+ index + "'></tbody>");
    $("#tbodyP"+ index).append("<tr id='trP"+ index + "' data-tt-id='"+ index + "'></tr>");//data-tt-id="1"
    $("#trP"+ index).append("<td>" + orderName2[index] + "</td>");
    $("#trP"+ index).append("<td></td>");
    $("#trP"+ index).append("<td></td>");
    $("#trP"+ index).append("<td></td>");
    $("#trP"+ index).append("<td></td>");
    $("#trP"+ index).append("<td></td>");

    var x;
    for(var i = 0; i < productID2.length; i++){
        x=i+1;
        $("#tbodyP"+ index).append("<tr id='trP"+ index + "-" + i + "' data-tt-parent-id='"+ index + "' data-tt-id='"+ index + "-" + i + "'></tr>");
        $("#trP"+ index + "-" + i).append("<td style='line-height: 90px'>【" + x + "】</td>");
        $("#trP"+ index + "-" + i).append("<td id='tdP1"+ index + "-" + i + "'></td>");
        $("#tdP1"+ index + "-" + i).append("<div id='divP1"+ index + "-" + i + "' class='blank2'></div>");
        $("#divP1"+ index + "-" + i).append("<div id='divP2"+ index + "-" + i + "' class='product_info1'></div>");
        $("#divP2"+ index + "-" + i).append("<div>订单号：" + orderID2[i] + "</div>");
        $("#divP2"+ index + "-" + i).append("<div>卫星：" + satellite2[i] + "</div>");
        $("#divP2"+ index + "-" + i).append("<div>传感器：" + sensor2[i] + "</div>");
        $("#divP2"+ index + "-" + i).append("<div>景序列号：" + sceneID2[i] + "</div>");

        $("#divP1"+ index + "-" + i).append("<div id='divP3"+ index + "-" + i + "' class='product_info2'></div>");
        $("#divP3"+ index + "-" + i).append("<div>产品号：" + productID2[i] + "</div>");
        $("#divP3"+ index + "-" + i).append("<div>产品级别：" + productLevel2[i] + "</div>");
        $("#divP3"+ index + "-" + i).append("<div>优先级：" + priority2[i] + "</div>");
        $("#divP3"+ index + "-" + i).append("<div>订购时间：" + orderTime2[i] + "</div>");

        $("#trP"+ index + "-" + i).append("<td>" + checkStatus2[i] + "</td>");
        $("#trP"+ index + "-" + i).append("<td>" + proceedStatus2[i] + "</td>");
        $("#trP"+ index + "-" + i).append("<td>" + orderStep2[i] + "</td>");
        $("#trP"+ index + "-" + i).append("<td><a href='ftp://192.168.1.106/"+downloadAddr2[i]+ "'>" + "下载地址" + "</a></td>");
    }
}

for(var i = 0; i < orderID2.length; i++){
    insertPrevious(i);//显示历史订单查询结果

    //这里将订单号为orderID2[i]的所有产品信息存入各个数组中
    transferOrderID2=orderID2[i];
    //以下将该订单的对应产品的orderID2……downloadAddr2信息录入相应数组
}

var url =decodeURI(location.search); //获取url中"?"符后的字串，使用了两次decodeRUI解码
var Request = [];//order_info.html点击“确认订单”后，表单传递的订单名称和订单描述

if(url.indexOf('?') != -1) {
    var str;//字符串
    var strs;//字符串数组
    str = url.substr(1);　 //去掉?号
    strs = str.split('&');//把一个字符串分割成字符串数组
    for(var i = 0; i < strs.length; i++) {
        Request[i] = (strs[i].split('=')[1]);
    }
}
