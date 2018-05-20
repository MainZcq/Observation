
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
// productID.push("2899361");
// satellite.push("GF3");
// sensor.push("SAR");
// sceneID.push("4507856");
// productLevel.push("1A级产品");
// collectTime.push("2018-01-31");
//
// productID.push("2899361");
// satellite.push("GF2");
// sensor.push("SAR");
// sceneID.push("4507856");
// productLevel.push("1A级产品");
// collectTime.push("2018-01-31");
//
// productID.push("2899361");
// satellite.push("GF1");
// sensor.push("SAR");
// sceneID.push("4507856");
// productLevel.push("1A级产品");
// collectTime.push("2018-01-31");

// function InsertOrder(index) {
//     $("#order_info").append("<tr id='trOrder"+ index + "'></tr>");
//     $("#trOrder"+ index).append("<td>" + productID[index] + "</td>");
//     $("#trOrder"+ index).append("<td>" + satellite[index] + "</td>");
//     $("#trOrder"+ index).append("<td>" + sensor[index] + "</td>");
//     $("#trOrder"+ index).append("<td>" + sceneID[index] + "</td>");
//     $("#trOrder"+ index).append("<td>" + productLevel[index] + "</td>");
//     $("#trOrder"+ index).append("<td>" + collectTime[index] + "</td>");
// }

for(var i = 0; i < productID.length; i++){
    InsertOrder(i);
}

// function SendFormOrder(){
//     if( ($("#order_name").val()=="")||($("#order_intro").val()=="") ){
//         alert("请填写完整的订单信息！");
//         return false;
//     }
//     else{
//         orderName=$("#order_name").val();
//         orderIntro=$("#order_intro").val();
//         for(var i = 0; i < productID.length; i++){
//             transferPID.push(productID[i]);
//         }
//         // alert(orderName+"  "+orderIntro);
//         return true;
//     }
// }
function SendFormOrder(){
    if( ($("#order_name").val()=="")||($("#order_intro").val()=="") ){
        alert("请填写完整的订单信息！");
        return false;
    }
    else{
        var productIDList = [];
        productIDList = Request;
        var orderN=$("#order_name").val();
        var orderI=$("#order_intro").val();
        var temp = {
            'productIDList': JSON.stringify(productIDList),
            'orderName': orderN,
            'orderIntro': orderI
        }
        $.ajax({
            url:"/orderConfirm",
            type:'POST',
            data: temp,
            dataType: 'json',
            async:false,
            contentType: 'application/x-www-form-urlencoded; charset=utf-8',
            success : function(data) {
                var index = 0;
                var html="";

                for(var i= 0;i < data.length;i++) {
                    html += "<td>" +
                        "<input  style=\"display:none\" value=\"" + data[i] + "\" id=\"input" + index + "\">"
                        + "</td>";
                }
                $('#orderId').html(html);

            },
            error : function(data) {
                alert("订购失败  未知错误");
            }

        });
    }
}

var url = location.search;
var Request = [];//shopping_cart.html点击“生成订单”后，表单传递的sceneID数组

if(url.indexOf('?') != -1) {
    var str;//字符串
    var strs;//字符串数组
    str = url.substr(1);　 //去掉?号
    strs = str.split('&');//把一个字符串分割成字符串数组
    for(var i = 0; i < strs.length; i++) {
        // Request[strs[i].split('=')[0]] = unescape(strs[i].split('=')[1]);
        Request[i] = (strs[i].split('=')[1]);
    }
}

$(window).load(function(){

    var productIDList = [];
    productIDList = Request;

    var temp = {
        'productIDList': JSON.stringify(productIDList)
    }
    $.ajax({
        url:"/product/searchByID",
        type:'POST',
        data: temp,
        dataType: 'json',
        contentType: 'application/x-www-form-urlencoded; charset=utf-8',
        success : function(data) {
            length = data.length;
            var index = 0;
            var html="";
            for(var i= 0;i < data.length;i++) {
                index++;
                html += "<tr>",
                html += "<td>" + data[i].productID + "</td>";
                html += "<td>" + data[i].satelliteID + "</td>";
                html += "<td>" + data[i].sensorID + "</td>";
                html += "<td>" + data[i].sceneID + "</td>";
                html += "<td>" + data[i].level + "</td>";
                html += "<td>" + data[i].produceTime + "</td>";
                html += "</tr>"
            }
            $('#TbData').html(html);

        },
        error : function(data) {
            alert("查询错误");

        }

    });
});