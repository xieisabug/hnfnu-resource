window.addEvent('domready', function () {
    var newsPanel = new Panel($('news-view-panel'), {
        contentWidth: 622
    });
    var hotNewsPanel = new Panel($('hot-news-panel'), {
        contentWidth:285
    })
});