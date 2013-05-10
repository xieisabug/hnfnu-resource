var userGrid = null;//用户表格
var userForm = null;//用户表单
var userWin = null;//用户窗口


//初始化表格
$(function(){
    userGrid = $('#menuGrid').ligerGrid(
        {
            columns:[
                {display:'ID',name:'id',align:'left',width:100},
                {display:'用户名',name:'username',align:'left',width:200},
                {display:'姓名',name:'name',align:'left',width:200},
                {display:'身份证号码',name:'idcard',align:'left',width:200},
                {display:'性别',name:'sex',align:'left',width:200},
                {display:'QQ',name:'sex',align:'left',width:200}
            ]

        }
    );

    }
);
