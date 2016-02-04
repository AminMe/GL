package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Guillaume on 25/01/2016.
 */
@Entity
@Table(name = "Adresse")
public class Adresse extends Model {

    @Id
    @GeneratedValue
    public Long id;
    public String adresse;
    public String zipCode;
    public String ville;
    public String pays;

    public static Model.Finder<Long, Adresse> find = new Model.Finder<>(Adresse.class);

    public Adresse(){}

    public Adresse(String adresse, String zipCode, String ville, String pays) {
        this.adresse = adresse;
        this.zipCode = zipCode;
        this.ville = ville;
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "[Adresse : " + id + "] : " +
                adresse + ", " + zipCode + ", " +
                ville + ", " + pays;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        try {
            Adresse addr = (Adresse) obj;
            return (addr.id.equals(this.id) && addr.adresse.equals(this.adresse) && addr.zipCode.equals(this.zipCode)
            && addr.ville.equals(this.ville) && addr.pays.equals(this.pays));
        } catch (ClassCastException e) {
            return false;
        }
    }


    public static List<Adresse> all() {
        return find.all();
    }

    public static void create(Adresse addr) {
        addr.save();
    }

    public static void delete(Long id) {
        find.ref(id).delete();
    }
}