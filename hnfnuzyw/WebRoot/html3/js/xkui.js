var Panel = new Class({
    initialize: function (el,option) {
        var thiz = this;
        this.option = Object.merge({
            panelTitleCss : 'panel-head',
            panelTitleIcon : 'default',
            panelContentCss : 'panel-content',
            contentHeight:'auto',
            contentWidth:'auto'
        },option);
        this.panel = el;
        var childrens = el.getChildren();
        if(childrens.length != 2) {
            throw Error("Panel的格式不对，其中应该只包含两个子div。");
        }
        this.panelTitle = childrens[0];
        this.panelContent = childrens[1];
        this.panelTitleIcon = this.panelTitle.getElement('.panel-head-icon');
        if(this.option.panelTitleIcon == 'default') {
            this.panelTitleIcon.addClass('panel-head-icon-arrow');
        } else {
            this.panelTitleIcon.addClass('panel-head-icon-'+this.option.panelTitleIcon);
        }

        this.panelTitle.addClass(this.option.panelTitleCss);
        this.panelContent.addClass(this.option.panelContentCss);
        this.panelContent.setStyles({
            width:this.option.contentWidth,
            height:this.option.contentHeight
        });
        return this;
    },
    addPanelTitleCss:function(className) {
        this.panelTitle.addClass(className);
        return this;
    },
    removePanelTitleCss : function(className) {
        this.panelTitle.removeClass(className);
        return this;
    },
    addPanelContentCss : function(className) {
        this.panelContent.addClass(className);
        return this;
    },
    removePanelContentCss : function(className) {
        this.panelContent.removeClass(className);
        return this;
    },
    updateWithAnimate:function(type,html,func){
        var thiz = this;
        var fx = new Fx.Morph(thiz.panelContent, {
            duration: 1000,
            transition:Fx.Transitions['Quad']['easeIn']
        });
        if(type == 'toggle') {
            var h = thiz.panelContent.getSize().y-27;
            fx.start({
                height:0
            }).chain(function(){
                    thiz.panelContent.set('html',html);
                    fx.start({
                        height:h
                    });
                    if(func) {
                        func();
                    }
                });
        } else if(type == 'append') {
            new Element('div').set('html',html).getChildren().each(function(item){
                thiz.panelContent.grab(item);
            });
            var h = thiz.panelContent.getScrollSize().y-27;
            fx.start({height:h});
            if(func) {
                func();
            }
        }

    }
});
var Tab = new Class({
    initialize: function (id, option) {
        var thiz = this;
        this.option = Object.merge({
            tabTitleCss: 'tabTitle',
            tabTitleSelectedCss: 'selected',
            tabChangeEvent: 'click',
            tabContentCss: 'tabContent',
            tabContentSelectedCss: 'selected'
        }, option);
        if(instanceOf(id,String)) {
            this.body = $(id);
        } else if(instanceOf(id,Element)){
            this.body = id;
        }
        this.body.addClass('tab');
        this.body.getChildren("ul").addClass('tabTitles');
        this.tabTitles = this.body.getChildren("ul>li");
        this.tabContents = this.body.getChildren("div");
        this.tabTitles.each(function (tab, index) {
            tab.addClass(thiz.option.tabTitleCss);
            tab.addEvent(thiz.option.tabChangeEvent, function () {
                thiz.tabContents.removeClass(thiz.option.tabContentSelectedCss);
                thiz.tabContents[index].addClass(thiz.option.tabContentSelectedCss);
                thiz.tabTitles.removeClass(thiz.option.tabTitleSelectedCss);
                thiz.tabTitles[index].addClass(thiz.option.tabTitleSelectedCss);
            })
        });
        this.tabTitles[0].addClass(thiz.option.tabTitleSelectedCss);
        this.tabContents[0].addClass(thiz.option.tabContentSelectedCss);
        Array.each(this.tabContents, function (content) {
            content.addClass(thiz.option.tabContentCss);
        });
        return this;
    },
    setTabTitleCss: function (className) {
        this.option.tabTitleCss = className;
        return this;
    },
    setTabTitleSelectedCss: function (className) {
        this.option.tabTitleSelectedCss = className;
        return this;
    },
    setTabContentCss: function (className) {
        this.option.tabContentCss = className;
        return this;
    },
    setTabContentSelectedCss: function (className) {
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
            var bodySize = thiz.body.getSize();
            thiz.selectDiv = new Element('div', {
                styles: {
                    height: items.length * 30 + 40,
                    width: 200,
                    top: bodyPosition.y + bodySize.y,
                    left: bodyPosition.x,
                    position: 'absolute',
                    display: 'none'//初始不显示
                },
                'class': 'selectItemDiv',
                html: itemHtml
            });
            this.body.getParent().grab(thiz.selectDiv);//将选择的面板添加到网页中
            //对按钮绑定点击事件，使面板可以显示和隐藏
            thiz.clickFunction = function () {
                if (thiz.selectDiv.getStyle('display') == 'none') {
                    thiz.selectDiv.setStyle('display', 'block');
                } else {
                    thiz.selectDiv.setStyle('display', 'none');
                }
            };
            thiz.body.addEvent('click', thiz.clickFunction);
            //绑定鼠标事件，当鼠标移开选择面板的时候会隐藏
            thiz.mouseLeaveFunction = function () {
                thiz.setStyle('display', 'none');
            };
            thiz.selectDiv.addEvent('mouseleave', thiz.mouseLeaveFunction);
            //对选择的每个li绑定点击事件
            Array.each(thiz.selectDiv.getElements('li'), function (item, index) {
                item.addEvent('click', function () {
                    thiz.body.set('text', thiz.itemNames[index]);
                    thiz.body.set('value', thiz.itemValues[index]);
                });
            });
        } else {
            new Error("下拉列表的名称和值不能为空,必须指定Select的第二个参数")
        }
        if (Browser.ie6) {
            thiz.dropDownIcon = new Element('span', {html: '▼'});
        } else {
            thiz.dropDownIcon = new Element('span.caret');
        }
        thiz.body.grab(thiz.dropDownIcon, 'bottom');
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
    addButtonClass: function (className) {
        this.body.addClass(className);
        return this;
    },
    //增加选择面板的样式
    addSelectPanelClass: function (className) {
        this.selectDiv.addClass(className);
        return this;
    },
    //移除按钮的样式
    removeButtonClass: function (className) {
        this.body.removeClass(className);
        return this;
    },
    //移除选择面板的样式
    removeSelectPanelClass: function (className) {
        this.selectDiv.removeClass(className);
        return this;
    },
    //增加动画效果
    animate: function () {
        var thiz = this;
        //动画效果设置
        var bouncingOut = new Fx.Tween(this.selectDiv, {
            duration: '1000',
            transition: 'bounce:out'
        });
        //重置样式
        this.selectDiv.setStyles({
            height: 0,
            overflow: 'hidden',
            display: 'none'
        });
        //移除以前的点击事件，覆盖点击方法，增加新的带有动画的点击方法，并绑定事件
        this.body.removeEvent('click', this.clickFunction);
        this.clickFunction = function () {
//            bouncingOut.stop();
            bouncingOut.cancel();
            if (thiz.selectDiv.getStyle('height') != (thiz.itemNames.length * 30 + 40 + 'px')) {
                thiz.selectDiv.setStyle('display', 'block');
                bouncingOut.start('height', thiz.itemNames.length * 30 + 40);
            } else {
                bouncingOut.start('height', 0).chain(function () {
                    thiz.selectDiv.setStyle('display', 'none');
                });
            }
        };
        this.body.addEvent('click', this.clickFunction);

        //移除以前的鼠标移开事件，覆盖方法，并且增加带有动画的鼠标移开方法，并绑定事件
        this.selectDiv.removeEvent('mouseleave', this.mouseLeaveFunction);
        this.mouseLeaveFunction = function () {
//            bouncingOut.stop();
            bouncingOut.cancel();
            bouncingOut.start('height', 0).chain(function () {
                thiz.selectDiv.setStyle('display', 'none');
            });
        };
        this.selectDiv.addEvent('mouseleave', this.mouseLeaveFunction);
        return this;
    },
    setSelectDivOffset: function (top, left) {
        var oldT = this.selectDiv.getStyle('top').toInt();
        var oldL = this.selectDiv.getStyle('left').toInt();
        this.selectDiv.setStyles({
            'top': oldT + top,
            'left': oldL + left
        });
        return this;
    },
    getValue:function(){
        return this.body.get('value');
    }
});
var Button = new Class({
    initialize: function (el, option) {
        if (instanceOf(el, Array)) {
            throw Error("初始化按钮错误，不能传入一个数组对象，如果要创建按钮组，请创建ButtonGroup。");
            return;
        }
        this.body = el;
        this.option = Object.merge({
            width: 74,
            height: 34,
            onclick: function () {
            }
        }, option);
        if (this.body.tagName == 'BUTTON') {
            this.body.addEvent('click', this.option.onclick);
        } else if (this.body.tagName == 'A') {
            this.option.height = 'auto';
            this.option.width = 'auto';
            this.body.addClass('abtn');
        } else {
            throw Error("您传入的对象类型不对，请用button标签和a标签来构建按钮。");
            return;
        }
        this.body.addClass('btn');
        this.body.setStyles({
            width: this.option.width,
            height: this.option.height
        });
        return this;
    },
    addClass: function (className) {
        this.body.addClass(className);
        return this;
    },
    removeClass: function (className) {
        this.body.removeClass(className);
        return this;
    }
});
var Input = new Class({
    initialize: function (el, option) {
        if (instanceOf(el, Array) && el.length != 1) {
            throw Error("初始化按钮错误，不能传入一个数组对象，如果要创建按钮组，请创建ButtonGroup。");
            return;
        }
        this.body = el;
        this.option = Object.merge({
            width: 240,
            height: Browser.ie7? 32:20,
            className: 'input-text'
        }, option);


        this.body.addClass(this.option.className);
        this.body.setStyles({
            'width': this.option.width,
            'height': this.option.height
        });
        return this;
    },
    addClass: function (className) {
        this.body.addClass(className);
        return this;
    },
    removeClass: function (className) {
        this.body.removeClass(className);
        return this;
    },
    getValue:function(){
        return this.body.get('value');
    }
});
var Scroll = new Class({
    initialize: function (el, option) {
        var thiz = this;
        this.option = Object.merge({
            width: 500,
            height: 500,
            leftArrowCss : 'leftArrow',
            rightArrowCss : 'rightArrow',
            arrowAlwaysShow:true
        }, option);
        this.scrollBody = el;
        this.scrollBody.addClass('scroll-content');
        this.scrollBody.setStyles({
            width: this.option.width,
            height: this.option.height
        });
        this.pages = this.scrollBody.getChildren('div');
        this.pageCount = this.pages.length;
        if (this.pageCount == 0) {
            throw Error('请添加内容，内容不可为空。');
        }
        if(this.pageCount > 1) {
            this.rightBtn = new Element('a',{
                'class':'right rightArrow'
            });
            this.scrollBody.grab(this.rightBtn,'bottom');
            this.rightBtn.addEvent('click',function(){
                thiz.nextPage();
            });
            this.leftBtn = new Element('a',{
                'class':'left leftArrow'
            });
            this.scrollBody.grab(this.leftBtn,'bottom');
            this.leftBtn.addEvent('click',function(){
                thiz.prePage();
            });
            if(!this.option.arrowAlwaysShow) {
                this.rightBtn.addClass('hidden');
                this.leftBtn.addClass('hidden');
                this.scrollBody.addEvent('mouseover',function(){
                    thiz.rightBtn.removeClass('hidden');
                    thiz.leftBtn.removeClass('hidden');
                });
                this.scrollBody.addEvent('mouseleave',function(){
                    thiz.rightBtn.addClass('hidden');
                    thiz.leftBtn.addClass('hidden');
                });
            }
        }
        this.currentPage = 1;
        this.pages.each(function (item) {
            item.addClass('scroll-item');
            item.setStyle('opacity',0);
        });
        this.pages[0].addClass('show');
        this.animate = null;
        return this;
    },
    scrollTo: function (to) {
        this.pages.removeClass('show');
        this.pages[to - 1].addClass('show');
        this.currentPage = to;
    },
    nextPage: function () {
        if (this.currentPage == this.pageCount) {
            return;
        }
        this.scrollTo(this.currentPage + 1);
    },
    prePage: function () {
        if (this.currentPage == 1) {
            return;
        }
        this.scrollTo(this.currentPage - 1);
    },
    withAnimate: function (type) {
        if (type == 'fadeSlide') {
            this.pages.removeClass('show');
            this.pages.addClass('visible');
            this.pages[this.currentPage - 1].setStyle('opacity', 1);

            this.scrollTo = function (to) {
                this.animate = new Fx.Morph(this.pages[to - 1], {
                    duration: 1000
                });
                this.animate.transition = Fx.Transitions.Cubic.easeOut;
                this.out = new Fx.Morph(this.pages[this.currentPage - 1], {
                    duration: 1000
                });
                this.out.transition = Fx.Transitions.Cubic.easeOut;
                if (to > this.currentPage) {
                    this.animate.start({
                        left: [this.option.width, 0],
                        opacity: [0, 1]
                    });
                    this.out.start({
                        opacity: [1, 0]
                    });
                } else {
                    this.animate.start({
                        opacity: [0, 1]
                    });
                    this.out.start({
                        opacity: [1, 0],
                        left: [0, this.option.width]
                    });
                }
                this.currentPage = to;
            }
        }
        return this;
    }
});
var TextArea = new Class({
    initialize: function (el,option) {
        var thiz = this;
        this.option = Object.merge({
            width:null,
            height:null,
            isReadOnly:false
        },option);
        this.textarea = el;
        if(this.option.width) {
            this.textarea.setStyle('width',this.option.width);
        }
        if(this.option.height) {
            this.textarea.setStyle('height',this.option.height);
        }
        if(this.option.isReadOnly) {
            this.textarea.setProperty('readonly',true);
        }
        this.textarea.addClass('textarea');

        return this;
    },
    appendText:function(text){
        this.textarea.value += text;
        return this;
    },
    addClass:function(className){
        this.textarea.addClass(className);
        return this;
    },
    removeClass:function(className) {
        this.textarea.removeClass(className);
        return this;
    }
});
var Drag = new Class({

    Implements: [Events, Options],

    options: {/*
     onBeforeStart: function(thisElement){},
     onStart: function(thisElement, event){},
     onSnap: function(thisElement){},
     onDrag: function(thisElement, event){},
     onCancel: function(thisElement){},
     onComplete: function(thisElement, event){},*/
        snap: 6,
        unit: 'px',
        grid: false,
        style: true,
        limit: false,
        handle: false,
        invert: false,
        preventDefault: false,
        stopPropagation: false,
        modifiers: {x: 'left', y: 'top'}
    },

    initialize: function(){
        var params = Array.link(arguments, {
            'options': Type.isObject,
            'element': function(obj){
                return obj != null;
            }
        });

        this.element = document.id(params.element);
        this.document = this.element.getDocument();
        this.setOptions(params.options || {});
        var htype = typeOf(this.options.handle);
        this.handles = ((htype == 'array' || htype == 'collection') ? $$(this.options.handle) : document.id(this.options.handle)) || this.element;
        this.mouse = {'now': {}, 'pos': {}};
        this.value = {'start': {}, 'now': {}};

        this.selection = (Browser.ie) ? 'selectstart' : 'mousedown';


        if (Browser.ie && !Drag.ondragstartFixed){
            document.ondragstart = Function.from(false);
            Drag.ondragstartFixed = true;
        }

        this.bound = {
            start: this.start.bind(this),
            check: this.check.bind(this),
            drag: this.drag.bind(this),
            stop: this.stop.bind(this),
            cancel: this.cancel.bind(this),
            eventStop: Function.from(false)
        };
        this.attach();
    },

    attach: function(){
        this.handles.addEvent('mousedown', this.bound.start);
        return this;
    },

    detach: function(){
        this.handles.removeEvent('mousedown', this.bound.start);
        return this;
    },

    start: function(event){
        var options = this.options;

        if (event.rightClick) return;

        if (options.preventDefault) event.preventDefault();
        if (options.stopPropagation) event.stopPropagation();
        this.mouse.start = event.page;

        this.fireEvent('beforeStart', this.element);

        var limit = options.limit;
        this.limit = {x: [], y: []};

        var z, coordinates;
        for (z in options.modifiers){
            if (!options.modifiers[z]) continue;

            var style = this.element.getStyle(options.modifiers[z]);

            // Some browsers (IE and Opera) don't always return pixels.
            if (style && !style.match(/px$/)){
                if (!coordinates) coordinates = this.element.getCoordinates(this.element.getOffsetParent());
                style = coordinates[options.modifiers[z]];
            }

            if (options.style) this.value.now[z] = (style || 0).toInt();
            else this.value.now[z] = this.element[options.modifiers[z]];

            if (options.invert) this.value.now[z] *= -1;

            this.mouse.pos[z] = event.page[z] - this.value.now[z];

            if (limit && limit[z]){
                var i = 2;
                while (i--){
                    var limitZI = limit[z][i];
                    if (limitZI || limitZI === 0) this.limit[z][i] = (typeof limitZI == 'function') ? limitZI() : limitZI;
                }
            }
        }

        if (typeOf(this.options.grid) == 'number') this.options.grid = {
            x: this.options.grid,
            y: this.options.grid
        };

        var events = {
            mousemove: this.bound.check,
            mouseup: this.bound.cancel
        };
        events[this.selection] = this.bound.eventStop;
        this.document.addEvents(events);
    },

    check: function(event){
        if (this.options.preventDefault) event.preventDefault();
        var distance = Math.round(Math.sqrt(Math.pow(event.page.x - this.mouse.start.x, 2) + Math.pow(event.page.y - this.mouse.start.y, 2)));
        if (distance > this.options.snap){
            this.cancel();
            this.document.addEvents({
                mousemove: this.bound.drag,
                mouseup: this.bound.stop
            });
            this.fireEvent('start', [this.element, event]).fireEvent('snap', this.element);
        }
    },

    drag: function(event){
        var options = this.options;

        if (options.preventDefault) event.preventDefault();
        this.mouse.now = event.page;

        for (var z in options.modifiers){
            if (!options.modifiers[z]) continue;
            this.value.now[z] = this.mouse.now[z] - this.mouse.pos[z];

            if (options.invert) this.value.now[z] *= -1;

            if (options.limit && this.limit[z]){
                if ((this.limit[z][1] || this.limit[z][1] === 0) && (this.value.now[z] > this.limit[z][1])){
                    this.value.now[z] = this.limit[z][1];
                } else if ((this.limit[z][0] || this.limit[z][0] === 0) && (this.value.now[z] < this.limit[z][0])){
                    this.value.now[z] = this.limit[z][0];
                }
            }

            if (options.grid[z]) this.value.now[z] -= ((this.value.now[z] - (this.limit[z][0]||0)) % options.grid[z]);

            if (options.style) this.element.setStyle(options.modifiers[z], this.value.now[z] + options.unit);
            else this.element[options.modifiers[z]] = this.value.now[z];
        }

        this.fireEvent('drag', [this.element, event]);
    },

    cancel: function(event){
        this.document.removeEvents({
            mousemove: this.bound.check,
            mouseup: this.bound.cancel
        });
        if (event){
            this.document.removeEvent(this.selection, this.bound.eventStop);
            this.fireEvent('cancel', this.element);
        }
    },

    stop: function(event){
        var events = {
            mousemove: this.bound.drag,
            mouseup: this.bound.stop
        };
        events[this.selection] = this.bound.eventStop;
        this.document.removeEvents(events);
        if (event) this.fireEvent('complete', [this.element, event]);
    }

});
Element.implement({

    makeResizable: function(options){
        var drag = new Drag(this, Object.merge({
            modifiers: {
                x: 'width',
                y: 'height'
            }
        }, options));

        this.store('resizer', drag);
        return drag.addEvent('drag', function(){
            this.fireEvent('resize', drag);
        }.bind(this));
    }

});
Drag.Move = new Class({

    Extends: Drag,

    options: {/*
     onEnter: function(thisElement, overed){},
     onLeave: function(thisElement, overed){},
     onDrop: function(thisElement, overed, event){},*/
        droppables: [],
        container: false,
        precalculate: false,
        includeMargins: true,
        checkDroppables: true
    },

    initialize: function(element, options){
        this.parent(element, options);
        element = this.element;

        this.droppables = $$(this.options.droppables);
        this.container = document.id(this.options.container);

        if (this.container && typeOf(this.container) != 'element')
            this.container = document.id(this.container.getDocument().body);

        if (this.options.style){
            if (this.options.modifiers.x == 'left' && this.options.modifiers.y == 'top'){
                var parent = element.getOffsetParent(),
                    styles = element.getStyles('left', 'top');
                if (parent && (styles.left == 'auto' || styles.top == 'auto')){
                    element.setPosition(element.getPosition(parent));
                }
            }

            if (element.getStyle('position') == 'static') element.setStyle('position', 'absolute');
        }

        this.addEvent('start', this.checkDroppables, true);
        this.overed = null;
    },

    start: function(event){
        if (this.container) this.options.limit = this.calculateLimit();

        if (this.options.precalculate){
            this.positions = this.droppables.map(function(el){
                return el.getCoordinates();
            });
        }

        this.parent(event);
    },

    calculateLimit: function(){
        var element = this.element,
            container = this.container,

            offsetParent = document.id(element.getOffsetParent()) || document.body,
            containerCoordinates = container.getCoordinates(offsetParent),
            elementMargin = {},
            elementBorder = {},
            containerMargin = {},
            containerBorder = {},
            offsetParentPadding = {};

        ['top', 'right', 'bottom', 'left'].each(function(pad){
            elementMargin[pad] = element.getStyle('margin-' + pad).toInt();
            elementBorder[pad] = element.getStyle('border-' + pad).toInt();
            containerMargin[pad] = container.getStyle('margin-' + pad).toInt();
            containerBorder[pad] = container.getStyle('border-' + pad).toInt();
            offsetParentPadding[pad] = offsetParent.getStyle('padding-' + pad).toInt();
        }, this);

        var width = element.offsetWidth + elementMargin.left + elementMargin.right,
            height = element.offsetHeight + elementMargin.top + elementMargin.bottom,
            left = 0,
            top = 0,
            right = containerCoordinates.right - containerBorder.right - width,
            bottom = containerCoordinates.bottom - containerBorder.bottom - height;

        if (this.options.includeMargins){
            left += elementMargin.left;
            top += elementMargin.top;
        } else {
            right += elementMargin.right;
            bottom += elementMargin.bottom;
        }

        if (element.getStyle('position') == 'relative'){
            var coords = element.getCoordinates(offsetParent);
            coords.left -= element.getStyle('left').toInt();
            coords.top -= element.getStyle('top').toInt();

            left -= coords.left;
            top -= coords.top;
            if (container.getStyle('position') != 'relative'){
                left += containerBorder.left;
                top += containerBorder.top;
            }
            right += elementMargin.left - coords.left;
            bottom += elementMargin.top - coords.top;

            if (container != offsetParent){
                left += containerMargin.left + offsetParentPadding.left;
                top += ((Browser.ie6 || Browser.ie7) ? 0 : containerMargin.top) + offsetParentPadding.top;
            }
        } else {
            left -= elementMargin.left;
            top -= elementMargin.top;
            if (container != offsetParent){
                left += containerCoordinates.left + containerBorder.left;
                top += containerCoordinates.top + containerBorder.top;
            }
        }

        return {
            x: [left, right],
            y: [top, bottom]
        };
    },

    getDroppableCoordinates: function(element){
        var position = element.getCoordinates();
        if (element.getStyle('position') == 'fixed'){
            var scroll = window.getScroll();
            position.left += scroll.x;
            position.right += scroll.x;
            position.top += scroll.y;
            position.bottom += scroll.y;
        }
        return position;
    },

    checkDroppables: function(){
        var overed = this.droppables.filter(function(el, i){
            el = this.positions ? this.positions[i] : this.getDroppableCoordinates(el);
            var now = this.mouse.now;
            return (now.x > el.left && now.x < el.right && now.y < el.bottom && now.y > el.top);
        }, this).getLast();

        if (this.overed != overed){
            if (this.overed) this.fireEvent('leave', [this.element, this.overed]);
            if (overed) this.fireEvent('enter', [this.element, overed]);
            this.overed = overed;
        }
    },

    drag: function(event){
        this.parent(event);
        if (this.options.checkDroppables && this.droppables.length) this.checkDroppables();
    },

    stop: function(event){
        this.checkDroppables();
        this.fireEvent('drop', [this.element, this.overed, event]);
        this.overed = null;
        return this.parent(event);
    }

});
Element.implement({

    makeDraggable: function(options){
        var drag = new Drag.Move(this, options);
        this.store('dragger', drag);
        return drag;
    }

});
var Dialog = new Class({
    initialize: function (el, option) {
        var thiz = this;
        this.option = Object.merge({
            width: null,
            height: null,
            left:'center',
            top:'center',
            titleCss: 'dialog-title',
            contentCss: 'dialog-content',
            titleHtml:'',
            contentHtml:'',
            position: 'left_bottom',
            draggable: false,
            model: true,
            closeable:false,
            show:false
        }, option);
        this.dialog = el;
        //如果不是自己确定的绝对定位，那么不允许拖拽
        if(this.option.position!='absolute') {
            this.option.draggable = false;
            this.option.show = false;
            this.dialog.setStyles({
                'position':'fixed',
                overflow : 'hidden'
            });
            //创建动画
            this.animate = new Fx.Morph(this.dialog, {
                duration: 1000
            });
        } else {//如果是绝对定位，则要处理位置
            if(this.option.left == 'center') {
                this.dialog.setStyle('left',(document.getWidth()-this.option.width)/2);
            } else {
                this.dialog.setStyle('left',this.option.left);
            }
            if(this.option.top == 'center') {
                this.dialog.setStyle('top',(document.getHeight()-this.option.height)/2);
            } else {
                this.dialog.setStyle('top',this.option.top);
            }
            this.dialog.setStyle('position','absolute');
        }
        //可拖拽
        if (this.option.draggable) {
            this.dialog.makeDraggable();
        }
        //模态对话框
        if (this.option.model) {
            this.createShadowDiv();
        }
        this.dialog.setStyle('z-index',101);
        //创建头
        this.title = new Element('div', {
            'class': this.option.titleCss,
            html:this.option.titleHtml
        });
        //如果可以关闭，则添加关闭按钮
        if(this.option.closeable) {
            this.title.grab(new Element('div',{
                html:'x',
                styles:{
                    float:'right',
                    height:20,
                    width:20,
                    'cursor':'pointer'
                },
                events:{
                    click:function(){
                        thiz.close();
                    }
                }
            }));
        }
        //创建内容框
        this.content = new Element('div', {
            'class': this.option.contentCss,
            html:this.option.contentHtml,
            styles:{
                height:this.option.height?this.option.height-37:0
            }
        });
        //如果指定了宽高则设置
        if (this.option.width) {
            this.dialog.setStyle('width', this.option.width);
        }
        if (this.option.height) {
            this.dialog.setStyle('height', this.option.height);
        }
        //将标题栏和内容框添加进来
        this.dialog.grab(this.title);
        this.dialog.grab(this.content);
        //如果指定了一开始就显示，则直接显示
        if(!this.option.show) {
            this.dialog.setStyle('visibility','hidden');
        }
        return this;
    },
    show:function(){
        if(this.option.position == 'left_bottom') {
            this.dialog.setStyles({
                bottom:0,
                left:10,
                visibility:'visible',
                opacity:0
            });
            this.animate.start({
                height:[0,this.option.height],
                opacity:[0.5,1]
            });
        } else if(this.option.position == 'right_bottom') {
            this.dialog.setStyles({
                bottom:0,
                right:10,
                visibility:'visible',
                opacity:0
            });
            this.animate.start({
                height:[0,this.option.height],
                opacity:[0.5,1]
            });
        } else {
            this.dialog.setStyle('visibility','visible');
        }

        return this;
    },
    close:function(){
        var thiz = this;
        if(this.option.position == 'left_bottom') {
            this.animate.start({
                height:[this.option.height,0],
                opacity:[1,0.5]
            }).chain(function(){
                    thiz.dialog.setStyle('visibility','hidden');
                });
        } else if(this.option.position == 'right_bottom'){
            this.animate.start({
                height:[this.option.height,0],
                opacity:[1,0.5]
            }).chain(function(){
                    thiz.dialog.setStyle('visibility','hidden');
                });
        } else {
            this.dialog.setStyle('visibility','hidden');
        }
        return this;
    },
    createShadowDiv: function () {
        this.shadow = new Element('div');
        this.shadow.setStyles({
            left: 0,
            top: 0,
            width: '100%',
            height: '100%',
            position: 'absolute',
            'background-color': '#000',
            'z-index': 100,
            opacity: 0.5,
            filter: 'alpha(opacity=50)'
        });
        $$('body').adopt(this.shadow);
        return this;
    },
    closeShadow:function(){
        this.shadow.setStyle('visibility','hidden');
        return this;
    },
    setContentHtml:function(html){
        this.content.set('html',html);
        return this;
    }
});