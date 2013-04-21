$(function ()
{
    $("#mainbody").ligerLayout({leftWidth: 200});
    var bodyHeight = $(".l-layout-center:first").height();
    $("#mainmenu").ligerAccordion({height:bodyHeight-24});
    $("#mainframe").ligerTab();


});
