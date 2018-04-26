<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>产品列表</title>

</head>
<body>
<table  class="table table-bordered" style="border:1px solid #000;">
    <tr>
        <th>产品编号</th><th>卫星</th><th>传感器编号</th><th>收集时间</th><th>产品等级</th><th>省</th><th>市</th><th>区</th>
        <th>左上经度</th><th>左上纬度</th><th>右下经度</th><th>右下纬度</th>
    </tr>
        <#list productList as product>
        <tr>
            <td>${product.productID}</td> <td>${product.satelliteID}</td><td>${product.sensorID}</td><td>${product.produceTime}</td><td>${product.level}</td><td>${product.province}</td><td>${product.city}</td>
            <td>${product.county}</td><td>${product.leftTopLng}</td><td>${product.leftTopLat}</td><td>${product.rightBottomLng}</td><td>${product.rightBottomLat}</td>
            <td><button id = "order" onclick="order(${product.id})">订购</td>
        </tr>
        </#list>
</table>
<a href="/product/orderList"><font color="blue">订单列表</font></a>
<a href="/"><font color="blue">返回</font></a>
<a href="/logout"><font color="blue">注销</font></a>

<script src="https://code.jquery.com/jquery.js"></script>

<script type="text/javascript">
    function order(productId) {

        $.ajax({
            url:"/orders",
            type:'POST',
            data:{'productId':productId},
            dataType: 'json',
            contentType: 'application/x-www-form-urlencoded; charset=utf-8',
            success : function(data) {

                //var eValue=eval('data.county');
                //alert("当前城市"+data.province+data.city);
                localStorage.setItem("satelliteID",data.satelliteID);
                localStorage.setItem("produceTime",data.produceTime);
                localStorage.setItem("county",data.county);
                localStorage.setItem("leftTopLat",data.leftTopLat);
                localStorage.setItem("leftTopLng",data.leftTopLng);
                localStorage.setItem("level",data.level);
                localStorage.setItem("productID",data.productID);
                localStorage.setItem("province",data.province);
                localStorage.setItem("city",data.city);
                localStorage.setItem("rightBottomLat",data.rightBottomLat);
                localStorage.setItem("rightBottomLng",data.rightBottomLng);
                localStorage.setItem("sensorID",data.sensorID);
                localStorage.setItem("nominalResolution",data.nominalResolution);
                localStorage.setItem("imagingMode",data.imagingMode);
                //alert("当前"+data);
                window.location.href="/product/orderConfirm";
            },

            error : function(data) {
                alert("请登陆");
                window.location.href="/login";
            }

        });

    }


</script>
</body>
</html>