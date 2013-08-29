Form = {};
Form.parseJSON = function(f){
    var form = f.formToArray();
    var len = form.length;
    var data;
    data = '{';
    for(var i = 0;i < len; i++){
        //if(form[i].type == "hidden" && form[i].name != "id"){alert(form[i].name);continue;}
        data += '"' + form[i].name + '"' + ':"' + form[i].value + '"';
        if (i != len - 1) {
            data += ',';
        }
    }
    data += '}';
    return $.parseJSON(data);
};
Form.loadForm = function(form,data){
    for(var name in data){
        var ele = $("[name=" + name + "]",form);
        if(ele.is(":checkbox,:radio")) {
            ele[0].checked = data[name] ? true : false;
        } else {
            ele.val(data[name]);
        }
    }
    //下面是更新表单的样式
    var managers = $.ligerui.find($.ligerui.controls.Input);
    for (var i = 0, l = managers.length; i < l; i++)
    {
        //改变了表单的值，需要调用这个方法来更新ligerui样式
        var o = managers[i];
        o.updateStyle();
        if (managers[i] instanceof $.ligerui.controls.TextBox)
            o.checkValue();
    }
};