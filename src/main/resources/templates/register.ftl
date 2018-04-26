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
    <title>用户注册</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <!-- Main Style Sheet -->
    <link rel="stylesheet" href="css/register.css">
    <link rel="stylesheet" href="css/main.css">

    <script type="text/javascript" src="js/vendor/jquery-1.10.2.min.js"></script>
    <!--<script type="text/javascript" src="js/register.js"></script>-->
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
                <div class="col-md-4 nav-left">
                    <p>高分数据服务系统</p>
                </div>
                <div class="col-md-6 nav-mid">
                    <ul class="nav nav-pills">
                        <li><a href="/dataApply">数据查询</a> </li>
                        <li><a href="/order">订单管理</a> </li>
                    </ul>

                </div>
                <div class="col-md-2 nav-right">
                    <a href="/login"><i class="icon fa fa-user fa-lg"></i> <span>登录</span></a>
                    &nbsp;&nbsp;
                    <a href="/shoppingCart"><i class="icon fa fa-shopping-cart fa-lg"></i> <span>购物车</span></a>
                </div>
            </div>
        </div>
    </div>
</header>
<main role="main" class="main_color">
    <div class="container reg_div">
        <p class="title">用户注册</p>
        <form action="/registerDB" method="post" >
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <ul class="reg_ul">
                        <li>
                            <span>用户名：</span>
                            <input type="text" name="username" value="" class="reg_user">
                            <span class="tip user_hint"></span>
                        </li>
                        <span class="hint">4~8个字符，可使用字母、数字、下划线，需以字母开头</span>

                        <li>
                            <span>密码：</span>
                            <input type="password" name="password" value="" class="reg_password">
                            <span class="tip password_hint"></span>
                        </li>
                        <span class="hint">6~16个字符，可使用字母、数字、下划线，需以字母开头</span>

                        <li>
                            <span>手机号码：</span>
                            <input type="tel" name="telephoneNum" value="" class="reg_mobile">
                            <span class="tip mobile_hint"></span>
                        </li>
                        <span class="hint">请输入11位手机号码</span>

                        <li>
                            <span>单位名称：</span>
                            <input type="text" name="company" value="" class="reg_company_name">
                            <span class="tip company_name_hint"></span>
                        </li>
                        <span class="hint">请输入单位名称</span>

                        <li>
                            <span>单位地址：</span>
                            <input type="text" name="companyAddress" value="" class="reg_company_addr">
                            <span class="tip company_addr_hint"></span>
                        </li>
                        <span class="hint">请输入单位地址</span>

                        <li>
                            <span>所在部门：</span>
                            <input type="text" name="department" value="" class="reg_department">
                            <span class="tip department_hint"></span>
                        </li>
                        <span class="hint">请输入您所在部门</span>

                        <li>
                            <span>职位：</span>
                            <input type="text" name="position" value="" class="reg_position">
                            <span class="tip position_hint"></span>
                        </li>
                        <span class="hint">请输入您的职位</span>


                    </ul>
                </div>

                <div class="col-md-6">
                    <ul class="reg_ul">
                        <li>
                            <span>真实姓名：</span>
                            <input type="text" name="realName" value="" class="reg_name">
                            <span class="tip name_hint"></span>
                        </li>
                        <span class="hint">请如实填写姓名</span>

                        <li>
                            <span>确认密码：</span>
                            <input type="password" name="" value="" class="reg_confirm">
                            <span class="tip confirm_hint"></span>
                        </li>
                        <span class="hint">请再次输入密码</span>

                        <li>
                            <span>电子邮箱：</span>
                            <input type="text" name="email" value="" class="reg_email">
                            <span class="tip email_hint"></span>
                        </li>
                        <span class="hint">请输入您的邮箱</span>

                        <li>
                            <span>单位邮编：</span>
                            <input type="text" name="postCode" value="" class="reg_zip_code">
                            <span class="tip zip_code_hint"></span>
                        </li>
                        <span class="hint">请输入6位单位邮编</span>

                        <li>
                            <span>单位电话：</span>
                            <input type="tel" name="companytelePhone" value="" class="reg_company_phone">
                            <span class="tip company_phone_hint"></span>
                        </li>
                        <span class="hint">请输入单位电话，示例：02588888888</span>

                        <li>
                            <span>单位性质：</span>
                            <!--<form>-->
                            <select id="company_type" name="companyProperty" class="reg_company_type">
                                <option value="default_choice" selected>--请选择单位性质--</option>
                                <option value="国有企业">国有企业</option>
                                <option value="国有控股企业">国有控股企业</option>
                                <option value="外资企业">外资企业</option>
                                <option value="合资企业">合资企业</option>
                                <option value="私营企业">私营企业</option>
                                <option value="事业单位">事业单位</option>
                                <option value="教育机构">教育机构</option>
                                <option value="国家行政机关">国家行政机关</option>
                                <option value="其他">其他</option>
                            </select>
                            <!--</form>-->
                            <!--<input type="text" name="" value="" class="reg_email">-->
                            <span class="tip company_type_hint"></span>
                        </li>
                        <span class="hint">请选择单位性质</span>

                        <li>
                            <span>使用目的：</span>
                            <select id="aim" name="purpose" class="reg_aim">
                                <option value="default_choice" selected>--请选择使用目的--</option>
                                <option value="测绘生产">测绘生产</option>
                                <option value="科学研究">科学研究</option>
                                <option value="行业应用">行业应用</option>
                                <option value="其他">其他</option>
                            </select>
                            <span class="tip aim_hint"></span>
                        </li>
                        <span class="hint">请选择使用目的</span>
                    </ul>

                </div>
            </div>

            <div class="reg-box" id="verifyCheck">
                <div class="contact_box">
                    <br><br>
                    <input type="checkbox" id="cbId"><a href="javascript:showoutc();" class="f-ml5">我已阅读并同意条款</a>
                    <br><br>
                    <div >
                        <button type="submit" class="btn btn-blue" id="btn_contact_box">注册</button>
                    </div>
                </div>

            </div>

            <div class="m-sPopCon regcon">
                <div class="m-sPopTitle">
                    <strong>注册协议</strong><b id="sPopClose" class="m-sPopClose" onClick="closeClause()">×</b>
                </div>
                <div class="m-sPopContent">
                    <pre>
                        <p>
【审慎阅读】您在申请注册流程中点击同意前，应当认真阅读以下协议。请您务必审慎阅读、充分理解协议中相关条款内容，其中包括：
1、与您约定免除或限制责任的条款；
2、与您约定法律适用和管辖的条款；
3、其他以粗体下划线标识的重要条款。
如您对协议有任何疑问，可向平台客服咨询。
【特别提示】当您按照注册页面提示填写信息、阅读并同意协议且完成全部注册程序后，即表示您已充分阅读、理解并接受协议的全部内容。如您因平台服务发生争议的，适用《平台服务协议》处理。如您在使用平台服务过程中与其他用户发生争议的，依您与其他用户达成的协议处理。 阅读协议的过程中，如果您不同意相关协议或其中任何条款约定，您应立即停止注册程序。
                        </p>
                    </pre>
                </div>
            </div>
        </div>
        </form>

    </div>
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
<script type="text/javascript" src="js/login_register.js"></script>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.10.2.min.js"><\/script>')</script>

<!-- Holder.js for project development only -->
<script src="js/vendor/holder.js"></script>

<!-- Essential Plugins and Main JavaScript File -->
<script src="js/plugins.js"></script>
<script src="js/main.js"></script>
</body>
</html>


