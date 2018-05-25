package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

import ssm.service.ProductService;

@Controller
public class AlipayController {

	@Autowired
	private AlipayClient alipayClient;
	
	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.POST, value = "/alipay/pay", produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String pay() throws AlipayApiException {
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
		alipayRequest.setReturnUrl("http://paytest.utb.me/alipay/cb/sync"); // 当前端页面完成了支付跳转回商户的地址
		alipayRequest.setNotifyUrl("http://paytest.utb.me/alipay/cb/async");// 当支付宝服务端确认支付完成时通知的地址

		// 填充业务参数
		alipayRequest.setBizContent("{" +
		// 商户订单号
				"    \"out_trade_no\":\"10000\"," +
				// 销售产品码,固定
				"    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
				// 订单总额
				"    \"total_amount\": 0.01," +
				// 订单概要
				"    \"subject\":\"Iphone6 16G\"," +
				// 订单描述(可选)
				"    \"body\":\"Iphone6 16G\"" + "  }");

		String form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单(用于用户支付的页面html)
		System.out.println("------------------");
		System.out.println(form);
		System.out.println("------------------");
		return form;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/alipay/cb/sync")
	public String payOk(@RequestParam(name = "out_trade_no") Integer productId) {
		// 当前端支付结束后，浏览器被支付宝跳回到该页面
		return "pay-ok";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/alipay/cb/async")
	@ResponseBody // 响应内容应该是text/plain
	public String payOkAsync(@RequestParam(name = "out_trade_no") Integer productId) {
		// 支付宝系统发给商户的支付结果异步通知，以此为准
		// 应该把该订单的状态改为"已支付"
		
//		productService.paySuccess(productId);
		
		return "success";
	}

}
