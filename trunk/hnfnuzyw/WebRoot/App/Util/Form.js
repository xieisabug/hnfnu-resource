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
}