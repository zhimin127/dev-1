package com.my.common.controller;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.my.common.service.CommonService;

@RestController
public class ApplicationController {

	@Autowired
	private CommonService commonService;
	@Autowired
	private Producer captchaProducer;

	private Map<String, Object> result;
	private List<?> list;

	@RequestMapping("constant/{id}/{code}")
	public List<?> getConstant(@PathVariable int id, @PathVariable String code) {
		switch (id) {
		case 0:
			break;
		case 110000:
			//list = commonService.getProvinces();
			break;
		case 110001:
			//list = commonService.getCityByFatherId(code);
			break;
		case 110002:
			//list = commonService.getDistrictByFatherId(code);
			break;
		case 100:
			//list = commonService.getDateSection();
			break;
		case 200:
			//list = commonService.getCostType();
			break;
		default:
			break;
		}
		return list;
	}

	/**
	 * Google 验证码生成方法
	 * 
	 * @param request
	 * @param response
	 * @return null
	 * @throws Exception
	 */
	@RequestMapping("images/captcha-image.jpg")
	public ModelAndView captchaImage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setDateHeader("Expires", 0);
		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control",
				"no-store, no-cache, must-revalidate");
		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");
		// return a jpeg
		response.setContentType("image/jpeg");
		// create the text for the image
		String capText = captchaProducer.createText();
		// store the text in the session
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY,
				capText);
		// create the image with the text
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		// write the data out
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
		return null;
	}

	/**
	 * 异步验证码校验方法
	 */
	@RequestMapping("images/{code}")
	public Map<String, Object> validteCode(@PathVariable String code,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		result = new HashMap<String, Object>();
		//
		String vcode = (String) request.getSession().getAttribute(
				Constants.KAPTCHA_SESSION_KEY);
		//
		String resulCode = "E001";
		if (code != null && vcode != null && vcode.equalsIgnoreCase(code)) {
			resulCode = "S001";
		}
		result.put("code", resulCode);
		return result;
	}

	@RequestMapping("error/{code}")
	public ModelAndView errorPage(Model model, @PathVariable String code) {
		model.addAttribute("code", code);
		return new ModelAndView("error");
	}

	@RequestMapping("timeout")
	public ModelAndView sessionTimeOutPage(Model model) {
		//model.addAttribute("code", code);
		return new ModelAndView("timeout");
	}
}
