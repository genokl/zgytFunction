
/**
 * 头部页面
 */
$(function(){
	var type_id=getUrlArgObject("type_id");
	var listUrl=getUrlArgObject("listUrl");
	var listTitle=getUrlArgObject("listTitle");
	var data={};//number: 0, size 20, sort: null
	data["productType"]=type_id
	data["number"]=0
	data["size"]=10
	loadListData(listUrl,data)
	console.log(listUrl)
	var pagehref=$(".pagehref");
	pagehref.attr("href","/jump/p?name=productList&type_id="+type_id+"&listUrl="+listUrl);
	pagehref.html();
});

function loadListData(listUrl,data){
	if(notNull(data["productType"])){
		$.post(listUrl,data,function(d){
			initListData(d)
		},"json")
	}
}
function initListData(d){
	var ps=d["_embedded"]["products"]
	var info="";
	info+="<ul>";
	var type_id=$("#titlelist li.current>a").attr("data-id");
		
	for (var i = 0; i < ps.length; i++) {
		var url="";
		console.log(ps)
		if(ps[i]["_links"]!=null){
			url=ps[i]["_links"]["_self"]["href"];
		}
		info+="<li>"
//		info+=	"<a href='/jump/p?name=productInfo&dataUrl="+encodeURIComponent(url)+"&type_id="+type_id+"'>"//url
        info+=	"<a href='"+genJumpInfoUrl(url)+"'>"//url
        info+=		"<img src='"+ps[i]["productSynopsisImg"].replace(",","")+"' alt=''>"
		info+=		"<ol>"
		info+=      "<li>"+ps[i]["title"]+"</li>"
        info+=      "<li>"+ps[i]["title"]+"</li>"
        info+=      "<li>"+ps[i]["showDate"]+"</li>"
        info+=      "</ol>"
        info+=    "</a>"
        info+="</li>"
	}
	info+="</ul>"
	$(".productList").append(info)
}
