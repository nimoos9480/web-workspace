package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ModelAndView;
import model.Item;
import model.ItemDAO;

public class ItemViewController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemId = Integer.parseInt(request.getParameter("itemId"));        
        Item item = ItemDAO.getInstance().getItem(itemId);
        if(item!=null) {
        	request.setAttribute("item", item);
        }
		
		return new ModelAndView("itemView.jsp");
	}

}
