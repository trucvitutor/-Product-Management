package com.example.product_management.controler;

import com.example.product_management.model.Product;
import com.example.product_management.model.service.IProductService;
import com.example.product_management.model.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", urlPatterns = "/product")
public class ProductController extends HttpServlet {
    private static final IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? " " : action;
        switch (action) {
            case "create":
                showFormCreate(req, resp);
                break;
            default:
                showAllProduct(req, resp);
                break;

        }
    }

    private static void showAllProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
//        lay du lieu
        List<Product> c = productService.findAll();
        //        gan lai du lieu cho view
        req.setAttribute("product", c);

        dispatcher.forward(req, resp);
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("create.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "create":
                createNewProduct(req, resp);
                break;
        }
    }

    private void createNewProduct(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String nameProduct = req.getParameter("name");
        String priceProduct = req.getParameter("price");
        String describeProduct = req.getParameter("describe");
        String producer = req.getParameter("producer");
        Product product = new Product(id, nameProduct, priceProduct, describeProduct, producer);
        productService.save(product);
        try {
            resp.sendRedirect("/product");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
