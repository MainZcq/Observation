<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>产品列表</title>

</head>
<body>
<table  class="table table-bordered" style="border:1px solid #000;">
    <tr>
        <th>订单编号</th><th>用户名</th><th>产品编号</th><th>卫星编号</th><th>传感器编号</th><th>收集时间</th><th>产品等级</th>
        <th>左上经度</th><th>左上纬度</th><th>右下经度</th><th>右下纬度</th>
    </tr>
        <#list CurrentUserOrderList as order>
        <tr>
            <td>${order.orderId}</td> <td>${order.username}</td><td>${order.productId}</td><td>${order.satellite}</td><td>${order.sensorNum}</td><td>${order.collectTime}</td><td>${order.level}</td>
            <td>${order.leftTopLng}</td><td>${order.leftTopLat}</td><td>${order.rightBottomLng}</td><td>${order.rightBottomLat}</td>
        </tr>
        </#list>
</table>

<a href="/product/orderConfirm"><font color="blue">返回</font></a></h1>
<a href="/logout"><font color="blue">注销</font></a></h1>
</body>
</html>