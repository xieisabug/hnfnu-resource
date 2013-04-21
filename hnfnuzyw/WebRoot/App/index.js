var tab,layout,accordion;

$(function () {
    layout = $("#main_body").ligerLayout({
        height:'100%',
        heightDiff:-3,
        leftWidth:200
    });
    var bodyHeight = $(".l-layout-center:first").height();
    accordion = $("#main_menu").ligerAccordion({
        height:bodyHeight - 25
    });
    tab = $("#mainframe").ligerTab();
});
