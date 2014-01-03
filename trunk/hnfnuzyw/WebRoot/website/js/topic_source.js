window.addEvent('domready', function () {
    var panel = new Panel($('topic-source'), {
        contentHeight: 579
    });
    new Scroll($('topic-source-content'), {
        width:960,
        height:580
    }).withAnimate('fadeSlide');

});