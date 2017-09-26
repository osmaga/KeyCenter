/**
 * 
 */
package co.pragma.nuevosnegocios.keycenter.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.pragma.nuevosnegocios.keycenter.business.DoorHandlerHelper;
import co.pragma.nuevosnegocios.keycenter.to.Door;

/**
 * @author osmaga
 *
 */
@Path("/doorHandler")
@Produces(MediaType.APPLICATION_JSON)
public class DoorHandler {
	
	@Path("/listDoors")
    @GET
    public Response listDoors() {
		List<Door> result = DoorHandlerHelper.listDoors();
		return Response.ok(result).build();
	}
	
	@Path("/openDoor")
    @GET
    public Response openDoor(@QueryParam("doorID") String doorID, @QueryParam("doorPassword") String doorPassword) {
		boolean result = DoorHandlerHelper.doorOpener(doorID, doorPassword);
		return Response.ok(result).build();
	}
	
	@Path("/closeDoor")
    @GET
    public Response closeDoor(@QueryParam("doorID") String doorID, @QueryParam("doorPassword") String doorPassword) {
		boolean result = DoorHandlerHelper.doorCloser(doorID, doorPassword);
		return Response.ok(result).build();
	}
}
