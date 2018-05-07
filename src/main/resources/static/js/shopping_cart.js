//shopping_cart.html//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

var piece=[];//购物车中每条商品记录的行id集合

var productID=[];//产品号
var satellite=[];//卫星
var sensor=[];//传感器
var sceneID=[];//景序列号
var productLevel=[];//产品级别
var collectTime=[];//采集时间

//测试
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

function InsertCart(index) {
    $("#shop_cart").append("<tr id='trCart"+ index + "'></tr>");
    $("#trCart"+ index).append("<td id='tdCart"+ index + "'></td>");
    $("#tdCart"+ index).append("<input type='checkbox' class='select_choose2' name='select2' value='select2' id='inputCart"+ index + "'>");
    $("#trCart"+ index).append("<td>" + productID[index] + "</td>");
    $("#trCart"+ index).append("<td>" + satellite[index] + "</td>");
    $("#trCart"+ index).append("<td>" + sensor[index] + "</td>");
    $("#trCart"+ index).append("<td>" + sceneID[index] + "</td>");
    $("#trCart"+ index).append("<td>" + productLevel[index] + "</td>");
    $("#trCart"+ index).append("<td>" + collectTime[index] + "</td>");

    var id_tr="trCart"+ index;
    return id_tr;
}

for(var i = 0; i < productID.length; i++){
    piece[i]=InsertCart(i);
}

var tranfer_order=[];//前台记录的用户从购物车中选择的产品id
function SendFormCart(){
    var isChosen=false;
    for(var i = 0; i < productID.length; i++){
        if($("#inputCart"+ i).prop("checked")){
            isChosen=true;
            tranfer_order.push(productID[i]);
        }
    }
    if(!isChosen){
        alert("请选择需要的数据！");
        return false;
    }
    else {
        return true;
    }
}

var tranfer_delete=[];//前台记录的用户从购物车中删除的产品id
function SendFormCart2(){
    var isChosen=false;
    // var del=[];
    for(var i = 0; i < productID.length; i++){
        // del[i]=false;
        if($("#inputCart"+ i).prop("checked")){
            isChosen=true;
            // del[i]=true;
        }
    }
    if(!isChosen){
        alert("请选择要删除的数据！");
        // return false;
    }
    else {
        if(confirm("确认要从购物车中删除该数据吗?")){
            // alert("点击了确认按钮");
            for(var j = 0; j < productID.length; j++){
                if($("#inputCart"+ j).prop("checked")){
                    $("#"+ piece[j]).remove();
                    tranfer_delete.push(productID[i]);
                }
            }
        }
    }
}

// $("#delete_product").click(function(){//给删除按钮加上点击事件
//     for(var i = 0; i < productID.length; i++){
//         if($("#inputCart"+ i).prop("checked")){
//             $("#"+ piece[i]).remove();
//         }
//     }
// })

$("#select_all2").click(function(){//给全选按钮加上点击事件
    var selectall = $(this).prop("checked");//判断全选按钮的选中状态
    $(".select_choose2").prop("checked",selectall);  //让class名为select_choose2的选项的选中状态和全选按钮的选中状态一致。
})
