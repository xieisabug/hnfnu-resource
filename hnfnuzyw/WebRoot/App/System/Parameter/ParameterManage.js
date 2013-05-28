var parameterGrid = null;//功能表格
var parameterForm = null;//功能表单
var parameterWin = null;//功能窗口
var id = 5000;

//增加功能的函数
function add_parameter() {
    formInit();
    parameterWin = $.ligerDialog.open({
        width:400,
        height:200,
        title:'新增功能',
        target:parameterForm,
        buttons:[
            {text:'提交', width:80, onclick:add_save},
            {text:'取消', width:80, onclick:add_cancel}
        ]
    });
}
//增加功能的保存按钮事件
function add_save() {
//    console.log(parameterForm.rules());
//	parameterForm.validate({
//		errorPlacement:function(error, element){
//			console.log(error);
//			console.log(element);
//		}
//	});
    if(parameterForm.valid()){
        var row_data = Form.parseJSON(parameterForm);
        $.ajax({
            url:'/hnfnuzyw/system/addParameter.action',
            data:row_data,
            type:'post',
            success:function(data){
                if(data.success){
                    parameterGrid.addRow(data.model);
                    $.ligerDialog.tip({title: '提示信息',content:data.message});
                    parameterWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
//增加功能的取消按钮事件
function add_cancel() {
    parameterWin.close();
}
//修改功能的函数
function edit_parameter() {
    formInit();
    if (!parameterGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要修改的行.');
        return;
    }
    Form.loadForm(parameterForm, parameterGrid.getSelected());
    parameterWin = $.ligerDialog.open({
        width:400,
        height:200,
        title:'编辑功能',
        target:parameterForm,
        //isHidden:false,
        buttons:[
            {text:'提交', width:80, onclick:edit_save},
            {text:'取消', width:80, onclick:edit_cancel}
        ]
    });
}
//修改功能的保存按钮事件
function edit_save() {
    var row_data = Form.parseJSON(parameterForm);
    $.ajax({
        url:'/hnfnuzyw/system/updateParameter.action',
        data:row_data,
        type:'post',
        success:function(data){
            if(data.success){
            	parameterGrid.update(parameterGrid.getSelected(), data.model);
	            $.ligerDialog.tip({title: '提示信息',content:data.message});
	            parameterWin.close();
            } else {
            	$.ligerDialog.error(data.message);
            }
        }
    });
}
//修改功能的取消按钮事件
function edit_cancel() {
    parameterWin.close();
}
//删除功能的函数
function delete_parameter() {
    if (!parameterGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要删除的行.');
        return;
    }
    var row_data = parameterGrid.getSelected();
    $.ligerDialog.confirm('确认删除' + row_data.name + '？', '删除功能', function (r) {
        if (r) {
        	$.ajax({
                url:'/hnfnuzyw/system/deleteParameter.action',
                data:row_data,
                type:'post',
                success:function(data){
                    if(data.success){
        	            $.ligerDialog.tip({title: '提示信息',content:data.message});
        	            parameterGrid.deleteSelectedRow();
        	            parameterWin.close();
                    } else {
                    	$.ligerDialog.error(data.message);
                    }
                }
            });
        }
    });
}
//初始化表单，生成form标签
function formInit() {
    parameterForm = $('<form id="Form'+id+'"></form>');
    parameterForm.ligerForm({
        options:{
            id:id
        },
        inputWidth:280,
        fields:[
            {
                name:'id',
                type:'hidden'
            },
            {
                display:'参数名称',
                name:'name',
                type:'text',
                space:30,
                labelWidth:100,
                width:220,
                newline:true,
                validate:{
                    maxlength:100
                }
            },
            {
                display:'参数值',
                name:'value',
                type:'text',
                space:30,
                labelWidth:100,
                width:220,
                newline:true,
                validate:{
                    maxlength:20
                }
            },
            {
                display:'参数类型',
                name:'type',
                type:'select',
                comboboxName:'typeList',
                space:30,
                labelWidth:100,
                width:220,
                newline:true,
                options:{
                    valueFieldID:"type",
                    valueField:"value",
                    data:[
                        {"id":0,"text":"array","value":"array"},
                        {"id":1,"text":"number","value":"number"},
                        {"id":2,"text":"string","value":"string"}
                    ]
                },
                validate:{
                    maxlength:20
                }
            },
            {
                display:'备注',
                name:'remark',
                type:'text',
                space:30,
                labelWidth:100,
                width:220,
                newline:true
            }
        ]
    });
    id++;
    $.metadata.setType("attr", "validate");
    parameterForm.validate({
        debug: true,
        onkeyup:false,
        errorPlacement:function(error){
            $.ligerDialog.error(error[0].innerHTML);
        }
    });
}
//初始化表格
$(function () {
    var toolbarItems = [
        {text:'新增参数', click:add_parameter, icon:'add', key:'add'},
        {text:'修改参数', click:edit_parameter, icon:'modify', key:'modify'},
        {text:'删除参数', click:delete_parameter, icon:'delete', key:'delete'}
    ];
    //todo 以后这个ajaxToolbar要通过ajax取过来
    var ajaxToolbar = [
        {name:'add'},
        {name:'modify'},
        {name:'delete'}
    ];
    toolbarItems = Toolbar.confirmToolbar(toolbarItems,ajaxToolbar);
    $.ajax({
        url:'/hnfnuzyw/system/listParameter.action',
        type:'post',
        success:function(data){
            parameterGrid = $('#parameterGrid').ligerGrid({
                columns:[
                    //{ display:'ID', name:'id', align:'left', width:100 },
                    { display:'参数名称', name:'name', width:200 },
                    { display:'参数值', name:'value', width:200 },
                    { display:'参数类型', name:'type', width:200 },
                    { display:'备注', name:'remark', align:'left', width:400 }
                ],
                width:'99%',
                height:'98%',
                pageSize:30,
                data:data.parameterList,
                toolbar:{
                    items:toolbarItems
                }
            });
            $("#pageloading").hide();
        }
    });
});