package resources;
import domain.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DBTablesService;
import services.PatientFunctionService;
import domain.Person;
import com.google.gson.Gson;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/patient")
public class PatientResource {
    private final Logger logger = LogManager.getLogger(PatientResource.class.getName());
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPatients() throws ClassNotFoundException{
        try {
            return new Gson().toJson(PatientFunctionService.getAllPatients());
//            String patients = new Gson().toJson(PatientFunctionService.getAllPatients());
//            logger.info("Patients Retrieved");
//            return Response.ok("Hello", MediaType.APPLICATION_JSON).build().toString();
        } catch (ClassNotFoundException e) {
//            logger.error();
            return Response.status(Response.Status.NOT_FOUND).build().toString();
        }
    }
}
