$(function () {

    var ddddd = [
        {
            type:'LineBasic2D',
            title:'北京2012年平均温度情况',
            labels:["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            data:[
                {
                    name:'北京',
                    value:[-9, 1, 12, 20, -50, 5, 32, 29, 22, 12, 0, -6],
                    color:'#1f7e92',
                    line_width:2
                }
            ]
        },
        {
            type:'Pie2D',
            title:{
                text:'2012年第3季度中国第三方手机浏览器市场份额',
                color:'#3e576f'
            },
            data:[
                {name:'UC浏览器', value:40.0, color:'#4572a7'},
                {name:'QQ浏览器', value:37.1, color:'#aa4643'},
                {name:'欧朋浏览器', value:13.8, color:'#89a54e'},
                {name:'百度浏览器', value:1.6, color:'#80699b'},
                {name:'海豚浏览器', value:1.4, color:'#92a8cd'},
                {name:'天天浏览器', value:1.2, color:'#db843d'},
                {name:'其他', value:4.9, color:'#a47d7c'}
            ]
        },
        {
            type:'Column2D',
            title:'Hello World\'s Height In Alphabet',
            start_scale:0, //设置开始刻度为0
            end_scale:26, //设置结束刻度为26
            scale_space:4, //设置刻度间距
            textUnit:" cm",
            data:[
                {name:'H', value:7, color:'#a5c2d5'},
                {name:'E', value:5, color:'#cbab4f'},
                {name:'L', value:12, color:'#76a871'},
                {name:'L', value:12, color:'#76a871'},
                {name:'O', value:15, color:'#a56f8f'},
                {name:'W', value:13, color:'#c12c44'},
                {name:'O', value:15, color:'#a56f8f'},
                {name:'R', value:18, color:'#9f7961'},
                {name:'L', value:12, color:'#76a871'},
                {name:'D', value:4, color:'#6f83a5'}
            ]
        }
    ];

    $.getJSON('website/welcomeChart.action', function (data) {
        if (data.success) {
            var wrapDiv = $('#chart');
            var widthChart = wrapDiv.width()/2-50;
            var heightChart = widthChart/4*3;
            var datas = data.data;
            if(datas.length == 1) {
                widthChart = wrapDiv.width()-50;
            }
            //2D饼图，2D条形图，2D折线图
            for (var i = 0; i < datas.length; i++) {
                //取出要绘制的数据
                var d = datas[i];
                //生成一个绘制画布，并装入大容器中
                var render = $('<div id="render' + i + '"></div>');
                wrapDiv.append(render);

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
                        render:'render' + i,
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
                        render:'render' + i,
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
                        render:'render' + i,
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

                }
                if(i%2 == 0) {
                    wrapDiv.append('<div style="width:50px;height: 1px; "></div>');
                } else {
                    wrapDiv.append('<div style="width: 100%;height: 20px;"></div>')
                }
            }
        } else {
            $.ligerDialog.error(data.message);
        }
    });

});
