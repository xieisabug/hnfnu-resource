$(function () {
    function supports_canvas() {
        return !!document.createElement('canvas').getContext;
    }
    $.getJSON('website/welcomeInfo.action', function (data) {
        if(data.success) {
            var infoDiv = $('#info');
            var infoHtml = '';
            var info = data.info;
            infoHtml += '<p>尊敬的用户<span>'+info.username +'</span> 您好，您上次登录是 ： <span>'+ info.latestLoginDate +'</span></p>';
            if(info.habit.length != 0) {
                var habit = info.habit;
                var habitLen = habit.length;
                infoHtml += '<div id="habit">';
                for(var hi = 0; hi < habitLen; hi++) {
                    infoHtml += '<a menuName='+habit[hi].name+' url='+habit[hi].url+' menuNo='+habit[hi].menuId+'>'+habit[hi].name+'</a>';
                }
                infoHtml += '</div>';
            }
            infoDiv.append(infoHtml);
            $("a",infoDiv).live("click", function(){
                var jitem = $(this);
                var menuName = jitem.attr("menuName");
                var url = jitem.attr("url");
                var menuNo = jitem.attr("menuNo");
                f_addTab(menuNo+'tabid', menuName, url);
            });
        } else {
            $.ligerDialog.error(data.message);
        }
    });
    $.getJSON('website/welcomeChart.action', function (data) {
        if (data.success) {
            var wrapDiv = $('#chart');
            var widthChart = wrapDiv.width()/2-50;
            var heightChart = widthChart/4*3;
            var datas = data.data;

            if(!supports_canvas()) {
                var info = '';
                info = '<table style="width:90%; height: 30px; margin-bottom: 10px;"><tr><td>请使用更高级的浏览器，以获得更好的用户体验。推荐：Chrome 。</td></tr></table>'
                wrapDiv.append(info);
            }

            if(datas.length == 1) {
                widthChart = wrapDiv.width()-50;
            }
            var len = datas.length,di = 0;
            //2D饼图，2D条形图，2D折线图
            for (di = 0; di < len; di++) {
                //取出要绘制的数据
                var d = datas[di];
                //生成一个绘制画布，并装入大容器中
                var render = $('<div id="render' + di + '"></div>');
                wrapDiv.append(render);
                var htmlTable;//用于浏览器不支持canvas的时候显示table用
                //如果是折线图
                if (d.type == "LineBasic2D") {
                    /**
                     * 折线图中必须要有的属性：
                     * data:显示在折线图中用于生成折线的数据
                     * title:折线图的标题
                     * labels:折线图的x轴显示的文字
                     * 折线图中可选的属性（有默认值）：
                     * start_scale:坐标系的开始值
                     * end_scale:坐标系的结束值
                     * scale_space:坐标系的相隔值
                     * tip:提示标签，鼠标移上去时会显示
                     * crosshair:坐标的十字线，鼠标移上去时会显示
                     */
                    if(supports_canvas()) {
                        //可选tip属性
                        var tip = d.tip || {
                            enable:true,
                            shadow:true
                        };
                        //可选crosshair属性
                        var crosshair = d.crosshair || {
                            enable:true,
                            line_color:'#62bce9'
                        };
                        //可选sub_option属性
                        var sub_option = d.sub_option || {
                            label:false,
                            hollow_inside:true,
                            point_size:8
                        };
                        new iChart.LineBasic2D({
                            render:'render' + di,
                            data:d.data,
                            title:d.title,
                            align:'center',
                            background_color:d.background_color || '#fff',
                            width:widthChart,
                            height:heightChart,
                            coordinate:{
    //                            width:350,
    //                            height:200,
                                grid_color:'#cccccc',
                                axis:{
                                    color:'#cccccc',
                                    width:[0, 0, 2, 2]
                                },
                                grids:{
                                    vertical:{
                                        way:'share_alike',
                                        value:5
                                    }
                                },
                                scale:[
                                    {
                                        position:'left',
                                        start_scale:d.start_scale || 0,
                                        end_scale:d.end_scale || 10,
                                        scale_space:d.scale_space || 1,
                                        scale_size:2,
                                        label:{color:'#000', fontsize:11},
                                        scale_color:'#9f9f9f'
                                    },
                                    {
                                        position:'bottom',
                                        label:{color:'#000', fontsize:11},
                                        labels:d.labels
                                    }
                                ]
                            },
                            tip:tip,
                            crosshair:crosshair,
                            sub_option:sub_option
                        }).draw();//绘制折线图
                    } else {
                        htmlTable = '';
                        htmlTable += '<table style="width: '+widthChart+'px; height: '+heightChart+'px;">';
                        htmlTable += '  <tr>';
                        htmlTable += '    <td colspan="2">'+ d.title+'</td>';
                        htmlTable += '  </tr>';
                        for(var i = 0; i < d.data[0].value.length; i++) {
                            htmlTable += '  <tr>';
                            htmlTable += '    <td>' + d.labels[i] + '</td>';
                            htmlTable += '    <td>' + d.data[0].value[i] + '</td>';
                            htmlTable += '  </tr>';
                        }
                        htmlTable += '</table>';
                        render.append(htmlTable);
                    }
                    //如果是饼图
                } else if (d.type == 'Pie2D') {
                    /**
                     * 饼图中必须要有的属性：
                     * data:显示在饼图中用于饼块的数据和文字
                     * title:饼图的标题
                     * 饼图中可选的属性（有默认值）：
                     * offsetx:饼图x轴偏移量
                     * sub_option:饼块的设置
                     * radius:饼图的半径
                     * background_color:背景颜色
                     */

                     if(supports_canvas()) {
                         //可选offsetx属性
                         var offsetx = d.offsetx || 0;
                         //可选sub_option属性
                         var sub_option = d.sub_option || {
                             label:{
                                 background_color:null,
                                 sign:false, //设置禁用label的小图标
                                 padding:'0 4',
                                 border:{
                                     enable:false,
                                     color:'#666666'
                                 },
                                 fontsize:11,
                                 fontweight:600,
                                 color:'#4572a7'
                             },
                             border:{
                                 width:2,
                                 color:'#ffffff'
                             }
                         };
                         //可选radius属性
                         var radius = d.radius || 120;
                         //可选background_color属性
                         var background_color = d.background_color || '#fefefe';
                         new iChart.Pie2D({
                             render:'render' + di,
                             data:d.data,
                             title:d.title,
                             width:widthChart,
                             height:heightChart,
                             sub_option:sub_option,
                             shadow:true,
                             shadow_blur:6,
                             shadow_color:'#aaaaaa',
                             shadow_offsetx:0,
                             shadow_offsety:0,
                             background_color:background_color,
                             offsetx:offsetx,
                             offset_angle:-120,
                             showpercent:true,
                             tip:{
                                 enable:true
                             },
                             decimalsnum:2,
                             radius:radius
                         }).draw();//绘制饼图
                     } else {
                         htmlTable = '';
                         htmlTable += '<table border="1" style="width: '+widthChart+'px; height: '+heightChart+'px;">';
                         htmlTable += '  <tr>';
                         htmlTable += '    <td colspan="2">'+ d.title+'</td>';
                         htmlTable += '  </tr>';
                         for(var i = 0; i < d.data.length; i++) {
                             htmlTable += '  <tr>';
                             htmlTable += '    <td>' + d.data[i].name + '</td>';
                             htmlTable += '    <td>' + d.data[i].value + '</td>';
                             htmlTable += '  </tr>';
                         }
                         htmlTable += '</table>';
                         render.append(htmlTable);
                     }

                    //如果是柱形图
                } else if (d.type == 'Column2D') {

                    /**
                     * 柱形图中必须要有的属性：
                     * data:显示在柱形图中的条形数据
                     * title:柱形图的标题
                     * start_scale:坐标轴开始的最小数字,
                     * end_scale:坐标轴结束的最大数字,
                     * scale_space:坐标轴的单位间隔,
                     */
                    if(supports_canvas()) {
                        if(d.tip) {
                            var tip = {
                                enable:true,
                                listeners:{
                                    //tip:提示框对象、name:数据名称、value:数据值、text:当前文本、i:数据点的索引
                                    parseText:function(tip,name,value,text,i){
                                        return d.tip[i];
                                    }
                                }
                            };
                        } else {
                            var tip = {
                                enable:false
                            }
                        }

                        new iChart.Column2D({
                            render:'render' + di,
                            data:d.data,
                            title:d.title,
                            width:widthChart,
                            height:heightChart,
                            shadow:true,
                            shadow_color:'#c7c7c7',
                            tip:tip,
                            coordinate:{
                                scale:[
                                    {
                                        position:'left',
                                        start_scale:d.start_scale,
                                        end_scale:d.end_scale,
                                        scale_space:d.scale_space,
                                        listeners:{
                                            parseText:function (t) {
                                                return {text:t + d.textUnit}
                                            }
                                        }
                                    }
                                ]
                            }
                        }).draw();
                    } else {
                        htmlTable = '';
                        htmlTable += '<table border="1" style="width: '+widthChart+'px; height: '+heightChart+'px;">';
                        htmlTable += '  <tr>';
                        htmlTable += '    <td colspan="2">'+ d.title+'</td>';
                        htmlTable += '  </tr>';
                        for(var i = 0; i < d.data.length; i++) {
                            htmlTable += '  <tr>';
                            if(d.tip){
                                htmlTable += '    <td>' + d.tip[i] + '</td>';
                            } else {
                                htmlTable += '    <td>' + d.data[i].name + '</td>';
                            }
                            htmlTable += '    <td>' + d.data[i].value + '</td>';
                            htmlTable += '  </tr>';
                        }
                        htmlTable += '</table>';
                        render.html(htmlTable);
                    }
                }

                if(di%2 == 0) {
                    wrapDiv.append('<div style="width:50px;height: 1px; "></div>');
                } else {
                    wrapDiv.append('<div style="width: 100%;height: 20px;"></div>')
                }
            }
            if(!supports_canvas()) {
                //console.log( $(".l-tab-content").height());
                $("#welcome").css('height', $(".l-tab-content").height() );
                window.tab.addHeight(0);
            }
        } else {
            $.ligerDialog.error(data.message);
        }
    });

});
