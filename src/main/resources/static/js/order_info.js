
var orderName;//前台记录的用户填写的订单名称
var orderIntro;//前台记录的用户填写的订单描述
var transferPID=[];//前台记录的该订单的产品号

var productID=[];//产品号
var satellite=[];//卫星
var sensor=[];//传感器
var sceneID=[];//景序列号
var productLevel=[];//产品级别
var collectTime=[];//采集时间

//测试：
productID.push("2899361");
satellite.push("GF3");
sensor.push("SAR");
sceneID.push("4507856");
productLevel.push("1A级产品");
collectTime.push("2018-01-31");

productID.push("2899361");
satellite.push("GF2");
sensor.push("SAR");
sceneID.push("4507856");
productLevel.push("1A级产品");
collectTime.push("2018-01-31");

productID.push("2899361");
satellite.push("GF1");
sensor.push("SAR");
sceneID.push("4507856");
productLevel.push("1A级产品");
collectTime.push("2018-01-31");

function InsertOrder(index) {
    $("#order_info").append("<tr id='trOrder"+ index + "'></tr>");
    $("#trOrder"+ index).append("<td>" + productID[index] + "</td>");
    $("#trOrder"+ index).append("<td>" + satellite[index] + "</td>");
    $("#trOrder"+ index).append("<td>" + sensor[index] + "</td>");
    $("#trOrder"+ index).append("<td>" + sceneID[index] + "</td>");
    $("#trOrder"+ index).append("<td>" + productLevel[index] + "</td>");
    $("#trOrder"+ index).append("<td>" + collectTime[index] + "</td>");
}

for(var i = 0; i < productID.length; i++){
    InsertOrder(i);
}

function SendFormOrder(){
    if( ($("#order_name").val()=="")||($("#order_intro").val()=="") ){
        alert("请填写完整的订单信息！");
        return false;
    }
    else{
        orderName=$("#order_name").val();
        orderIntro=$("#order_intro").val();
        for(var i = 0; i < productID.length; i++){
            transferPID.push(productID[i]);
        }
        // alert(orderName+"  "+orderIntro);
        return true;
    }
}

