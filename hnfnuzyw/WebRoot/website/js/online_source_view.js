window.addEvent('domready', function () {
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
    var onlinePanel = new Panel($('online-view-panel'), {
        contentWidth: 622,
        contentHeight: 540
    });
    var commentPanel = new Panel($('comment-panel'), {
        contentWidth:622
    });
    var sourceInfoPanel = new Panel($('source-info-panel'), {
        contentWidth:272
    });
    var downloadBtn = new Button($('downloadBtn'));
    var commentContent = new TextArea($('replyTextarea'), {
        width:600,
        height:80
    });
    var replyBtn = new Button($('replyBtn'),{
        width:150,
        height:30,
        onclick:function(){
            if(commentContent.getValue() == '') {
                alert("请输入评论内容");
                return ;
            }
            new Request.JSON({
                url:"../../resources/addSourceComment",
                onSuccess:function(data){
                    if(data.success) {
                        var html = '';
                        html +='<table>';
                        html +='    <tr>';
                        html +='        <td rowspan="2">';
                        html +='            <img src="'+basePath+'uploads/user/image/'+data.icon+'">';
                        html +='            <p>' + data.name+ '</p>';
                        html +='        </td>';
                        html +='        <td>'+data.model.createDate.replace('T',' ');
                        html +='            <a href="javascript:reply('+data.model.id+')">回复</a></td>';
                        html +='    </tr>';
                        html +='    <tr>';
                        html +='        <td>'+data.model.content+'</td>';
                        html +='    </tr>';
                        html +='</table>';
                        if(data.parentId != 0) {
                            var brothers = $$('a[href=javascript:reply('+data.model.parentId+')]');
                            var lastBrothers = brothers[brothers.length-1];
                            lastBrothers.getParent('div').grab(new Element('div.comment-sub-item',{
                                html:html
                            }),'after');
                        } else {
                            $('comment-content').grab(new Element('div.comment-item',{
                                html:html
                            }),'bottom');
                        }
                        commentContent.textarea.set('value','');
                    }
                }
            }).post({
                    content:commentContent.getValue(),
                    sourceId:$('sourceId').get('value'),
                    parentId:$('parentId').get('value')
                });
        }
    })
});
function reply(parentId) {
    $('parentId').set('value',parentId);
    location.hash = "commentA";
}