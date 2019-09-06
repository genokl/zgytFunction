//var params={};
/**
 * 头部页面
 */
$(function(){
	var type_id=getUrlArgObject("type_id");
	var listUrl=getUrlArgObject("listUrl");
	var listTitle=getUrlArgObject("listTitle");
	//number: 0, size 20, sort: null
	$(".productType").val(type_id)
	
	var param=preListParam(type_id)
	loadListData(listUrl,param)
	
	var pagehref=$(".pagehref");
//	pagehref.attr("href","/jump/p?name=productList&type_id="+type_id+"&listUrl="+listUrl);
	pagehref.attr("href",genJumpListUrl(type_id,listUrl));
	pagehref.html(currentProductTypeName());
	$(".bannerImg").attr("src",setSynoBannerImg(type_id))
});

function preListParam(){
	var p={};
	p["productType"]=$(".productType").val()
	p["page"]=$(".page").val()
	p["size"]=$(".size").val()
	return p;
}

function loadListData(listUrl,params){
	$(".productList").html("");
	if(notNull(params["productType"])){
		$.post(listUrl,params,function(d){
			initListData(d)
			if(d.page.number==0){
				initPagination(d,params["size"])
			}
		},"json")
	}
}
/**
 * 初始化列表数据
 * @param d
 * @returns
 */
function initListData(d){
	var ps=d["_embedded"]["products"]
	var info="";
	info+="<ul>";
	var type_id=$("#titlelist li.current>a").attr("data-id");
		
	for (var i = 0; i < ps.length; i++) {
		var url="";
//		console.log(ps)
		if(ps[i]["_links"]!=null){
			url=ps[i]["_links"]["_self"]["href"];
		}
		info+="<li>"
//		info+=	"<a href='/jump/p?name=productInfo&dataUrl="+encodeURIComponent(url)+"&type_id="+type_id+"'>"//url
        info+=	"<a href='"+genJumpInfoUrl(type_id,url)+"'>"//url
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


//分页
initPagination=function(data,pageCount){
	//分页
	var page=data["page"]
//	console.log(data.page)
	if(notNull(data._embedded.products.length)){
		paginationInfo = {
							pageCount:page.totalPages,//总页数
							pageNumber:page.size,//每页显示数
							currPage:page.number+1
						  };
        $("#pagination").myPagination({
            cssStyle:'flickr',//配置样式属性
            pageCount:page.totalPages,//配置总页数
            pageNumber:10,//显示页码数量
            currPage:paginationInfo.currPage,//配置当前页
            first_on:true,//配置首页是否显示
            last_on:true,//配置尾页是否显示
            first:"首页",//配置首页显示值
            last:"尾页",//配置尾页显示值
            panel:{
                tipInfo_on:true,//配置提示信息
                tipInfo:'转{input}/{sumPage}页',//配置提示信息
                tipInfo_css:{//配置面板中国输入框样式
                    width:'25px',
                    height:'25px',
                    border:"1px solid #ff9600",
                    padding:"0px 0px 0px 5px",
                    margin:"0px 5px 0px 5px",
                    color:"#000",
                    "box-sizing":"border-box",
                    "-moz-box-sizing":"border-box"
                }
            },
         ajax:{
                on:false,
                onClick:function(page){
                	$(".page").val(page-1)
                	var p=preListParam();
//                	console.log(p)
                	var listUrl=getUrlArgObject("listUrl");
                	loadListData(listUrl, p)
//                
                }
            }
        });
	}
               
};
