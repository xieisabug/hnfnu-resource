var Tab = new Class({
    initialize: function (id,option) {
        var thiz = this;
        this.option = Object.merge({
            tabTitleCss : 'tabTitle',
            tabTitleSelectedCss : 'selected',
            tabChangeEvent : 'click',
            tabContentCss : 'tabContent',
            tabContentSelectedCss : 'selected'
        }, option);
        this.body = $(id);
        this.body.addClass('tab');
        $$('#'+id+'>ul').addClass('tabTitles');
        this.tabTitles = $$('#'+id+'>ul>li');
        this.tabContents = $$('#'+id+'>div');
        this.tabTitles.each(function(tab, index){
            tab.addClass(thiz.option.tabTitleCss);
            tab.addEvent(thiz.option.tabChangeEvent,function(){
                thiz.tabContents.removeClass(thiz.option.tabContentSelectedCss);
                thiz.tabContents[index].addClass(thiz.option.tabContentSelectedCss);
                thiz.tabTitles.removeClass(thiz.option.tabTitleSelectedCss);
                thiz.tabTitles[index].addClass(thiz.option.tabTitleSelectedCss);
            })
        });
        this.tabTitles[0].addClass(thiz.option.tabTitleSelectedCss);
        this.tabContents[0].addClass(thiz.option.tabContentSelectedCss);
        Array.each(this.tabContents, function(content){
            content.addClass(thiz.option.tabContentCss);
        });
        return this;
    },
    setTabTitleCss : function(className){
        this.option.tabTitleCss = className;
        return this;
    },
    setTabTitleSelectedCss : function(className){
        this.option.tabTitleSelectedCss = className;
        return this;
    },
    setTabContentCss : function(className) {
        this.option.tabContentCss = className;
        return this;
    },
    setTabContentSelectedCss : function(className) {
        this.option.tabContentSelectedCss = className;
    }

});
var Select = new Class({
    initialize: function (id, items, option) {
        var thiz = this;
        thiz.itemNames = [];//下拉列表的名
        thiz.itemValues = [];//下拉列表的值
        thiz.body = $(id);
        thiz.option = Object.merge({
            width: 80,
            height: 30
        }, option);
        thiz.body.addClass('btn');//为对象增加一个按钮的样式
        thiz.body.setStyles({
            width: thiz.option.width,
            height: thiz.option.height
        });
        //进行下拉列表项的初始化
        if (items) {
            //进行html的组合
            var itemHtml = "<ul>";
            Array.each(items, function (item) {
                //将名值都存储到数组中
                thiz.itemNames.push(item.name);
                thiz.itemValues.push(item.value);
                itemHtml += '<li>' + item.name + '</li>';
            });
            itemHtml += "</ul>";

            //设置第一个item为默认选择的item
            thiz.body.set('text', items[0].name);
            thiz.body.set('value', items[0].value);
            //生成html
            var bodyPosition = thiz.body.getPosition();
            console.log(bodyPosition);
            var bodySize = thiz.body.getSize();
            console.log(bodySize);
            thiz.selectDiv = new Element('div', {
                styles: {
                    height: items.length * 30 + 40,
                    width: 200,
                    top: bodyPosition.y + bodySize.y,
                    left: bodyPosition.x,
                    position:'absolute',
                    display: 'none'//初始不显示
                },
                'class': 'selectItemDiv',
                html: itemHtml
            });
            $$('body').grab(thiz.selectDiv);//将选择的面板添加到网页中
            //对按钮绑定点击事件，使面板可以显示和隐藏
            thiz.clickFunction =  function () {
                if (thiz.selectDiv.getStyle('display') == 'none') {
                    thiz.selectDiv.setStyle('display', 'block');
                } else {
                    thiz.selectDiv.setStyle('display', 'none');
                }
            };
            thiz.body.addEvent('click',thiz.clickFunction);
            //绑定鼠标事件，当鼠标移开选择面板的时候会隐藏
            thiz.mouseLeaveFunction = function(){
                thiz.setStyle('display', 'none');
            };
            thiz.selectDiv.addEvent('mouseleave',thiz.mouseLeaveFunction);
            //对选择的每个li绑定点击事件
            Array.each(thiz.selectDiv.getElements('li'), function (item,index) {
                item.addEvent('click', function () {
                    thiz.body.set('text', thiz.itemNames[index]);
                    thiz.body.set('value', thiz.itemValues[index]);
                });
            });
        } else {
            new Error("下拉列表的名称和值不能为空,必须指定Select的第二个参数")
        }
        if(Browser.ie6){
            thiz.dropDownIcon = new Element('span',{html:'▼'});
        } else {
            thiz.dropDownIcon = new Element('span.caret');
        }
        thiz.body.grab(thiz.dropDownIcon,'bottom');
        return thiz;
    },
    //增加选择项
    selectItemAdd: function (arrays) {
        var thiz = this;
        //重新生成html
        var itemHtml = "<ul>";
        if (thiz.itemNames.length > 0) {//如果之前就有选择项，那么先生成之前的html
            Array.each(thiz.itemNames, function (item) {
                itemHtml += '<li>' + item + '</li>';
            });
        }
        Array.each(arrays, function (item) {
            thiz.itemNames.push(item.name);
            thiz.itemValues.push(item.value);
            itemHtml += '<li>' + item.name + '</li>';
        });
        itemHtml += "</ul>";
        //设置html
        thiz.selectDiv.set('html', itemHtml);
        //适配高度
        thiz.selectDiv.setStyle('height', thiz.itemNames.length * 30 + 40);
        //重新绑定事件
        Array.each(thiz.selectDiv.getElements('li'), function (item, index) {
            item.addEvent('click', function () {
                thiz.body.set('text', thiz.itemNames[index]);
                thiz.body.set('value', thiz.itemValues[index]);
            });
        });
        return thiz;
    },
    //增加按钮的样式
    addButtonClass:function(className){
        this.body.addClass(className);
        return this;
    },
    //增加选择面板的样式
    addSelectPanelClass:function(className){
        this.selectDiv.addClass(className);
        return this;
    },
    //移除按钮的样式
    removeButtonClass:function(className){
        this.body.removeClass(className);
        return this;
    },
    //移除选择面板的样式
    removeSelectPanelClass:function(className){
        this.selectDiv.removeClass(className);
        return this;
    },
    //增加动画效果
    animate:function(){
        var thiz = this;
        //动画效果设置
        var bouncingOut = new Fx.Tween(this.selectDiv,{
            duration:'1000',
            transition:'bounce:out'
        });
        //重置样式
        this.selectDiv.setStyles({
            height:0,
            overflow:'hidden',
            display:'none'
        });
        //移除以前的点击事件，覆盖点击方法，增加新的带有动画的点击方法，并绑定事件
        this.body.removeEvent('click',this.clickFunction);
        this.clickFunction = function () {
            bouncingOut.stop();
            if (thiz.selectDiv.getStyle('height') != (thiz.itemNames.length * 30 + 40 + 'px') ) {
                thiz.selectDiv.setStyle('display', 'block');
                bouncingOut.start('height', thiz.itemNames.length * 30 + 40);
            } else {
                bouncingOut.start('height', 0).chain(function(){
                    thiz.selectDiv.setStyle('display', 'none');
                });
            }
        };
        this.body.addEvent('click', this.clickFunction);

        //移除以前的鼠标移开事件，覆盖方法，并且增加带有动画的鼠标移开方法，并绑定事件
        this.selectDiv.removeEvent('mouseleave',this.mouseLeaveFunction);
        this.mouseLeaveFunction = function () {
            bouncingOut.stop();
            bouncingOut.start('height', 0).chain(function(){
                thiz.selectDiv.setStyle('display', 'none');
            });
        };
        this.selectDiv.addEvent('mouseleave',this.mouseLeaveFunction );
        return this;
    }
});
var Button = new Class({
    initialize: function (el,option) {
        if(instanceOf(el ,Array)) {
            throw Error("初始化按钮错误，不能传入一个数组对象，如果要创建按钮组，请创建ButtonGroup。");
            return;
        }
        this.body = el;
        //console.log(this.body);
        this.option = Object.merge({
            width:74,
            height:34,
            onclick:function(){
            }
        },option);
        if(this.body.tagName == 'BUTTON') {
            this.body.addEvent('click',this.option.onclick);
        } else if(this.body.tagName == 'A') {
            this.option.height = 'auto';
            this.option.width = 'auto';
            this.body.addClass('abtn');
        } else {
            throw Error("您传入的对象类型不对，请用button标签和a标签来构建按钮。");
            return;
        }
        this.body.addClass('btn');
        this.body.setStyles({
            width:this.option.width,
            height:this.option.height
        });
        return this;
    },
    addClass:function(className) {
        this.body.addClass(className);
        return this;
    },
    removeClass:function(className){
        this.body.removeClass(className);
        return this;
    }
});