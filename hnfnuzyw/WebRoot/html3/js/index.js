$(function(){
    $(".dropdown-menu li").on("click",function(){
        $("button.dropdown-toggle").html($("a",this).text() + ' <span class="caret"></span>');
    });
});