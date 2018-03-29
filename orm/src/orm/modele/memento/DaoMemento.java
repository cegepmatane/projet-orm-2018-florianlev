package orm.modele.memento;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DaoMemento {
	public DaoMemento()
	{
		
	}
	public void sauvegarder(MementoPlanete memento)// sauvegarde de memento individuel sur disque
	{
		String chemin = memento.planete.getNom() + memento.version +".xml";
		String xml = "<memento><version>" + memento.version + "</version><planete><nom>" + memento.planete.getNom() + "</nom></planete></memento>";
		FileOutputStream flux = null;
		try {
			flux = new FileOutputStream(chemin);
			flux.write(xml.getBytes());
			flux.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
