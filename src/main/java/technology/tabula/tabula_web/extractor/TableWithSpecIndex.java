package technology.tabula.tabula_web.extractor;

import technology.tabula.extractors.ExtractionAlgorithm;
import technology.tabula.Table;


@SuppressWarnings({"serial" })
public class TableWithSpecIndex extends Table{
	
	public int specIndex;
	public Table table;
	
	
	public TableWithSpecIndex(Table t, int specIndex, ExtractionAlgorithm extractionAlgorithm) {
		super(extractionAlgorithm);
		this.specIndex = specIndex;
		this.table = t;
	}

	public int getSpecindex() {
		return (int) this.specIndex;
	}
}