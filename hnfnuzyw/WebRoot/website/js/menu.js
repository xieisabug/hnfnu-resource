function SlideView(e){
   for(var r=document.getElementById(e).getElementsByTagName('dl'),c=clearInterval,i=-1,p=r[0],j; j=r[++i];){
       j.style.height=(i?24:160)+'px';
       j.onmouseover=function(){clearTimeout(j);var i=this;j=setTimeout(function(){if(p!=i)_(p,160,24)(p=i,24,160)},120)};
   }
   function _(el,f,t){
       c(el.$1);el.className=f>t?'':'on';
       return el.$1=setInterval(function(){el.style.height=(f+=Math[f>t?'floor':'ceil']((t-f)*.3))+'px';if (f==t)c(el.$1)},10),_
   }
   
	if(document.getElementById("resource_content").clientHeight < document.getElementById("idSlideView3").clientHeight){
		console.log(document.getElementById("resource_content").clientHeight);
		console.log(document.getElementById("idSlideView3").clientHeight);
		document.getElementById("resource_content").style.height=document.getElementById("idSlideView3").offsetHeight+"px";
		document.getElementById("topic").style.height=(document.getElementById("idSlideView3").offsetHeight+69)+"px";
	}
}
$(function(){
    new SlideView("idSlideView3");
});