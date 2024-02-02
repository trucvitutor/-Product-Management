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
    private final IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? " " : action;
        switch (action) {
            case "create":
                showFormCreate(req, resp);
                break;
            case "delete":
                showDelete(req, resp);
                break;
            case "update":
                showUpdate(req,resp);
                break;
            case "search":
                showSearch(req,resp);
                break;
            default:
                showAllProduct(req, resp);
                break;


        }
    }

    private void showSearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("nameProduct");
        List<Product> product=productService.findByName(name);
        req.setAttribute("product", product);
        req.getRequestDispatcher("index.jsp").forward(req,resp);

    }

    private void showUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        Product product = this.productService.findById(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("update.jsp").forward(req,resp);
    }

    private void showDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product product = this.productService.findById(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("confirm-delete.jsp").forward(req, resp);
    }

    private void showAllProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "create":
                createNewProduct(req, resp);
                break;
            case "delete":
                deleteProduct(req, resp);
                break;
            case "update":
                UpdateProduct(req,resp);
                break;
        }
    }

    private void UpdateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      String id=req.getParameter("id");
        String nameProduct = req.getParameter("nameProduct");
        String priceProduct = req.getParameter("priceProduct");
        String describeProduct = req.getParameter("describeProduct");
        String producer = req.getParameter("producer");
        Product product = new Product(id,nameProduct, priceProduct, describeProduct, producer);
        productService.updateProduct(product);
        resp.sendRedirect("/product");
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        this.productService.deleteProduct(id);
        resp.sendRedirect("/product");
    }


    private void createNewProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String nameProduct = req.getParameter("nameProduct");
        String priceProduct = req.getParameter("priceProduct");
        String describeProduct = req.getParameter("describeProduct");
        String producer = req.getParameter("producer");
        Product product = new Product(id, nameProduct, priceProduct, describeProduct, producer);
        productService.save(product);
        resp.sendRedirect("/product");
    }

}
