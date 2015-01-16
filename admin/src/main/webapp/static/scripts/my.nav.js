$(function () {
	getMenus();
	initMacSidebar();
	//initLeftMenu();
})
var _menus = null;
// 获得菜单
function getMenus(){
	$.ajax({
		url : "menu",
		type : "post",
		async : false,
		success : function(data) {
			data = eval('(' + data + ')');
			_menus = data.menus[0];
		}
	});
}
// 初始化左侧
function initMacSidebar(){
	sidebar = jQuery(".sidebar");
	if (typeof _menus != 'undefined') {
		var title = "<div class='sidebar-dropdown'><a href='#'>" + _menus.name + "</a></div>";
		var nav = '<ul id="nav">'
		jQuery.each(_menus.subMenu, function(i, n) {
			var menu = '<li class="' + n.style + '">';
			if (n.url == null || n.url == '') {
				menu += n.name;
			} else {
				if(n.url=="#") n.url = 'javascript:void(0);'
				var _class = '';
				if(typeof menuPos != 'undefined' && i == menuPos){
					_class = ' class="open"'
				}
				menu += '<a href="' + n.url + '"'+_class+'>';
				if (n.icon != null && n.icon != '') {
					menu += '<i class="' + n.icon + '"></i>';
				}
				menu +=  n.name + '';
			}
			var subMenu = '</a>';
			if (n.subMenu.length > 0) {
				subMenu = '<span class="pull-right"><i class="icon-chevron-right"></i></span></a>';
				if(typeof subMenuPos != 'undefined' && i == menuPos){
					subMenu += '<ul style="display: block;">';
				}else{
					subMenu += '<ul>'
				}
				jQuery.each(n.subMenu, function(j, o) {
					subMenu += '<li><a ref="' + o.id + '" href="' + o.url + '" rel="" ><span class="">' + o.name + '</span></a></li>';
				})
				subMenu += '</ul>';
			}
			//
			nav += menu + subMenu + '</li>';
		});
		nav += '</ul>'
		sidebar.html(title+nav);
		
	}
	// 选中第一个
}

function initLeftMenu() {
	// jQuery(".leftmenu").html("");
	// init menu

	if (typeof _menus != 'undefined') {
		var nav = '<ul class="nav nav-tabs nav-stacked">';
		nav += '<li class="' + _menus.style + '">' + _menus.name + '</li>';
		jQuery.each(_menus.subMenu, function(i, n) {
			var menu = '<li class="' + n.style + '">';
			if (n.url == null || n.url == '') {
				menu += n.name;
			} else {
				menu += '<a href="' + n.url + '">';
				if (n.icon != null && n.icon != '') {
					menu += '<span class="' + n.icon + '"></span>';
				}
				menu+=  n.name + '</a>'
			}

			var subMenu = '';
			if (n.subMenu.length > 0) {
				subMenu += '<ul>';
				jQuery.each(n.subMenu, function(j, o) {
					subMenu += '<li><div><a ref="' + o.id + '" href="#" rel="' + o.url + '" ><span class="">' + o.name + '</span></a></div></li>';
				})
				subMenu += '</ul>';
			}
			//
			nav += menu + subMenu + '</li>';
		});
		nav += '</ul>'
		jQuery('.leftmenu').html(nav);
	}

	jQuery('.leftmenu li a').click(function() {
		// var tabTitle = jQuery(this).children('.nav').text();
		var subMenu = jQuery(this).parent().children('ul');
		if (typeof subMenu == 'undefined') {

			var url = jQuery(this).attr("rel");
			var menuid = jQuery(this).attr("ref");
			var icon = getIcon(menuid, icon);

			// addTab(tabTitle, url, icon);
			jQuery('.leftmenu li div').removeClass("selected");
			jQuery(this).parent().addClass("selected");
		} else {
			jQuery(this).next("ul").slideToggle().siblings("ul").slideUp();
			// subMenu.show();
		}
	}).hover(function() {
		// jQuery(this).parent().addClass("hover");
	}, function() {
		// jQuery(this).parent().removeClass("hover");
	});
	// 选中第一个
}

// 弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function msgShow(title, msgString, msgType) {
	$.messager.alert(title, msgString, msgType);
}
