package resources;
import domain.Patient;
import services.PatientFunctionService;
import domain.Person;
import com.google.gson.Gson;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/patient")
public class PatientResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPatients() throws ClassNotFoundException{
        try {

            String patients = new Gson().toJson(PatientFunctionService.getAllPatients());
            return Response.ok(patients, MediaType.APPLICATION_JSON).build().toString();
        } catch (ClassNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build().toString();
        }
    }
}
