var tab, layout, accordion;
$(function () {

    function f_heightChanged(options) {
        if (tab)
            tab.addHeight(options.diff);
        if (accordion && options.middleHeight - 24 > 0)
            accordion.setHeight(options.middleHeight - 24);
    }

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
    )

    //菜单初始化
    $("ul.menulist li").live("mouseover",function () {
        $(this).addClass("over");
    }).live("mouseout", function () {
        $(this).removeClass("over");
    });


    /* 数据库获得菜单*/
    $.getJSON('./Json/menu.json', function (menus) {
            $(menus).each(function (i, menu) {
                var item = $('<div title="' + menu.name + '"> <ul class="menuList"></ul></div>');
                $(menu.children).each(function (i, submenu) {
                    var subitem = $('<li><img/><span></span><div class="menuitem-l"></div><div class="menuitem-r"></div></li>');
                    subitem.attr({
                        url:submenu.url,
                        menuno:submenu.id
                    });
                    $("img", subitem).attr("src", submenu.icon || submenu.menuicon);
                    $("span", subitem).html(submenu.menuname || submenu.name || submenu.text);
                    $("ul:first", item).append(subitem);
                });
                main_menu.append(item);
            });
            accordion = $("#main_menu").ligerAccordion({
                height:bodyHeight - 25
            });
        }
    );


});
