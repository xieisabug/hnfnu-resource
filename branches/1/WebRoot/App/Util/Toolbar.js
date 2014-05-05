Toolbar = {};
Toolbar.confirmToolbar = function (toolbar, roleToolbar) {
    var t = toolbar.length;
    var r = roleToolbar.length;
    var ret = [];
    for (var j = 0; j < t; j++) {
        for (var i = 0; i < r; i++) {
            if (roleToolbar[i]['name'] == toolbar[j]['key']) {
                ret.push(toolbar[j]);
                break;
            }
        }
    }
    return ret;
}