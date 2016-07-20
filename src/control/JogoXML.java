package control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import model.Carta;

public class JogoXML {
	public static void escreveXML(ArrayList<Carta> cartas,String tipo){
		Element memoria = new Element("memoria");
		Document doc = new Document(memoria);
		for(Carta c : cartas){
			Element carta = new Element("carta");
			carta.setAttribute("tipo", tipo);
			Element conteudo = new Element("Conteudo");
			conteudo.setText(c.getConteudo());
			carta.addContent(conteudo);
			Element face = new Element("face");
			face.setText(c.getFaceLocal());
			carta.addContent(face);
			memoria.addContent(carta);
		}
		XMLOutputter xout = new XMLOutputter();
		OutputStream out = null;
		try {
			out = new FileOutputStream(new File(tipo+".xml"));
			xout.output(doc, out);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static List<Element> lerXML(String tipo){
		Document doc = null;
		SAXBuilder builder = new SAXBuilder();
		try {
			doc = builder.build(tipo+".xml");

		} catch (Exception e) {
			e.printStackTrace();
		}
		Element root = doc.getRootElement();
		List<Element> memoria = root.getChildren();
		return memoria;
	} 
}
