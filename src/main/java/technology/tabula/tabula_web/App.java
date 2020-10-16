package technology.tabula.tabula_web;
import static spark.Spark.*;

import java.io.IOException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import technology.tabula.tabula_web.routes.IndexRouteGroup;
import technology.tabula.tabula_web.routes.JobProgressRouteGroup;
import technology.tabula.tabula_web.routes.PdfRouteGroup;
import technology.tabula.tabula_web.routes.PdfsRouteGroup;
import technology.tabula.tabula_web.workspace.WorkspaceDAO;
import technology.tabula.tabula_web.workspace.FileWorkspaceDAO;
import technology.tabula.tabula_web.workspace.WorkspaceException;
//import static spark.debug.DebugScreen.enableDebugScreen;

public class App {

	private static final String VERSION = "1.2.1 Release (1.2.1.18052200)";
	
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, IOException, WorkspaceException {
		exception(Exception.class, (e, req, res) -> e.printStackTrace());
		staticFiles.location("/public/");
		port(8080);
		//enableDebugScreen();
		//RouteOverview.enableRouteOverview();
		
		WorkspaceDAO workspaceDAO = new FileWorkspaceDAO(Settings.getDataDir());
		
	    path("/", new IndexRouteGroup(workspaceDAO));
	    path("/pdfs/", new PdfsRouteGroup(workspaceDAO));
	    path("/pdf/", new PdfRouteGroup(workspaceDAO));
	    path("/queue/", new JobProgressRouteGroup());

	    get("/version", (req, rsp) -> {
			rsp.type("application/json");
			return String.format("{ \"api\": \"%s\" }", VERSION);
		});
	}
}

