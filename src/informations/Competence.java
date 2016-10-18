package informations;
import java.io.File;
import java.util.Vector;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe presentant une competence
 * 
 * @author exopole
 *
 */
public class Competence {
	
	/**
	 * Nom de la competence
	 */
	private final StringProperty nom;
	/**
	 * Description de la competence
	 */
	private final StringProperty description;
	/**
	 * Type de la competence
	 */
	private final StringProperty type;
	/**
	 * Nature de la competence
	 */
	private final StringProperty nature;
	/**
	 * Level maximum que peut atteindre la competence
	 */
	private final StringProperty levelMax;
	/**
	 * Temps necessaire a l'incantation de la competence
	 */
	private final StringProperty tempsIncantation;
	/**
	 * Level maximum que peut atteindre la competence
	 */
	private final StringProperty exp;



	
	/**
	 * Constructeur permettant d'instancier toutes les valeurs
	 * @param nom
	 * @param description
	 * @param type
	 * @param nature
	 * @param levelMax
	 * @param tempsIncantation
	 */
	public Competence(String nom, String description, String type, String nature, int levelMax, Double tempsIncantation) {
		this.nom = new SimpleStringProperty(nom);
		this.description = new SimpleStringProperty(description);
		this.type = new SimpleStringProperty(type);
		this.nature = new SimpleStringProperty(nature);
		this.levelMax = new SimpleStringProperty(Integer.toString(levelMax));
		this.tempsIncantation = new SimpleStringProperty(Double.toString(tempsIncantation));
		this.exp = null;
	}
	
	/**
	 * Constructeur permettant d'instancier toutes les valeurs via un chaine de caractere
	 * @param listComp
	 */
	public Competence(String listComp) {
		String[] stringSplit = listComp.split(";");
		nom = new SimpleStringProperty(stringSplit[0]);
		description = new SimpleStringProperty(stringSplit[1]);
		type = new SimpleStringProperty(stringSplit[2]);
		nature = new SimpleStringProperty(stringSplit[3]);
		levelMax = new SimpleStringProperty(stringSplit[4]) ;
		tempsIncantation = new SimpleStringProperty(stringSplit[5]);
		this.exp = null;
	}
	
	
	/**
	 * Constructeur permettant d'instancier toutes les valeurs via un chaine de caractere
	 * @param listComp
	 */
	public Competence(String listComp, int exp) {
		String[] stringSplit = listComp.split(";");
		nom = new SimpleStringProperty(stringSplit[0]);
		description = new SimpleStringProperty(stringSplit[1]);
		type = new SimpleStringProperty(stringSplit[2]);
		nature = new SimpleStringProperty(stringSplit[3]);
		levelMax = new SimpleStringProperty(stringSplit[4]) ;
		tempsIncantation = new SimpleStringProperty(stringSplit[5]);
		this.exp = new SimpleStringProperty(Integer.toString(exp)) ;

	}
	
	/**
	 * Constructeur permettant d'instancier toutes les valeurs via un chaine de caractere
	 * @param listComp
	 */
	public Competence(Competence comp, int exp) {
		nom = comp.nom;
		description = comp.description;
		type = comp.type;
		nature = comp.nature;
		levelMax = comp.levelMax ;
		tempsIncantation = comp.tempsIncantation;
		this.exp = new SimpleStringProperty(Integer.toString(exp)) ;

	}
	

	
	/**
	 * Retourne le nom
	 * @return String
	 */
	public String getNom() {
		return nom.get();
	}
	
	
	public StringProperty getNomProperty() {
		return nom;
	}
	
	/**
	 * Retourne la description de la competence
	 * @return String
	 */
	public String getDescription() {
		return description.get();
	}
	
	/**
	 * Retourne la description de la competence
	 * @return String
	 */
	public StringProperty getDescriptionProperty() {
		return description;
	}

	/**
	 * Retourne le type de la competence
	 * @return String
	 */
	public StringProperty getTypeProperty() {
		return type;
	}
	
	/**
	 * Retourne le type de la competence
	 * @return String
	 */
	public String getType() {
		return type.get();
	}
	
	/**
	 * Retourne la nature de la competence
	 * @return String
	 */
	public StringProperty getNatureProperty() {
		return nature;
	}
	/**
	 * Retourne la nature de la competence
	 * @return String
	 */
	public String getNature() {
		return nature.get();
	}

	/**
	 * Retourne le level max pouvant atteindre la competence
	 * @return int
	 */
	public StringProperty getLevelMaxProperty() {
		return levelMax;
	}
	
	/**
	 * Retourne le level max pouvant atteindre la competence
	 * @return int
	 */
	public int getLevelMax() {
		return Integer.parseInt(levelMax.get());
	}

	/**
	 * @return the exp
	 */
	public StringProperty getExpProperty() {
		return exp;
	}
	

	/**
	 * @return the exp
	 */
	public int getExp() {
		return Integer.parseInt(exp.get());
	}

	
	/**
	 * Retourne le temps d'incantation necessaire pour lancer la competence
	 * @return Double
	 */
	public StringProperty getTempsIncantationProperty() {
		return tempsIncantation;
	}
	
	public Double getTempsIncantation() {
		return Double.parseDouble(tempsIncantation.get());
	}
	
	/**
	 * @param exp the exp to set
	 */
	public void setExp(int exp) {
		this.exp.set(Integer.toString(exp)); 
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom.set(nom);
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description.set(description);
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type.set(type);
	}

	/**
	 * @param nature the nature to set
	 */
	public void setNature(String nature) {
		this.nature.set(nature);
	}

	/**
	 * @param levelMax the levelMax to set
	 */
	public void setLevelMax(int levelMax) {
		this.levelMax.set(Integer.toString(levelMax));
	}

	/**
	 * @param tempsIncantation the tempsIncantation to set
	 */
	public void setTempsIncantation(double tempsIncantation) {
		this.tempsIncantation.set(Double.toString(tempsIncantation));
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
        boolean result = this.getNom() == ((Competence) obj).getNom();
        return result;
    }

        
        

}
