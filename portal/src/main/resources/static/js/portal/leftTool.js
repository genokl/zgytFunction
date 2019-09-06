
/**
 * 页面左侧联系我们
 * 小页面js
 */
$(function(){
	//请求页面数据
	loadPageDate();
	
});

function initPageTool(){
	/**
     * 页面动作
     */
    var len = $(".num  li").length;
//    console.log($(".num  li").length);
    var index = 0;  //图片序号
    var adTimer;
    var lock=1;//
    $(".num li").mouseover(function() {
        index = $(".num li").index(this);  //获取鼠标悬浮 li 的index
        showImg(index);
    }).eq(0).mouseover();
    //滑入停止动画，滑出开始动画.
    $('#scrollPics').hover(function() {
        clearInterval(adTimer);
    }, function() {
        adTimer = setInterval(function() {
            showImg(index);
            index++;
            if(index==len){
                index=0;
            }
        }, 3000);
    }).trigger("mouseleave");
    function showImg(index) {
        // var adHeight = $("#scrollPics>ul>li:first").height();
        // $(".slider").stop(true, false).animate({
        //     "marginTop": -adHeight * index + "px"    //改变 marginTop 属性的值达到轮播的效果
        // }, 1000);
        // $(".num li").removeClass("on")
        //     .eq(index).addClass("on");
        var adWidth = $("#scrollPics>ul li:first").width();
        $(".slider").stop(true, false).animate({
            "marginLeft": -adWidth * index + "px"    //改变 marginTop 属性的值达到轮播的效果
        }, 1200);
        $(".num li").removeClass("on")
            .eq(index).addClass("on");
    }
}
/**
 * 从sessionStorage中取出页面数据
 */
function loadPageDate(){
	$.post("inDis_init",function(data){
		if (data.statusCode==1) {//请求成功
			initPageDate(data.contactUs[0]);
		}
	},"json");
};

function initPageDate(c){
	var info="<h1 class='contact-title'>联系我们</h1>";
	var articleSynopsis=c.articleSynopsis.split(",");
	for ( var i = 0; i < articleSynopsis.length; i++) {
		info+="<p>"+articleSynopsis[i]+"</p>";
	}
	$("#contactUs").html(info);
	
	//加载联系人图片
	var imgUrls=c.articleSynopsisImg.split(",");
	var href="artD/page/2-6.html";
	var imgs="";
	var select="";
	for ( var i = 0; i < imgUrls.length-1; i++) {
		imgs+=" <a href="+href+"><li><img src='http://"+imgUrls[i]+"'></li></a>";
		if (i==0) {
			select+="<a href="+href+"><li class='on'>1</li></a>";
		}else {
			select+="<a href="+href+"><li>"+(i+1)+"</li></a>";
		}
	}
	$("#contactUsImgs").html(imgs);
	$("#imgSelect").html(select);
	
	initPageTool();
};