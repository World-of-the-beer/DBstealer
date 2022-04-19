/*  Класс не нужен, писал только для проверки корректности парсинга. Пригодится уже в API
* */
public class Beer {

    public int id;
    public String name;
    public String tagline;
    public String first_brewed;
    public String description;
    public String image_url;
    public float abv;
    public float ibu;
    public float target_fg;
    public float target_og;
    public float ebc;
    public float srm;
    public float ph;
    public float attenuation_level;
    public Object volume;
    public Object boil_volume;
    public Object method;
    public Object ingredients;
    public Object food_pairing;
    public String brewers_tips;
    public String contributed_by;

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tagline='" + tagline + '\'' +
                ", first_brewed='" + first_brewed + '\'' +
                ", description='" + description + '\'' +
                ", image_url='" + image_url + '\'' +
                ", abv=" + abv +
                ", ibu=" + ibu +
                ", target_fg=" + target_fg +
                ", target_og=" + target_og +
                ", ebc=" + ebc +
                ", srm=" + srm +
                ", ph=" + ph +
                ", attenuation_level=" + attenuation_level +
                ", volume=" + volume +
                ", boil_volume=" + boil_volume +
                ", method=" + method +
                ", ingredients=" + ingredients +
                ", food_pairing=" + food_pairing +
                ", brewers_tips='" + brewers_tips + '\'' +
                ", contributed_by='" + contributed_by + '\'' +
                '}';
    }
}
