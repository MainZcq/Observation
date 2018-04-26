

//login.html///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
function login_check(){
    if((document.getElementById("username").value == "")&&(document.getElementById("password").value == "")){
        alert("请输入用户名和密码！");
        return false;
    }
    else{
        if(document.getElementById("username").value == ""){
            alert("用户名不能为空！");
            return false;
        }
        if(document.getElementById("password").value == ""){
            alert("密码不能为空！");
            return false;
        }
    }
    return true;
}

//register.html////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
var user_Boolean = false;
var password_Boolean = false;
var mobile_Boolean = false;
var company_name_Boolean = false;
var company_addr_Boolean = false;
var department_Boolean = false;
var position_Boolean = false;

var name_Boolean = false;
var confirm_Boolean = false;
var email_Boolean = false;
var zip_code_Boolean = false;
var company_phone_Boolean = false;
var company_type_Boolean = false;
var aim_Boolean = false;

var confirmBox = document.getElementById("cbId");

$('.reg_user').blur(function(){
    if ((/^[A-Za-z0-9_]{4,8}$/).test($(".reg_user").val())){
        $('.user_hint').html("✔").css("color","green");
        user_Boolean = true;
    }else {
        $('.user_hint').html("×").css("color","red");
        user_Boolean = false;
    }
});
$('.reg_password').blur(function(){
    if ((/^[A-Za-z0-9_]{6,16}$/).test($(".reg_password").val())){
        $('.password_hint').html("✔").css("color","green");
        password_Boolean = true;
    }else {
        $('.password_hint').html("×").css("color","red");
        password_Boolean = false;
    }
});
$('.reg_mobile').blur(function(){
    if ((/^1[34578]\d{9}$/).test($(".reg_mobile").val())){
        $('.mobile_hint').html("✔").css("color","green");
        mobile_Boolean = true;
    }else {
        $('.mobile_hint').html("×").css("color","red");
        mobile_Boolean = false;
    }
});
$('.reg_company_name').blur(function(){
    if ((/^[\u4E00-\u9FA5A-Za-z\s]{1,30}$/).test($(".reg_company_name").val())){
        $('.company_name_hint').html("✔").css("color","green");
        company_name_Boolean = true;
    }else {
        $('.company_name_hint').html("×").css("color","red");
        company_name_Boolean = false;
    }
});
$('.reg_company_addr').blur(function(){
    if ((/^[\u4E00-\u9FA5A-Za-z\s]{1,40}$/).test($(".reg_company_addr").val())){
        $('.company_addr_hint').html("✔").css("color","green");
        company_addr_Boolean = true;
    }else {
        $('.company_addr_hint').html("×").css("color","red");
        company_addr_Boolean = false;
    }
});
$('.reg_department').blur(function(){
    if ((/^[\u4E00-\u9FA5A-Za-z\s]{1,15}$/).test($(".reg_department").val())){
        $('.department_hint').html("✔").css("color","green");
        department_Boolean = true;
    }else {
        $('.department_hint').html("×").css("color","red");
        department_Boolean = false;
    }
});
$('.reg_position').blur(function(){
    if ((/^[\u4E00-\u9FA5A-Za-z\s]{1,10}$/).test($(".reg_position").val())){
        $('.position_hint').html("✔").css("color","green");
        position_Boolean = true;
    }else {
        $('.position_hint').html("×").css("color","red");
        position_Boolean = false;
    }
});

$('.reg_name').blur(function(){
    if ((/^[\u4E00-\u9FA5A-Za-z\s]{1,15}$/).test($(".reg_name").val())){
        $('.name_hint').html("✔").css("color","green");
        name_Boolean = true;
    }else {
        $('.name_hint').html("×").css("color","red");
        name_Boolean = false;
    }
});
$('.reg_confirm').blur(function(){
    if (($(".reg_password").val())==($(".reg_confirm").val())){
        $('.confirm_hint').html("✔").css("color","green");
        confirm_Boolean = true;
    }else {
        $('.confirm_hint').html("×").css("color","red");
        confirm_Boolean = false;
    }
});
$('.reg_email').blur(function(){
    if ((/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/).test($(".reg_email").val())){
        $('.email_hint').html("✔").css("color","green");
        email_Boolean = true;
    }else {
        $('.email_hint').html("×").css("color","red");
        email_Boolean = false;
    }
});
$('.reg_zip_code').blur(function(){
    if ((/^\d{6}$/).test($(".reg_zip_code").val())){
        $('.zip_code_hint').html("✔").css("color","green");
        zip_code_Boolean = true;
    }else {
        $('.zip_code_hint').html("×").css("color","red");
        zip_code_Boolean = false;
    }
});
$('.reg_company_phone').blur(function(){
    if ((/^\d{11}$/).test($(".reg_company_phone").val())){
        $('.company_phone_hint').html("✔").css("color","green");
        company_phone_Boolean = true;
    }else {
        $('.company_phone_hint').html("×").css("color","red");
        company_phone_Boolean = false;
    }
});
$('.reg_company_type').change(function () {
    if (($(".reg_company_type").val())==="default_choice"){
        $('.company_type_hint').html("×").css("color","red");
        company_type_Boolean = false;
    }else {
        $('.company_type_hint').html("✔").css("color","green");
        company_type_Boolean = true;
    }
});
$('.reg_aim').change(function () {
    if (($(".reg_aim").val())==="default_choice"){
        $('.aim_hint').html("×").css("color","red");
        aim_Boolean = false;
    }else {
        $('.aim_hint').html("✔").css("color","green");
        aim_Boolean = true;
    }
});

$('#btn_contact_box').click(function(){
    if(!confirmBox.checked){
        alert("请先同意条款");
    }else {
        if(user_Boolean && password_Boolean && mobile_Boolean && company_name_Boolean
            && company_addr_Boolean && department_Boolean &&position_Boolean
            && name_Boolean && confirm_Boolean && email_Boolean && zip_code_Boolean
            && company_phone_Boolean && company_type_Boolean &&aim_Boolean){
            alert("注册成功!  ");
        }else {
            alert("请完善信息!");
        }
    }
});

function showoutc(){$(".m-sPopBg,.m-sPopCon").show();}
function closeClause(){
    $(".m-sPopBg,.m-sPopCon").hide();
}