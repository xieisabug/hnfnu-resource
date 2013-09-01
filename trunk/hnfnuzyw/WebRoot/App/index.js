//几个布局的对象
var tab, layout, accordion;
var hnfnu = {};
//tabid计数器，保证tabid不会重复
var tabidcounter = 0;

function f_heightChanged(options) {
    if (tab)
        tab.addHeight(options.diff);
    if (accordion && options.middleHeight - 24 > 0)
        accordion.setHeight(options.middleHeight - 24);
}
//增加tab项的函数
function f_addTab(tabid, text, url) {
    if (!tab) return;
    if (!tabid) {
        tabidcounter++;
        tabid = "tabid" + tabidcounter;
    }
    tab.addTabItem({ tabid:tabid, text:text, url:url });
}


$(document).ready(function () {
    //菜单初始化
    $("ul.menulist li").live("click",function () {
        var jitem = $(this);
        var tabid = jitem.attr("tabid");
        var url = jitem.attr("url");
        if (!url)return;
        if (!tabid) {
            tabidcounter++;
            tabid = jitem.attr("menuno") + "tabid" + tabidcounter;
            jitem.attr("tabid", tabid);
        }
        f_addTab(tabid, $("span:first", jitem).html(), url);
    }).live("mouseover",function () {
            var item = $(this);
            item.addClass("over");
        }).live("mouseout", function () {
            var item = $(this);
            item.removeClass("over");
        });

    layout = $("#main_body").ligerLayout({
        height:'100%',
        heightDiff:-3,
        leftWidth:'19%',
        centerWidth:'80%',
        space:10,
        onHeightChanged:f_heightChanged
    });
    var bodyHeight = $(".l-layout-center:first").height();

    tab = $("#mainframe").ligerTab({contextmenu:true});
    var main_menu = $("#main_menu");

    $.get('welcome.html', function (data) {
            $('#welcome').html(data)
        }
    );

    /* 数据库获得菜单*/
    $.getJSON('website/index.action', function (data) {
            var menus = data.menuList;
            hnfnu.functionList = {};
            var len = data.functionList.length;
            for(var i = 0; i<len; i++){
                var f = data.functionList[i];
                hnfnu.functionList[f.id] = f.name;
            }
            $(menus).each(function (i, menu) {
                var item = $('<div title="' + menu.name + '"> <ul class="menulist"></ul></div>');
                $(menu.children).each(function (i, submenu) {
                    var subitem = $('<li><img/><span></span><div class="menuitem-l"></div><div class="menuitem-r"></div></li>');
                    subitem.attr({
                        'url':submenu.url,
                        'menuno':submenu.menuId
                    });
                    $("img", subitem).attr("src", submenu.icon || submenu.menuicon);
                    $("span", subitem).html(submenu.menuName || submenu.menuname || submenu.name || submenu.text);
                    $("ul:first", item).append(subitem);
                });
                main_menu.append(item);
            });
            accordion = $("#main_menu").ligerAccordion({
                height:bodyHeight - 25
            });
            $('#pageloading').hide();
        }
    );


});
