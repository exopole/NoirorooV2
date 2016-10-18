package statistiques;

/**
 * @author exopole
 *
 */
public abstract class Statistique {

    protected Integer value = 0;
    protected Boolean compute = false;

    /**
     *
     * @param value
     */
    public Statistique(String value) {
        // TODO Auto-generated constructor stub
        this.value = Integer.valueOf(value);
    }

    /**
     *
     * @param value
     */
    public Statistique(Integer value) {
        // TODO Auto-generated constructor stub
        this.value = value;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return value.toString();
    }

    /**
     * @return value
     */
    public Integer getValue() {
        return value;
    }

}
