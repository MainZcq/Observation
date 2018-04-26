<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>

</head>
<body>
<table  class="table table-bordered" style="border:1px solid #000;">
    <tr>
        <th>用户名</th><th>密码</th><th>手机号码</th><th>单位名称</th><th>单位地址</th><th>部门</th><th>职位</th><th>真实姓名</th>
        <th>邮箱</th><th>单位邮编</th><th>单位电话</th><th>单位性质</th><th>目的</th>
    </tr>
        <#list userList as user>
        <tr>
            <td>${user.username}</td><td>${user.password}</td><td>${user.telephoneNum}</td><td>${user.company}</td><td>${user.companyAddress}</td>
            <td>${user.department}</td><td>${user.position}</td><td>${user.realName}</td><td>${user.email}</td><td>${user.postCode}</td><td>${user.companytelePhone}</td>
            <td>${user.companyProperty}</td><td>${user.purpose}</td>
        </tr>
        </#list>
</table>

<a href="/"><font color="blue">返回</font></a></h1>
<a href="/logout"><font color="blue">注销</font></a></h1>
</body>
</html>