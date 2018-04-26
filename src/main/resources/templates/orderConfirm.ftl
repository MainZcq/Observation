<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>产品列表</title>

</head>
<body>

<table  class="table table-bordered" style="border:1px solid #000;">

    <tr>
        <th>订单编号</th><th>用户名</th><th>产品编号</th><th>卫星</th><th>传感器编号</th><th>收集时间</th><th>产品等级</th><th>省</th><th>市</th><th>区</th>
        <th>左上经度</th><th>左上纬度</th><th>右下经度</th><th>右下纬度</th>

    </tr>

        <tr id="recordData">
            <td>${MaxOrderId}</td> <td>${userName}</td>
        </tr>

    <td><button id = "confirm" onclick="orderConfirm()">确认订购</button></td>

</table>
<a href="/currentOrderList"><font color="blue">当前用户历史订单</font></a>
<a href="/product/productList"><font color="blue">返回</font></a>
<a href="/logout"><font color="blue">注销</font></a>

<script src="https://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
    $(window).load(function(){

        //var eValue=eval('currentRecord.satellite');
        $("#recordData").append("<td>"+localStorage.getItem("productID")+"</td>");
        $("#recordData").append("<td>"+localStorage.getItem("satelliteID")+"</td>");
        $("#recordData").append("<td>"+localStorage.getItem("sensorID")+"</td>");
        $("#recordData").append("<td>"+localStorage.getItem("produceTime")+"</td>");
        $("#recordData").append("<td>"+localStorage.getItem("level")+"</td>");
        $("#recordData").append("<td>"+localStorage.getItem("province")+"</td>");
        $("#recordData").append("<td>"+localStorage.getItem("city")+"</td>");
        $("#recordData").append("<td>"+localStorage.getItem("county")+"</td>");
        $("#recordData").append("<td>"+localStorage.getItem("leftTopLng")+"</td>");
        $("#recordData").append("<td>"+localStorage.getItem("leftTopLat")+"</td>");
        $("#recordData").append("<td>"+localStorage.getItem("rightBottomLng")+"</td>");
        $("#recordData").append("<td>"+localStorage.getItem("rightBottomLat")+"</td>");

    });

    function orderConfirm(){
        var maxOrderId ="${MaxOrderId}";
        var uName ="${userName}";
        var pId =localStorage.getItem("productId");

      /* var orderType
        {
            "orderId":maxOrderId,
            "productId":pId,
            "cardNum":uName,

        }*/
        $.ajax({
            url:"/order/orderToDataBases",

            data:{'orderId':maxOrderId,'productId':pId,'username': uName},//JSON.stringify({'orderId':maxOrderId,'productId':pId,'name': uName}),
            dataType: "text",
            contentType: 'application/json;charset=utf-8',
            success : function(data) {
                alert("订购成功")
            },

            error : function(data) {
                alert('错误'+ data);
            }

        });

    }
</script>
</body>
</html>