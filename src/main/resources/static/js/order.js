
//order.html//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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


//shopping_cart.html//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
$("#select_all2").click(function(){//给全选按钮加上点击事件
    var selectall = $(this).prop("checked");//判断全选按钮的选中状态
    $(".select_choose2").prop("checked",selectall);  //让class名为select_choose的选项的选中状态和全选按钮的选中状态一致。
})