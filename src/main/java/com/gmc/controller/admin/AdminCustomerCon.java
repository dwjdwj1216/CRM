//package com.gmc.controller.admin;
//
//import com.gmc.service.CustomerManageSrv;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.http.HttpSession;
//import java.util.List;
//
///**
// * Created by 顾梦超 on 2016/5/21.
// */
//@Controller
//public class AdminCustomerCon {
//    @Autowired
//    private CustomerManageSrv customerSrv;
//    @Autowired
//    private ContactRecordSrv contactRecordSrv;
//    @RequestMapping(value = "/admin/getCustomerList/{group}/{state}/{index}",method = RequestMethod.GET)
//    public String getClientList(@PathVariable String group, @PathVariable int index , @PathVariable String state, Model model, HttpSession session){
//
//        String account_Prefix= (String) session.getAttribute("account_Prefix");
//        System.out.println(account_Prefix);
//        int count = customerSrv.saleOrAdminGetCount(group,state,account_Prefix);
//        List<Customer> customers=customerSrv.adminOrSaleGetCustomerList(index,group,state,account_Prefix);
//        System.out.println(customers.size());
//        model.addAttribute("group",group);
//        if(count%15==0)
//            count=count/15;
//        else count=count/15+1;
//        model.addAttribute("page",index);
//        model.addAttribute("state",state);
//        model.addAttribute("customers",customers);
//        model.addAttribute("count",count);
//        return "/admin/customerList";
//    }
//    @RequestMapping(value="/admin/editCustomer/{id}",method = RequestMethod.GET)
//    public String updatecustomer(Model model,@PathVariable String id) {
//        model.addAttribute("customer",customerSrv.getMoreInfo(id));
//        model.addAttribute("customerNumber",id);
//        model.addAttribute("customers",new Customer());
//        return "/admin/editCustomer";
//    }
//
//
//    @RequestMapping(value="/admin/editCustomer/{customerID}",method = RequestMethod.POST)
//    public String updateCustomer(@PathVariable String customerID,Customer customers,Model model){
//        if(customerSrv.adminUpdateCustomer(customerID,customers)){
//            model.addAttribute("result", "<script type=\"text/javascript\">\n" +
//                    "    alert(\"修改成功\");\n" +
//                    "</script>");
//        }
//        else {
//            model.addAttribute("result", "<script type=\"text/javascript\">\n" +
//                    "    alert(\"修改失败\");\n" +
//                    "</script>");
//        }
//        model.addAttribute("url","/admin/editCustomer/"+customerID);
//        return "/redirect";
//    }
//    @RequestMapping(value = "/admin/fuzzyqueryCustomer", method = RequestMethod.POST)
//    public String fuzzyQuery(String find, Model model,HttpSession session) {
//        String account_Prefix = (String) session.getAttribute("account_Prefix");
//        List<Customer> customers=customerSrv.adminOrSalefuzzyQuery(find,account_Prefix);
//        int t=customers.size();
//        model.addAttribute("customers",customers);
//        model.addAttribute("page",1);
//        return "/admin/customerList";
//    }
//    @RequestMapping(value="/admin/moreinfo/{customerID}",method = RequestMethod.GET)
//    public String getMoreInfo(@PathVariable String customerID,Model model){
//        System.out.println("--------------");
//        System.out.println(customerID);
//        Customer customer =customerSrv.getMoreInfo(customerID);
//        List<CustomerContactRecord> records = contactRecordSrv.getrecentContactRecordByCustomerID(customerID);
//        List<ProductSale> productSales = contactRecordSrv.getRecentProductSale(customerID);
//        model.addAttribute("records",records);
//        model.addAttribute("productSales",productSales);
//        model.addAttribute("customer",customer);
//        return "/admin/customerInfo";
//    }
//
//}
