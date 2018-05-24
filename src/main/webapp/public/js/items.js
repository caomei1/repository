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
	  $(".text_box[name='"+id+"']").val(Math.abs(parseInt( $(".text_box[name='"+id+"']").val()))+1);
	  /* t.val(Math.abs(parseInt(t.val()))+1); */
	  if (parseInt(t.val())!=1){
	  $('.min1').attr('disabled',false);
	  };
	 }) 
	 //数量减少操作
	 $(".min1").click(function(){
	  var id = $(this).attr("name");
	/*  t.val(Math.abs(parseInt(t.val()))-1); */
	 if (parseInt($(".text_box[name='"+id+"']").val())<=2){
	 $(".min1[name='"+id+"']").attr('disabled',true);
	 };if (parseInt($(".text_box[name='"+id+"']").val())>=2){
	   $(".text_box[name='"+id+"']").val(Math.abs(parseInt( $(".text_box[name='"+id+"']").val()))-1);
	 }
	 })
	});