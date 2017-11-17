package pe.com.houseclic.controllers;

        import pe.com.houseclic.models.District;
        import pe.com.houseclic.services.HouseClicService;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.util.List;

@javax.servlet.annotation.WebServlet(name = "DistrictsController", urlPatterns = "/Districts")
public class DistrictsController extends javax.servlet.http.HttpServlet {
    HouseClicService service;
    String url;

    public DistrictsController() {
        super();
        service = new HouseClicService();
        url = "";
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest("POST", request, response);
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest("GET", request, response);
    }

    private void processRequest(String method,
                                HttpServletRequest request,
                                HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        String action = request.getParameter("action");
        if(method.equals("GET")) {
            // action == index
            if(action.equals("index")) {
                List<District> districts = service.findAllDistricts();
                request.setAttribute("districts", districts);
                url = "listDistrict.jsp";
            }
            //action == show
            if(action.equals("show")) {
                District district = service.findDistrictById(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("district", district);
                url = "showDistrict.jsp";
            }
            // action == new
            if(action.equals("new")) {
                url = "newDistrict.jsp";
            }
            // action == edit
            if(action.equals("edit")) {
                District district = service.findDistrictById(
                        Integer.parseInt(
                                request.getParameter("id")));
                request.setAttribute("district", district);
                url = "editDistrict.jsp";
            }
        }
        if(method.equals("POST")) {
            // action == create
            if(action.equals("create")) {
                String name = request.getParameter("name");
                District district = service.createDistrict(name);
                request.setAttribute("districts", service.findAllDistricts());
                url = "listDistricts.jsp";
            }
            // action == update
            if(action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                boolean isUpdated = service.updateDistrict(new District(id, name));
                request.setAttribute("districts", service.findAllDistricts());
                url = "listDistricts.jsp";
            }

        }

        request.getRequestDispatcher(url).forward(request, response);
    }

}