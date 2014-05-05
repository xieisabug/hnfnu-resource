Url = {};
Url.getArgs = getArgs;
// 提取URL中的参数
function getArgs() {
    // 加上substring的意义是去掉查询字符串中的？号。
    // var query = window.location.search.substring(1);
    // 定义一个数组，用于存放取出来的字符串参数。
    var argsArr = {};
    // 获取URL中的查询字符串参数
    var query = window.location.search;
    query = query.substring(1);
    // 这里的pairs是一个字符串数组
    // name=myname&password=1234&sex=male&address=nanjing
    var pairs = query.split("&");
    for ( var i = 0; i < pairs.length; i++) {
        var sign = pairs[i].indexOf("=");
        // 如果没有找到=号，那么就跳过，跳到下一个字符串（下一个循环）。
        if (sign == -1) {
            continue;
        }
        var aKey = pairs[i].substring(0, sign);
        var aValue = pairs[i].substring(sign + 1);
        argsArr[aKey] = aValue;
    }
    return argsArr;
}