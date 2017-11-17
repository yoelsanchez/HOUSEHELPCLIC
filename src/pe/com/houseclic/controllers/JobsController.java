package pe.com.houseclic.controllers;

            import pe.com.houseclic.models.Job;
            import pe.com.houseclic.services.HouseClicService;

            import javax.servlet.http.HttpServletRequest;
            import javax.servlet.http.HttpServletResponse;
            import java.io.IOException;
            import java.util.List;

@javax.servlet.annotation.WebServlet(name = "JobsController", urlPatterns = "/Jobs")
public class JobsController extends javax.servlet.http.HttpServlet {
    HouseClicService service;
    String url;

    public JobsController() {
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
                List<Job> jobs = service.findAllJobs();
                request.setAttribute("jobs", jobs);
                url = "listJob.jsp";
            }
            //action == show
            if(action.equals("show")) {
                Job job = service.findJobById(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("job", job);
                url = "showJob.jsp";
            }
            // action == new
            if(action.equals("new")) {
                url = "newJob.jsp";
            }
            // action == edit
            if(action.equals("edit")) {
                Job job = service.findJobById(
                        Integer.parseInt(
                                request.getParameter("id")));
                request.setAttribute("job", job);
                url = "editjob.jsp";
            }
        }
        if(method.equals("POST")) {
            // action == create
            if(action.equals("create")) {
                String name = request.getParameter("name");
                Job job = service.createJob(name);
                request.setAttribute("jobs", service.findAllJobs());
                url = "listJobs.jsp";
            }
            // action == update
            if(action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                boolean isUpdated = service.updateJob(new Job(id, name));
                request.setAttribute("jobs", service.findAllJobs());
                url = "listJobs.jsp";
            }

        }

        request.getRequestDispatcher(url).forward(request, response);
    }

}