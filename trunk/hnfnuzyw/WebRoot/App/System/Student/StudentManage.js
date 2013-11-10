var studentGrid = null;// 学生表格
var studentForm = null;// 学生表单
var balanceForm = null;// 批量增加资源币表单
var fileForm = null;//批量学生注册表单
var fileWin = null;//批量学生注册的窗口
var balanceWin = null;//批量增加资源币的窗口
var studentWin = null;// 学生窗口

//批量注册学生的函数
function add_many_student() {
    fileWin = $.ligerDialog.open({
        width:400,
        height:300,
        title:'批量注册学生',
        url:'AddForm.html',
        buttons:[
            {
                text:'提交',
                width:80,
                onclick:add_many_save
            },
            {
                text:'取消',
                width:80,
                onclick:add_many_cancel
            }
        ]
    });
}
// 批量注册学生的保存按钮事件
function add_many_save() {
	
	fileForm = fileWin.frame.fileForm;
	
    if (fileForm.valid()) {
        var row_data = Form.parseJSON(fileForm);

        if(row_data.url == "" || row_data.url == null) {
        	$.ligerDialog.error("未上传文件");
        	return;
        }
        
        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url:'../../../system/addManyStudent.action',
            data:{
        	url:row_data.url
        	},
            type:'post',
            success:function (data) {
                if (data.success) {
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    refresh_student();
                    fileWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 批量注册学生的取消按钮事件
function add_many_cancel() {
    fileWin.close();
}


// 增加学生的函数
function add_student() {
    formInit("add");
    studentWin = $.ligerDialog.open({
        width:400,
        height:500,
        title:'新增学生',
        target:studentForm,
        buttons:[
            {
                text:'提交',
                width:80,
                onclick:add_save
            },
            {
                text:'取消',
                width:80,
                onclick:add_cancel
            }
        ]
    });
}
// 增加学生的保存按钮事件
function add_save() {
    if (studentForm.valid()) {
        var row_data = Form.parseJSON(studentForm);

        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url:'../../../system/addStudent.action',
            data:row_data,
            type:'post',
            success:function (data) {
                if (data.success) {
                    studentGrid.addRow(data.model);
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    studentWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 增加学生的取消按钮事件
function add_cancel() {
    studentWin.close();
}

//批量给学生充值资源币
function add_balance() {
	var datas = studentGrid.getSelecteds();
	  //console.log(datas);
    if (datas.length == 0) {
        $.ligerDialog.warn('请选择您要充值的学生们.');
        return;
    }
    balanceFormInit();
    balanceWin = $.ligerDialog.open({
        width:300,
        height:200,
        title:'充值资源币',
        target:balanceForm,
        buttons:[
            {
                text:'提交',
                width:80,
                onclick:add_balance_save
            },
            {
                text:'取消',
                width:80,
                onclick:add_balance_cancel
            }
        ]
    });
}
//批量充值资源币的保存按钮事件
function add_balance_save() {
    if (balanceForm.valid()) {
    	var studentDatas = studentGrid.getSelecteds();
    	var studentIds = "";
    	for(var i = 0; i < studentDatas.length;i++){
    		if( i > 0){
        		studentIds = studentIds + ";";	
    		}
    		studentIds = studentIds + studentDatas[i].id;
    	}
    	//console.log(studentIds);
        var row_data = Form.parseJSON(balanceForm);
        // 发往服务器，返回成功后再添加到表格中
       $.ajax({
            url:'../../../system/addStudentBalanceCount.action',
            data:{
    	   		studentIds:studentIds,
    	   		balanceCount:row_data.addCount
       		},
            type:'post',
            success:function (data) {
                if (data.success) {
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    refresh_student();
                    balanceWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 批量充值资源币的取消按钮事件
function add_balance_cancel() {
    balanceWin.close();
}

// 刷新学生的函数
function refresh_student() {
    $.ajax( {
        url : '../../../system/listStudent.action',
        type : 'post',
        success : function(data) {
            studentGrid.loadData(data.studentList);
        }
    });
    $("#pageloading").hide();

}

// 修改学生的函数
function edit_student() {
    formInit("edit");
    if (!studentGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要修改的行.');
        return;
    }
    
    $.ligerDialog.confirm('该功能不支持批量修改，如果您选择了多个文件，只会修改第一个文件', function (r) {
        if (r) {
        	Form.loadForm(studentForm, studentGrid.getSelected());
            studentWin = $.ligerDialog.open({
                width:400,
                height:400,
                title:'编辑学生',
                target:studentForm,
                buttons:[
                    {
                        text:'提交',
                        width:80,
                        onclick:edit_save
                    },
                    {
                        text:'取消',
                        width:80,
                        onclick:edit_cancel
                    }
                ]
            });
        }
    });
    
    
    
    
    
    
    
}
// 修改学生的保存按钮事件
function edit_save() {
    if (studentForm.valid()) {
        var row_data = Form.parseJSON(studentForm);
        // todo 需要发往服务器，返回成功后再修改到表格中
        $.ajax({
            url:'../../../system/updateStudent.action',
            data:row_data,
            type:'post',
            success:function (data) {
                if (data.success) {
                    studentGrid.update(studentGrid.getSelected(),
                        data.model);
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    studentWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 修改学生的取消按钮事件
function edit_cancel() {
    studentWin.close();
}

// 删除学生的函数
function delete_student() {
    if (!studentGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要删除的行.');
        return;
    }
    var row_data = studentGrid.getSelected();
    $.ligerDialog.confirm('该功能不支持批量删除，如果您选择了多个文件，只会删除第一个。确认删除' + row_data.name + '？', '删除学生', function (r) {
        if (r) {
            $.ajax({
                url:'../../../system/deleteStudent.action',
                data:{
                    id:row_data.id
                },
                type:'post',
                success:function (data) {
                    if (data.success) {
                        $.ligerDialog.tip({
                            title:'提示信息',
                            content:data.message
                        });
                        //studentGrid.deleteSelectedRow();
                        refresh_student();
                        
                        parameterWin.close();
                    } else {
                        $.ligerDialog.error(data.message);
                    }
                }
            });
        }
    });
}
// 初始化表单，生成form标签
function formInit(func) {
    var groupicon = "../../../App/Lib/ligerUI/skins/icons/communication.gif";
    studentForm = $('<form></form>');
    var fields = [];
    fields.push({
        name:'id',
        type:'hidden'
    },
       {
            name:'balance',
            type:'hidden'
       },
       {
           name:'password',
           type:'hidden'
      },{
        name:'username',
        display:'用户名',
        type:'text',
        space:30,
        labelWidth:100,
        newline:true,
        group:'必填信息',
        groupicon:groupicon,
        width:200,
        validate:{
            required:true,
            maxlength:20
        }
    });

    if (func === "add") {
        fields.push({
            name:'password',
            display:'密码',
            type:'password',
            space:30,
            labelWidth:100,
            newline:true,
            width:200,
            validate:{
                required:true,
                maxlength:20
            }
        }, {
            name:'confirmPassword',
            display:'密码确认',
            type:'password',
            space:30,
            labelWidth:100,
            newline:true,
            width:200,
            validate:{
                required:true,
                maxlength:20
                //equalTo:"#password"
            }
        });
    } else if (func === "edit") {
    }
    fields.push({
        name:'name',
        display:'姓名',
        type:'text',
        space:30,
        labelWidth:100,
        newline:true,
        width:200,
        validate:{
            required:true,
            maxlength:10
        }
    }, {
        name:'number',
        display:'学号',
        type:'text',
        space:30,
        labelWidth:100,
        newline:true,
        width:200,
        validate:{
            required:true,
            maxlength:20
        }
    }, {
            name:'major',
            display:'专业',
            type:'text',
            space:30,
            labelWidth:100,
            newline:true,
            width:200,
            validate:{
                required:true,
                maxlength:50
            }
        },
        {
        name:'department',
        display:'系部',
        type:'text',
        space:30,
        labelWidth:100,
        newline:true,
        width:200,
        validate:{
            required:true,
            maxlength:50
        }
    }, {
        display:"入学年份",
        name:"entranceTime",
        type:"select",
        width:200,
        space:30,
        labelWidth:100,
        comboboxName:"entranceTime",
        textField:"text",
        valueField:"id",
        newline:true,
        options:{
            hideOnLoseFocus:true,
            valueFieldID:"id",
            data:[
                {
                	"id":"2010",
                    "text":"2010"
                },
                {
                	"id":"2011",
                    "text":"2011"
                },
                {
                	"id":"2012",
                    "text":"2012"
                },
                {
                	"id":"2013",
                    "text":"2013"
                },
                {
                	"id":"2014",
                    "text":"2014"
                },
                {
                	"id":"2015",
                    "text":"2015"
                },
                {
                	"id":"2016",
                    "text":"2016"
                },
                {
                	"id":"2017",
                    "text":"2017"
                },
                {
                	"id":"2018",
                    "text":"2018"
                },
                {
                	"id":"2019",
                    "text":"2019"
                },
                {
                	"id":"2020",
                    "text":"2020"
                },
                {
                	"id":"2021",
                    "text":"2021"
                },
                {
                	"id":"2022",
                    "text":"2022"
                },
                {
                	"id":"2023",
                    "text":"2023"
                },
                {
                	"id":"2024",
                    "text":"2024"
                },
                {
                	"id":"2025",
                    "text":"2025"
                },
                {
                	"id":"2026",
                    "text":"2026"
                },
                {
                	"id":"2027",
                    "text":"2027"
                },
                {
                	"id":"2028",
                    "text":"2028"
                }
            ]

        }
    }, {
            name:'telephone',
            display:'手机号码',
            type:'text',
            space:30,
            labelWidth:100,
            newline:true,
            width:200,
            validate:{
                required:false,
                maxlength:15
            }
        },
        {
        name:'remark',
        display:'备注',
        type:'text',
        space:30,
        labelWidth:100,
        newline:true,
        width:200
    });

    studentForm.ligerForm({
        inputWidth:280,
        fields:fields
    });
    $.metadata.setType("attr", "validate");
    studentForm.validate({
        debug:true,
        onkeyup:false,
        errorPlacement:function (error,element) {
            error.appendTo(element.parent().parent().parent().parent());
        }
    });
}


//初始化批量充值资源币的表单，生成form标签
function balanceFormInit() {
    balanceForm = $('<form></form>');
    balanceForm.ligerForm({
		inputWidth :80 ,
		fields : [ 
		{
			display : '充值资源币数量',
			name : 'addCount',
			type : 'text',
			space : 50,
			labelWidth : 100,
			width : 100,
			height: 50,
			newline : true,
			validate : {
				required : true,
				maxlength : 9
			}
		} ]
	});
	$.metadata.setType("attr", "validate");
	balanceForm.validate({
		debug : true,
		onkeyup : false,
		errorPlacement : function(error,element) {
            error.appendTo(element.parent().parent().parent().parent());
		}
	});
}
// 初始化表格
$(function () {
    var toolbarItems = [
        {
            text:'新增学生',
            click:add_student,
            icon:'add',
            key:'add'
        },
        {
            text:'修改学生',
            click:edit_student,
            icon:'modify',
            key:'modify'
        },
        {
            text:'删除学生',
            click:delete_student,
            icon:'delete',
            key:'delete'
        }, {
            text:'资源币充值',
            click:add_balance,
            icon:'modify',
            key:'modify_many'
        }, {
            text:'通过Excel批量注册',
            click:add_many_student,
            icon:'add',
            key:'add_many'
        }
    ];
    var menuId = window.parent.tab.getSelectedTabItemID();
    $.ajax({
        url:'../../../system/listFunctionIdList.action',
        type:'post',
        data:{
            menuId:menuId.substr(0, menuId.indexOf("t"))
        },
        success:function (data) {
            var idList = data.functionIdList.split(";");
            var ajaxToolbar = [];
            for (var i = 0; i < idList.length; i++) {
                ajaxToolbar.push({name:parent.hnfnu.functionList[idList[i]]});
            }
            toolbarItems = Toolbar.confirmToolbar(toolbarItems, ajaxToolbar);
        }
    });

    $.ajax({
        url:'../../../system/listStudent.action',
        type:'post',
        success:function (data) {
            studentGrid = $('#studentGrid').ligerGrid({
                columns:[
                    // { display:'ID', name:'id', align:'left', width:100 },
                    {
                        display:'账号',
                        name:'username',
                        width:180
                    },{
                        display:'学生名字',
                        name:'name',
                        width:100
                    },
                    {
                        display:'学号',
                        name:'number',
                        align:'left',
                        width:100
                    },
                    {
                        display:'专业',
                        name:'major',
                        align:'left',
                        width:120
                    },
                    {
                        display:'系部',
                        name:'department',
                        align:'left',
                        width:100
                    },
                    {
                        display:'入学年份',
                        name:'entranceTime',
                        align:'left',
                        width:80
                    },
                    {
                        display:'资源币余额',
                        name:'balance',
                        align:'left',
                        width:80
                    },
                    {
                        display:'电话号码',
                        name:'telephone',
                        align:'left',
                        width:100
                    },
                    {
                        display:'备注',
                        name:'remark',
                        align:'left',
                        width:50
                    }
                ],
                width:'99%',
                height:'98%',
                usePager:false,
                data:data.studentList,
                checkbox:true,
                toolbar:{
                    items:toolbarItems
                }
            });
            $("#pageloading").hide();
        }
    });
});