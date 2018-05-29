//全选框
function checkAll(checkall) {
	arr = document.getElementsByName('id');
	if (checkall.checked == true) {
		for (i = 0; i < arr.length; i++) {

			arr[i].checked = true;
		}

	} else {
		for (i = 0; i < arr.length; i++) {
			if ((arr[i]).checked == false) {
				arr[i].checked = true;
			} else {
				arr[i].checked = false;
			}
		}
	}
}

//购物车数量加减
$(function(){
/*	// 获取meta中的csrf token
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	// 将token作为请求头发送
	var headers = {};
	headers[header] = token;*/
	$(".jian").click(function(){
		var id1 = $(this).attr("name");
		if ($(".shuliang[aa='"+id1+"']").val() >1 ) {
			console.log($(".shuliang[aa='"+id1+"']").val()-1);
			$.ajax({			
				url:"/MobileShopping/reduceCar",
				type:"GET",
				data:{id:id1,quantity:$(".shuliang[aa='"+id1+"']").val()},
				success:function(car){
//					console.log($("strong.red[name='"+id1+"']")[0]);	
//				if(!car){
//						$(".car"+id1).remove();
//					}else{
//						console.log($(".shuliang").val());
//						console.log(parseInt(($("strong.red[name='"+id1+"']")[0].innerHTML).substr(1)));
//						console.log($("."+id1+"").val());
						
						$(".shuliang[aa='"+id1+"']").val(car.quantity);
						$("strong.red[name='"+id1+"']")[0].innerHTML="￥"+(car.product.price * car.quantity).toFixed(1);
						$("strong.red[name='all']")[0].innerHTML="￥"+(parseInt(($("strong.red[name='all']")[0].innerHTML).substr(1))-car.product.price).toFixed(1);
//					}
				},
			});
			return false;
		} else {
			alert('数量最小为1!');
			return true;
		}
		
	});
	
	$(".jia").click(function(){
		var id1 = $(this).attr("name");
	    $.ajax({
			url:"/MobileShopping/addCar",
			type:"GET",
			data:{id:id1,goodscount:$(".shuliang[aa='"+id1+"']").val()},
		success:function(car){
			/*console.log(carStr);
			console.log($(".shuliang[name='"+id1+"']"));
			console.log($("strong.red[name='"+id1+"']")[0]);*/
		$(".shuliang[aa='"+id1+"']").val(car.quantity);
		$("strong.red[name='"+id1+"']")[0].innerHTML="￥"+(car.product.price * car.quantity).toFixed(1);
		$("strong.red[name='all']")[0].innerHTML="￥"+(parseInt(($("strong.red[name='all']")[0].innerHTML).substr(1))+parseInt(car.product.price)).toFixed(1);
					}
				});
		});
	 
//批量删除
$('#batch-delete-btn').click(function() {
	console.log('batch delete...');
	var checkedProdIds = $('input[type=checkbox][name=id]')
	.filter(function() {
		return this.checked;
		});
	console.log('checkedProdIds', checkedProdIds); 		
	 	 
	 	if (checkedProdIds.length > 0) {
	 		$('#batch-delete-form').append(checkedProdIds).submit();
	 		}
	 	});	 

//表单必须选地址和商品才能提交
$('#Immediate-settlement').submit(function() {
	if ($('input[name=addressId]:checked', this).val() && 
			$('input[name=id]:checked', this).val()) {
		return true;
	} else if ($('input[name=addressId]:checked', this).val()) {
		alert('请选择要购买的商品');
		return false;
	} else if ($('input[name=id]:checked', this).val()) {
		alert('请选择收货地址');
		return false;
	} else {
		alert('请选择收货地址和商品');
		return false;
	}
});

//把商品当前的数量传入购物车
$(".buy-gou").click(function(){
	var shuliang = $("#qty_item_1").val();
	var aURL = $(this).attr("href");
	console.log(aURL);
	console.log(shuliang);
	$(this).attr("href",aURL+"/"+shuliang);
});


});


