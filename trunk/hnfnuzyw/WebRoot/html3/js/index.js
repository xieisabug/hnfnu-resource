$(function(){
    $(".dropdown-menu li").on("click",function(){
        $(this).parent().prev().html($("a",this).text() + ' <span class="caret"></span>');
    });
});