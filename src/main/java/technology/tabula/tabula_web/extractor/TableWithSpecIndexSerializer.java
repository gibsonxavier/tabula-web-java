package technology.tabula.tabula_web.extractor;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import technology.tabula.json.TableSerializer;
import technology.tabula.tabula_web.background.JobExecutor;

public class TableWithSpecIndexSerializer implements JsonSerializer<TableWithSpecIndex>  {
	
	final static Logger logger = LoggerFactory.getLogger(JobExecutor.class);
	int specIndex;

	public JsonElement serialize(TableWithSpecIndex tableWithSpecIndex, Type type,
            JsonSerializationContext context) {
		
		TableSerializer s = TableSerializer.INSTANCE;
		
		JsonObject o = (JsonObject) s.serialize(tableWithSpecIndex.table, type, context);
		o.addProperty("spec_index", specIndex);
		
		return o;
	
	}
}