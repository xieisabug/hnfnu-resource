window.addEvent('domready', function () {
    var page = 1;
    var util = new Util();
    //var choosePanel = new Panel($('choose-panel'));
    var showPanel = new Panel($('show-panel'));
    var searchSelect = new Select('searchSelect', [
        {
            name: '站内资源',
            value: '站内资源'
        },
        {
            name: '百度网盘',
            value: '百度网盘'
        }
    ], {
        height: 34
    }).animate().addButtonClass('btn-group-left');
    if (Browser.ie) {
        searchSelect.setSelectDivOffset(13, -46);
    } else {
        searchSelect.setSelectDivOffset(13, -19);
    }
    var keyWords = new Input($$('#headSearch input')).addClass('input-group-center');

    var searchButton = new Button($$('button')[1]).addClass('btn-group-right');
    $$('#headMenu a').each(function (item, index) {
        var option = {
            width: 120
        };
        if (index == 0) {
            new Button(item, option).addClass('btn-group-left').addClass('btn-blue-border');
        } else if (index == 3) {
            new Button(item).addClass('btn-group-right').addClass('btn-blue-border');
        } else {
            new Button(item, option).addClass('btn-group-center').addClass('btn-blue-border');
        }

    });
    new Fx.Accordion($('choose-accordion'),'.choose-type','.choose-list');
//    new Mouseover($('choose-accordion'), Function.from(function(){alert('鼠标悬停3秒后触发')}), 3000);
    /*
    var page = 1;
    $('more').addEvent('click',function(){
        new Request.JSON({
            url:'',
            onSuccess:function(data) {
            }
        }).get(util.getUrlArg().push({page:page}));
    });
    function load(page){
        console.log(page);
        $('more').destroy();
        var html = '';
        for(var i = 0; i<page; i++) {
            html += '<div class="topic-resource-content">';
            html += '    <table>';
            html += '        <tr>';
            html += '            <td style="width: 140px; text-align: center" rowspan="3">';
            html += '                <img src="image/topic_01.jpg" style="width:77px; height:77px; display: inline;">';
            html += '            </td>';
            html += '            <td style="width: 340px;"><span>资源名</span>：大头儿子小头爸爸 第一季 第二集 第三段</td>';
            html += '            <td style="width: 200px;"><span>资源币</span>：免费</td>';
            html += '            <td style="width: 130px; text-align: center" rowspan="3">';
            html += '                <div class="topic-resource-btn">';
            html += '                    <button value="在线预览" onclick="">在线预览</button>';
            html += '                    <button value="下载资源" onclick="">下载资源</button>';
            html += '                </div>';
            html += '            </td>';
            html += '        </tr>';
            html += '        <tr>';
            html += '            <td><span>媒体类型</span>：动画</td>';
            html += '            <td><span>文件大小</span>：210M</td>';
            html += '        </tr>';
            html += '        <tr>';
            html += '            <td><span>出版社</span>：中国人民美术公司</td>';
            html += '            <td>&nbsp;</td>';
            html += '        </tr>';
            html += '    </table>';
            html += '</div>';
        }
        if(page > 8) {
            html += '<div id="more"></div>';
        }
        showPanel.updateWithAnimate('append',html,function(){
            $('more').addEvent(load(page-1));
        });
        page--;
    };
    */
});