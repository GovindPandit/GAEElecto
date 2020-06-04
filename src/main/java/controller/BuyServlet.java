package controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.instamojo.wrapper.api.ApiContext;
import com.instamojo.wrapper.api.Instamojo;
import com.instamojo.wrapper.api.InstamojoImpl;
import com.instamojo.wrapper.model.PaymentOrder;
import com.instamojo.wrapper.model.PaymentOrderResponse;

import model.User;


public class BuyServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession hs=req.getSession();
		User user=(User)hs.getAttribute("user");
		
		
		 try 
	       {
	           ApiContext context = ApiContext.create("test_R8ziKdSBaVxv4plvOaZM10efcCTIDrNTvw2", "test_o7e942tK6lVlNR2zI3bEx8RSGnhIo8ZraIdEzwOHIS97AkR9BlmIFJMREqiSvLSBemw1gL20E3SAqnMdhAqTYOomRrRxyfTJyOf7RdbWJ6ZE3JOqfjd9167PrL5", ApiContext.Mode.TEST);
	           Instamojo api = new InstamojoImpl(context);

	           PaymentOrder order = new PaymentOrder();
	           order.setName(user.getUsername());
	           order.setEmail(user.getEmail());
	           order.setPhone("7977518582");
	           order.setCurrency("INR");
	           order.setAmount((double)11);
	           order.setDescription("Hello World");
	           order.setRedirectUrl("https://www.google.com");
	           order.setWebhookUrl("https://www.google.com");
	           order.setTransactionId(UUID.randomUUID().toString());

	           PaymentOrderResponse paymentOrderResponse = api.createPaymentOrder(order);
	           resp.sendRedirect(paymentOrderResponse.getPaymentOptions().getPaymentUrl());
	       }
	       catch (Exception e) 
	       {
	           System.out.println(e);
	       }
	}
}
