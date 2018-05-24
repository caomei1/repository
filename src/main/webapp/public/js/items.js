//全选框
function checkAll(checkall) {
	arr = document.getElementsByName('productId');
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


//数量加减
$(document).ready(function(){
	//获得文本框对象
	var t = $("#text_box");
	//初始化数量,并失效减
	/* $('.min1').attr('disabled',true); */
	 //数量增加操作
	 $(".add1").click(function(){ 
	  // 给获取的val加上绝对值，避免出现负数
	  var id = $(this).attr("name");
	  $(".text_box[aa='"+id+"']").val(Math.abs(parseInt( $(".text_box[aa='"+id+"']").val()))+1);
	  /* t.val(Math.abs(parseInt(t.val()))+1); */
	  if (parseInt(t.val())!=1){
	  $('.min1').attr('disabled',false);
	  };
	 }) 
	 //数量减少操作
	 $(".min1").click(function(){
	  var id = $(this).attr("name");
	/*  t.val(Math.abs(parseInt(t.val()))-1); */
	 if (parseInt($(".text_box[aa='"+id+"']").val())<=2){
	 $(".min1[name='"+id+"']").attr('disabled',true);
	 };if (parseInt($(".text_box[aa='"+id+"']").val())>=2){
	   $(".text_box[aa='"+id+"']").val(Math.abs(parseInt( $(".text_box[aa='"+id+"']").val()))-1);
	 }
	 })
	 
//批量删除
$('#batch-delete-btn').click(function() {
	console.log('batch delete...');
	var checkedProdIds = $('input[type=checkbox][name=productId]')
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
			$('input[name=productId]:checked', this).val()) {
		return true;
	} else if ($('input[name=addressId]:checked', this).val()) {
		alert('请选择要购买的商品');
		return false;
	} else if ($('input[name=productId]:checked', this).val()) {
		alert('请选择收货地址');
		return false;
	} else {
		alert('请选择收货地址和商品');
		return false;
	}
});



});
